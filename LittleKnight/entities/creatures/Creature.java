package srcGame.beginGame.entities.creatures;

import srcGame.beginGame.entities.creatures.Creature;
import srcGame.beginGame.titles.Tile;
import srcGame.beginGame.Handler;
import srcGame.beginGame.entities.Entity;
import srcGame.beginGame.audio.AudioPlayer;

public abstract class Creature extends Entity {
    public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
    public static final int DEFAULT_GRAVITY = 10;

    protected float xMove, yMove;
    protected float gravity = DEFAULT_GRAVITY;

    public boolean jumping = false;
    public boolean falling = true;

    public AudioPlayer audioPlayer;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        audioPlayer = new AudioPlayer();
    }

    // MOVEMENT
    public void move() {
        // if (!checkEntityCollisons(xMove, 0f))
            moveX();
        // if (!checkEntityCollisons(0f, yMove))
            moveY();
    }

    public void moveX() {
        int tempRightX = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH; // where we gonna move
        int tempLeftX = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

        int RightBoundBox = (int) (y + bounds.y) / Tile.TILE_HEIGHT;
        int lowerRightBoundBox = (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

        if (xMove > 0) { // moving right
            if (!collisionWithTile(tempRightX, RightBoundBox) && !collisionWithTile(tempRightX, lowerRightBoundBox))
                x += xMove;
            else {
                x = tempRightX * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
        } else if (xMove < 0) { // moving left
            if (!collisionWithTile(tempLeftX, RightBoundBox) && !collisionWithTile(tempLeftX, lowerRightBoundBox))
                x += xMove;
            else {
                x = tempLeftX * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        int leftCorner = (int) (x + bounds.x) / Tile.TILE_HEIGHT;
        int rightCorner = (int) (x + bounds.x + bounds.width) / Tile.TILE_HEIGHT;

        // JUMP & GRAVITY
        // y < 0
        if (jumping) {
            // gravity: setting how high player can jump
            // the lower gravity value is, the higher player can jump
            int tempY = (int) (y - gravity + bounds.y) / Tile.TILE_HEIGHT;
            if (!collisionWithTile(leftCorner, tempY) && !collisionWithTile(rightCorner, tempY)) {
                gravity -= 0.34;
                y -= gravity;
                if (gravity <= 0) {
                    jumping = false;
                }
            } else {
                // boost system
                // y = tempY * Tile.TILE_HEIGHT + bounds.y + bounds.height - 10;
                y = tempY * Tile.TILE_HEIGHT + bounds.y + bounds.height + 15;
                gravity = 0;
                jumping = false;
            }
        }
        // y > 0
        if (isFalling()) {
            int tempY = (int) (y + gravity + bounds.y + bounds.height + 1) / Tile.TILE_HEIGHT;
            if (!collisionWithTile(leftCorner, tempY) && !collisionWithTile(rightCorner, tempY)) {
                gravity += 0.32;
                y += gravity;
                if (gravity >= DEFAULT_GRAVITY)
                    gravity = DEFAULT_GRAVITY;
            } else {
                y = tempY * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    public boolean isFalling() {

        int leftCorner = (int) (x + bounds.x) / Tile.TILE_HEIGHT;
        int rightCorner = (int) (x + bounds.x + bounds.width) / Tile.TILE_HEIGHT;

        if (!collisionWithTile(leftCorner, (int) (y + 2 + bounds.y + bounds.height) / Tile.TILE_HEIGHT)
                && !collisionWithTile(rightCorner, (int) (y + 2 + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
            if (!jumping)
                return true;
        }
        return false;
    }

    protected boolean collisionWithTile(int x, int y) {
        // check if the object solid
        return handler.getWorld().getTile(x, y).isSolid();
    }

    // Getters and Setters


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setXMove(float xMove) {
        this.xMove = xMove;
    }

    public float getXMover() {
        return xMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }

    public float getYMover() {
        return yMove;
    }
}