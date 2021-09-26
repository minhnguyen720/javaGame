package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class RightCorner extends Tile {
    public RightCorner(int id) {
        super(Assets.RIGHT_CORNER, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}