package srcGame.beginGame.gfx;

import srcGame.beginGame.Handler;
import srcGame.beginGame.entities.Entity;
import srcGame.beginGame.titles.Tile;

public class GameCamera {
    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace() {
        int widthWorldPixel = handler.getWorld().getWidth() * Tile.TILE_WIDTH;
        int heightWorldPixel = handler.getWorld().getHeight() * Tile.TILE_HEIGHT;
        if (xOffset < 0)
            xOffset = 0;
        else if (xOffset > widthWorldPixel - handler.getWidth())
            xOffset = widthWorldPixel - handler.getWidth(); // handler.getWidth: the width of the window
        if (yOffset < 0)
            yOffset = 0;
        else if (yOffset > heightWorldPixel - handler.getHeight())
            yOffset = heightWorldPixel - handler.getHeight();
    }

    // set x and y offset to be a correct number that game camera center around the
    // entity that we passed
    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    // GETTERS AND SETTERS
    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
