package srcGame.beginGame.entities.statics;
import java.awt.Graphics;

import srcGame.beginGame.Handler;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.states.States;

public class EndFlag extends StaticEntity {

    public EndFlag(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
        setHealth(1000);
    }

    @Override
    public void tick() {
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0))){
            States.setCurrentState(handler.getGame().setGameOverState(States.getCurrentState()));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.flag, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void dead() {
    }
    
}
