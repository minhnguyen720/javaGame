package srcGame.beginGame.audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

import srcGame.beginGame.GameSetting;

public abstract class AudioClip {

    private final Clip clip;

    public AudioClip(Clip clip) {
        this.clip = clip;
        try {
            clip.open();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        clip.start();
    }

    public void update(GameSetting gameSetting) {
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue(getVolume(gameSetting));
    }

    protected abstract float getVolume(GameSetting gameSetting);

    public boolean hasFinishedPlaying() {
        return !clip.isRunning();
    }

    public void cleanUp() {
        clip.close();
    }
}
