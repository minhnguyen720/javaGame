package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class RightDownCorner extends Tile {
    public RightDownCorner(int id) {
        super(Assets.RIGHT_DOWN_CORNER, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}