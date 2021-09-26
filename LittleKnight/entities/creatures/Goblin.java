package srcGame.beginGame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import srcGame.beginGame.Handler;
import srcGame.beginGame.gfx.Animation;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class Goblin extends Creature {
    private float spawnX;

    private boolean moveRight = true;
    private boolean moveLeft = false;
    private boolean facingRight = true;

    private boolean attack = false;

    private long lastAttackTimer, attackCooldown = 600, attackTimer = attackCooldown;

    private Animation runRightAnimation, runLeftAnimation, attackLeftAnimation, attackRightAnimation,
            gotHittedAnimation;

    public Goblin(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        setHealth(20);
        
        spawnX = x;

        bounds.x = 4;
        bounds.y = 32;
        bounds.width = width;
        bounds.height = height;

        // animation
        runRightAnimation = new Animation(120, Assets.goblinRunRight);
        runLeftAnimation = new Animation(120, Assets.goblinRunLeft);
        gotHittedAnimation = new Animation(100, Assets.goblinGotHitted);
        attackRightAnimation = new Animation(150, Assets.goblinAttackRight);
        attackLeftAnimation = new Animation(150, Assets.goblinAttackLeft);
    }

    @Override
    public void tick() {
        move();
        checkAttack();

        // animation
        runRightAnimation.tick();
        runLeftAnimation.tick();
        gotHittedAnimation.tick();
        attackRightAnimation.tick();
        attackLeftAnimation.tick();
    }

    @Override
    public void hurt(int amt) {
        super.hurt(amt);
        audioPlayer.playSound("monster_5.wav");
    }

    public void checkAttack() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;

        Rectangle collisionBounds = getCollisionBounds(0, 0);
        Rectangle attackRectangle = new Rectangle();
        int ATTACK_RECTANGLE_SIZE = 18; // attack range
        attackRectangle.width = ATTACK_RECTANGLE_SIZE;
        attackRectangle.height = ATTACK_RECTANGLE_SIZE;

        float playerX = handler.getWorld().getEntityManager().getPlayer().getX();

        if (Math.abs(playerX - getX()) < ATTACK_RECTANGLE_SIZE) {
            if (playerX < getX()) {
                attackRectangle.x = collisionBounds.x - ATTACK_RECTANGLE_SIZE;
                attackRectangle.y = collisionBounds.y + collisionBounds.height / 2 - ATTACK_RECTANGLE_SIZE / 2;
                attack = true;
                facingRight = true;
            }
        } else if (playerX > getX()) {
            attackRectangle.x = collisionBounds.x + collisionBounds.width;
            attackRectangle.y = collisionBounds.y + collisionBounds.height / 2 - ATTACK_RECTANGLE_SIZE / 2;
            attack = true;
            facingRight = false;
        } else
            return;

        attackTimer = 0;

        if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(attackRectangle)) {
            handler.getWorld().getEntityManager().getPlayer().hurt(1);
            System.out.println("ouch");
        }
    }

    @Override
    public void moveX() {
        int tempRightX = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
        int tempLeftX = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

        int upperBoundBox = (int) (y + bounds.y) / Tile.TILE_HEIGHT;
        int lowerBoundBox = (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

        int limitXTile = (int) spawnX / Tile.TILE_WIDTH;
        if (moveRight) {
            x++;
            if ((int) x / Tile.TILE_WIDTH > limitXTile || collisionWithTile(tempRightX, upperBoundBox)
                    || collisionWithTile(tempRightX, lowerBoundBox)) {
                moveRight = false;
                moveLeft = true;
            }
        }
        if (moveLeft) {
            x--;
            if ((int) x / Tile.TILE_WIDTH < limitXTile || collisionWithTile(tempLeftX, upperBoundBox)
                    || collisionWithTile(tempLeftX, lowerBoundBox)) {
                moveLeft = false;
                moveRight = true;
            }
        }
    }

    @Override
    public void dead() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    // animation maanger
    public BufferedImage getCurrentAnimationFrame() {
        if (hitted) {
            hitted = false;
            return gotHittedAnimation.getCurrentFrame();
        }

        if (!attack && moveRight)
            return runRightAnimation.getCurrentFrame();
        else if (!attack && moveLeft)
            return runLeftAnimation.getCurrentFrame();

        if (attack && facingRight) {
            attack = false;
            return attackRightAnimation.getCurrentFrame();
        }
        if (attack && !facingRight) {
            attack = false;
            return attackLeftAnimation.getCurrentFrame();
        }
        return runRightAnimation.getCurrentFrame();
    }
}
