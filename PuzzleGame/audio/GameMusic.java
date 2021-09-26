package com.willie.game.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class GameMusic {
    private Music music;
    private Sound sound;


    public GameMusic() {
        music = Gdx.audio.newMusic(Gdx.files.internal("audio/music/Siddhartha Corsus - Bhagavan.mp3"));
        sound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/sfx_point.wav"));
    }

    public void playMusic() {
        music.setLooping(true);
        music.setVolume(0.12f);
        music.play();
        System.out.println("PLAY MUSIC");
    }

    public void playSound() {
        sound.play(0.12f);

    }

    public void dispose() {
        music.dispose();
    }
}
