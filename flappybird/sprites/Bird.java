package com.willie.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.willie.game.audio.SoundEffect;

public class Bird {

    private static final int GRAVITY = -15;
    public static int MOVEMENT = 100, flyPoint = 0 , MAX_FLY_POINT = 5;

    // Vector3 means a vector with 3 dimensions
    private Vector3 position;
    private Vector3 velocity;

    private Animation birdAnimation;

    private Rectangle playerBound;

    private Texture bird;

    private SoundEffect wingSound;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);

        bird = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(bird), 3, 0.5f);

        wingSound = new SoundEffect();

        playerBound = new Rectangle(x, y, bird.getWidth() / 3, bird.getHeight());
    }

    public void update(float deltaTime) {
        birdAnimation.update(deltaTime);

        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);

        velocity.scl(deltaTime); // scl means multiply this vector by a scalar

        position.add(MOVEMENT * deltaTime, velocity.y, 0);

        if (position.y < 0)
            position.y = 0;

        velocity.scl(1 / deltaTime); // reset value for a new loop
        playerBound.setPosition(position.x, position.y);
    }

    public void dispose() {
        bird.dispose();
        wingSound.dispose();
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public int getMovement() {
        return MOVEMENT;
    }

    public void setMovement(int MOVEMENT) {
        Bird.MOVEMENT = MOVEMENT;
    }

    public Rectangle getPlayerBound() {
        return playerBound;
    }

    public void jump() {
        velocity.y = 250;
        wingSound.playWing();
    }

    public void increseSpeed() {
        int spdValue = 8;
        flyPoint++;
        System.out.println("MAX FLY POINT: " + MAX_FLY_POINT + ", fly point: " + flyPoint);

        if (flyPoint == MAX_FLY_POINT) {
            MOVEMENT += spdValue;
            this.setMovement(MOVEMENT);

            System.out.println("Speed Incresed, Current Speed: " + MOVEMENT);
            System.out.println(" ");

            if(MAX_FLY_POINT > 2)
                MAX_FLY_POINT--;

            flyPoint = 0;
        }
    }

}
