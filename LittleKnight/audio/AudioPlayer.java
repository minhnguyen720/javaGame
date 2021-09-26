package srcGame.beginGame.audio;

import srcGame.beginGame.GameSetting;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {
    private List<AudioClip> audioClips;
    private long lastAudioTimer, audioCooldown = 200, audioTimer = audioCooldown;

    public AudioPlayer() {
        audioClips = new ArrayList<>();
    }

    public void update(GameSetting gameSetting) {
        audioClips.forEach(audioClip -> audioClip.update(gameSetting));

        List.copyOf(audioClips).forEach(audioClip -> {
            if (audioClip.hasFinishedPlaying()) {
                audioClip.cleanUp();
                audioClips.remove(audioClip);
            }
        });
    }

    public void playMusic(String fileName) {
        final Clip clip = getClip(fileName);
        audioClips.add(new MusicClip(clip));
    }

    public void playSound(String fileName) {
        audioTimer += System.currentTimeMillis() - lastAudioTimer;
        lastAudioTimer = System.currentTimeMillis();
        if (audioTimer < audioCooldown)
        return;
        
        final Clip clip = getClip(fileName);
        audioClips.add(new SoundClip(clip));

        audioTimer = 0;
    }

    private Clip getClip(String fileName) {
        final File soundFile = new File("/LittleKnight/Workspace/MyGame/res/audio/" + fileName);
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)) {
            final Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(0);
            return clip;

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        return null;
    }
}