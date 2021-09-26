package srcGame.beginGame.entities.statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import srcGame.beginGame.Handler;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class Spike extends StaticEntity {
    public Spike(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
    }

    private void checkAttacks() {
        Rectangle collisionBounds = getCollisionBounds(-2, 0);
        Rectangle attackRectangle = new Rectangle();
        int ATTACK_RECTANGLE_SIZE = 30; // attack range
        attackRectangle.width = ATTACK_RECTANGLE_SIZE + 7;
        attackRectangle.height = ATTACK_RECTANGLE_SIZE;

        float playerY = handler.getWorld().getEntityManager().getPlayer().getY();

        if (Math.abs(playerY - getY()) < ATTACK_RECTANGLE_SIZE) {

            attackRectangle.x = collisionBounds.x + collisionBounds.width / 2 - ATTACK_RECTANGLE_SIZE / 2;
            attackRectangle.y = collisionBounds.y - ATTACK_RECTANGLE_SIZE / 2;
        }

        if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(attackRectangle)) {
            handler.getWorld().getEntityManager().getPlayer().hurt(100);
            System.out.println("ouch");
        }
    }

    @Override
    public void tick() {
        checkAttacks();
    }

    @Override
    public void dead() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spike, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}
