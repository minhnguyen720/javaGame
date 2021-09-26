package srcGame.beginGame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import srcGame.beginGame.Handler;
import srcGame.beginGame.audio.AudioPlayer;

public abstract class Entity {
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    public int health;
    protected float speed;
    protected boolean active = true; // creature that has false active status will be remove from the game
    public AudioPlayer audioPlayer;

    public static int DEFAULT_HEALTH = 100;
    public static final float DEFAULT_SPEED = 2.55f;
    public boolean solid;
    public boolean jumping = false;
    public boolean falling = true;
    public boolean hitted = false;
    public float gravity = 0;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        audioPlayer = new AudioPlayer();

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void dead();

    public void hurt(int amt) {
        hitted = true;
        health -= amt;
        if (health <= 0) {
            active = false;
            dead();
        }
    }

    // test every entities in our game
    public boolean checkEntityCollisons(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    // return a rectangle and this rectangle cover the entity that is solid
    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
                bounds.height);
    }

    // Getters and Setters
    // Method that return a private variable that other method can access it
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}