package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class GrassTile extends Tile {
    public GrassTile(int id) {
        super(Assets.GRASS_TILE,id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
