package com.willie.game.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Audio {
    private Music music;

    public Audio() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.12f);
        music.play();
    }

    public Music getMusic() {
        return music;
    }

    public void dispose() {
        music.dispose();
    }
}
