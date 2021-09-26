package srcGame.beginGame.states;

import java.awt.Color;
import java.awt.Graphics;

import srcGame.beginGame.Handler;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.gfx.Text;
import srcGame.beginGame.ui.ClickListener;
import srcGame.beginGame.ui.UIImageButton;
import srcGame.beginGame.ui.UIManager;

public class TutorialState extends States {

    private UIManager uiManager;

    public TutorialState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        uiManager.addUIObject(new UIImageButton(190, 410, 250, 64, Assets.againButton, new ClickListener() {

            @Override
            public void onClick() {
                States.setCurrentState(handler.getGame().setGameState(States.getCurrentState()));
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
        g.drawImage(Assets.tutorial, 0, 0, 640, 400 ,null);
        Text.drawString(g, "> Next <", 314, 443, true, Color.WHITE, Assets.font15);
    }
}
