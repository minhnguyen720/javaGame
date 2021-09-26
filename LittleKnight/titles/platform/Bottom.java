package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class Bottom extends Tile {

    public Bottom(int id) {
        super(Assets.BOTTOM, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
