package srcGame.beginGame.titles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import srcGame.beginGame.titles.platform.*;

public class Tile { 

    // STATIC STUFF HERE
    public static Tile[] tiles = new Tile[256];

    // grass tile
    public static Tile grassTile = new GrassTile(0);
    //ground
    public static Tile ground = new Ground(1);
    // left corner
    public static Tile leftCorner = new LeftCorner(2);
    // right corner
    public static Tile rightCorner = new RightCorner(3);
    // middle
    public static Tile middle = new Middle(4);
    // background
    public static Tile backgroundTile = new BackgroundTile(5);
    // left side
    public static Tile leftSide = new LeftSide(6);
    // right side
    public static Tile rightSide = new RightSide(7);
    //bottom
    public static Tile bottom = new Bottom(8);
    // platform
    public static Tile stone = new Stone(9);
    // right down corner
    public static Tile rightDownCorner = new RightDownCorner(10);
    // left down corner
    public static Tile leftDownConer = new LeftDownCorner(11);

    // CLASS
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        // using id to access texture 
        tiles[id] = this; 
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }

}