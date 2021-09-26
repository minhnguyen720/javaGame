package com.willie.game.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundEffect {
    private Sound wing, hit, crossed;

    public SoundEffect() {
        wing = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
        hit = Gdx.audio.newSound(Gdx.files.internal("sfx_hit.ogg"));
        crossed = Gdx.audio.newSound(Gdx.files.internal("sfx_point.wav"));
    }

    public void playWing() {
        wing.play(0.25f);
    }

    public void playCrossed() {
        crossed.play(0.2f);
    }

    public void playHit() {
        hit.play(0.2f);
    }

    public void dispose() {
        wing.dispose();
        crossed.dispose();
    }
}
