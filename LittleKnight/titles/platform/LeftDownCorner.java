package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class LeftDownCorner extends Tile {
    public LeftDownCorner(int id) {
        super(Assets.LEFT_DOWN_CORNER, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}