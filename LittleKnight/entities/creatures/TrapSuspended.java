package srcGame.beginGame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import srcGame.beginGame.Handler;
import srcGame.beginGame.gfx.Animation;
import srcGame.beginGame.gfx.Assets;

public class TrapSuspended extends Creature {
    private Animation trapActive;

    public TrapSuspended(Handler handler, float x, float y,int width,int height) {
        super(handler, x, y, width, height);

        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);

        trapActive = new Animation(150, Assets.trap);
    }

    private void checkAttacks() {
        Rectangle collisionBounds = getCollisionBounds(0, 0);
        Rectangle attackRectangle = new Rectangle();
        int ATTACK_RECTANGLE_SIZE = 30; // attack range
        attackRectangle.width = ATTACK_RECTANGLE_SIZE;
        attackRectangle.height = ATTACK_RECTANGLE_SIZE;

        float playerX = handler.getWorld().getEntityManager().getPlayer().getX();

        if (Math.abs(playerX - getX()) < ATTACK_RECTANGLE_SIZE) {
            if (playerX < getX()) {
                attackRectangle.x = collisionBounds.x - ATTACK_RECTANGLE_SIZE;
                attackRectangle.y = collisionBounds.y + collisionBounds.height / 2 - ATTACK_RECTANGLE_SIZE / 2;
            }
        } else if (playerX > getX()) {
            attackRectangle.x = collisionBounds.x + collisionBounds.width;
            attackRectangle.y = collisionBounds.y + collisionBounds.height / 2 - ATTACK_RECTANGLE_SIZE / 2;
        } else
            return;

        if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(attackRectangle)) {
            handler.getWorld().getEntityManager().getPlayer().hurt(100);
            System.out.println("ouch");
        }

    }

    @Override
    public void tick() {
        trapActive.tick();
        checkAttacks();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    public BufferedImage getCurrentAnimationFrame() {
        return trapActive.getCurrentFrame();
    }

    @Override
    public void dead() {
    }

}
