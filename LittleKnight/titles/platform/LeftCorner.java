package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class LeftCorner extends Tile {
    public LeftCorner(int id) {
        super(Assets.LEFT_CORNER, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}