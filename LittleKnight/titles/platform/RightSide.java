package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class RightSide extends Tile {

    public RightSide(int id) {
        super(Assets.RIGHT_SIDE, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
