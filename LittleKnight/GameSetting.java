package srcGame.beginGame;

public class GameSetting {

    private float musicVolume;
    private float soundVolume;

    public GameSetting() {
        musicVolume = 0;
        soundVolume = 0;
    }

    public float getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public float getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(float soundVolume) {
        this.soundVolume = soundVolume;
    }
}
