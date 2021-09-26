package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class LeftSide extends Tile {

    public LeftSide(int id) {
        super(Assets.LEFT_SIDE,id);
    }
    
    @Override
    public boolean isSolid() {
        return true;
    }
}
