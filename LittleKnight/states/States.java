package srcGame.beginGame.states;

import java.awt.Graphics;

import srcGame.beginGame.Handler;
import srcGame.beginGame.audio.AudioPlayer;

public abstract class States {
    private static States currentState = null;
    protected AudioPlayer audioPlayer;

    public static void setCurrentState(States state) {
        currentState = state;
    }

    public static States getCurrentState() {
        return currentState;
    }

    // CLASS
    protected Handler handler;

    public States(Handler handler) {
        this.handler = handler;
        audioPlayer = new AudioPlayer();
        
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
