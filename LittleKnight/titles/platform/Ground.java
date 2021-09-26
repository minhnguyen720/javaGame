package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class Ground extends Tile {
    public Ground(int id) {
        super(Assets.GROUND, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}