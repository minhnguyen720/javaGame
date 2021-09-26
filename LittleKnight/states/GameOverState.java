package srcGame.beginGame.states;

import java.awt.Color;
import java.awt.Graphics;

import srcGame.beginGame.ui.ClickListener;
import srcGame.beginGame.ui.UIImageButton;
import srcGame.beginGame.ui.UIManager;
import srcGame.beginGame.Handler;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.gfx.Text;

public class GameOverState extends States {

    private UIManager uiManager;

    public GameOverState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        uiManager.addUIObject(new UIImageButton(190, 250, 250, 64, Assets.againButton, new ClickListener() {

            @Override
            public void onClick() {
                States.setCurrentState(handler.getGame().setGameState(States.getCurrentState()));
            }
        }));

        uiManager.addUIObject(new UIImageButton(250, 320, 128, 64, Assets.quitButton, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(1);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
        Text.drawString(g, "GAME OVER", 320, 150, true, Color.WHITE, Assets.font28);
        Text.drawString(g, "> Play Again <", 315, 285, true, Color.WHITE, Assets.font15);
        Text.drawString(g, "> Quit <", 315, 353, true, Color.WHITE, Assets.font15);
    }
}
