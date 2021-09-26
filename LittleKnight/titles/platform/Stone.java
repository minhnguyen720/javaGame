package srcGame.beginGame.titles.platform;

import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.titles.Tile;

public class Stone extends Tile {

    public Stone(int id) {
        super(Assets.STONE, id);
    }
    
    @Override
    public boolean isSolid() {
        return true;
    }
}
