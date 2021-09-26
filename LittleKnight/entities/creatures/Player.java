package srcGame.beginGame.entities.creatures;

import java.awt.Color;
// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import srcGame.beginGame.Handler;
import srcGame.beginGame.entities.Entity;
import srcGame.beginGame.gfx.Animation;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.gfx.Text;
import srcGame.beginGame.states.States;

public class Player extends Creature {
    private Handler handler;
    private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;

    // ANIMATIONS
    private Animation runRightAnimation, runLeftAnimation, idleAnimation, idleReverseAnimation, attackLeftAnimation,
            attackRightAnimation, gotHittedAnimation, jumpAnimation;
    private boolean facingRight = true;
    private boolean attack = false;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.handler = handler;
        setHealth(10);

        bounds.x = 5; // khoảng cách giữa bounding box và vật cản theo trục x tính bằng pixel, vị trí
                      // x của bounding box trên player
        bounds.y = 20; // khoảng cách giữa bounding box và vật cản theo trục y tính bằng pixel, vị trí
                       // x của bounding box trên player
        // kích thước của bounding box
        bounds.width = width / 2;
        bounds.height = height / 2;

        // tăng thời gian = animation chậm
        // giảm thời gian = animation nhanh
        runRightAnimation = new Animation(120, Assets.playerRunRight);
        runLeftAnimation = new Animation(120, Assets.playerRunLeft);
        idleAnimation = new Animation(130, Assets.playerIdle);
        idleReverseAnimation = new Animation(130, Assets.playerIdleReverse);
        gotHittedAnimation = new Animation(150, Assets.playerGotHitted);
        jumpAnimation = new Animation(150, Assets.playerJump);
        attackRightAnimation = new Animation(50, Assets.playerAttackRight);
        attackLeftAnimation = new Animation(50, Assets.playerAttackLeft);

    }

    @Override
    public void tick() {
        // Animations
        idleAnimation.tick();
        idleReverseAnimation.tick();
        runRightAnimation.tick();
        runLeftAnimation.tick();
        gotHittedAnimation.tick();
        attackRightAnimation.tick();
        attackLeftAnimation.tick();

        getPlayerHealth();
        getInput();
        move(); // define in Creature class
        handler.getGameCamera().centerOnEntity(this);

        // Attack
        checkAttacks();
    }

    @Override
    public void hurt(int amt) {
        super.hurt(amt);
        audioPlayer.playSound("hit5.wav");
    }

    private void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;

        Rectangle collisionBounds = getCollisionBounds(0, 0);
        Rectangle attackRectangle = new Rectangle();
        int ATTACK_RECTANGLE_SIZE = 20; // attack range
        attackRectangle.width = ATTACK_RECTANGLE_SIZE;
        attackRectangle.height = ATTACK_RECTANGLE_SIZE;

        if (handler.getKeyManager().attackLeft) {
            attackRectangle.x = collisionBounds.x - ATTACK_RECTANGLE_SIZE;
            attackRectangle.y = collisionBounds.y + collisionBounds.height / 2 - ATTACK_RECTANGLE_SIZE / 2;
            audioPlayer.playSound("swish_4.wav");
        } else if (handler.getKeyManager().attackRight) {
            attackRectangle.x = collisionBounds.x + collisionBounds.width;
            attackRectangle.y = collisionBounds.y + collisionBounds.height / 2 - ATTACK_RECTANGLE_SIZE / 2;
            audioPlayer.playSound("swish_4.wav");
        } else
            return;

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(attackRectangle)) {
                e.hurt(10);
                return;
            }
        }

    }

    public String getPlayerHealth() {
        return Integer.toString(health);
    }

    @Override
    public void dead() {
        States.setCurrentState(handler.getGame().setGameOverState(States.getCurrentState()));
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().jump)
            if (!jumping && !isFalling()) {
                jumping = true;
                gravity = DEFAULT_GRAVITY;
                audioPlayer.playSound("jump.wav");
            }
        if (handler.getKeyManager().left) {
            xMove = -speed;
            facingRight = false;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
            facingRight = true;
        }
        if (handler.getKeyManager().attackLeft) {
            facingRight = false;
            attack = true;
        }

        if (handler.getKeyManager().attackRight) {
            facingRight = true;
            attack = true;
        }
    }

    // add width and height variable to generate size for player and other creature
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        Text.drawString(g, "Health: " + this.getPlayerHealth(), 60, 20, true, Color.WHITE, Assets.font10);

        // COLLISION CHECKER
        if (handler.getKeyManager().collisionCheckOn) {
            g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
        }
    }

    // Animation manager
    // run, jump,hitted,attack
    public BufferedImage getCurrentAnimationFrame() {
        if (xMove > 0) {
            return runRightAnimation.getCurrentFrame();
        } else if (xMove < 0)
            return runLeftAnimation.getCurrentFrame();

        if (jumping)
            return jumpAnimation.getCurrentFrame();
        if (hitted) {
            hitted = false;
            return gotHittedAnimation.getCurrentFrame();
        }

        if (!attack && facingRight)
            return idleAnimation.getCurrentFrame();
        if (attack && facingRight) {
            attack = false;
            return attackRightAnimation.getCurrentFrame();
        }
        if (attack && !facingRight) {
            attack = false;
            return attackLeftAnimation.getCurrentFrame();
        }

        return idleReverseAnimation.getCurrentFrame();
    }
}