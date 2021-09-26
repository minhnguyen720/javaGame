package srcGame.beginGame.states;

import java.awt.Graphics;

import srcGame.beginGame.Handler;
import srcGame.beginGame.worlds.World;
public class GameState extends States {
    private World testWorld;

    public GameState(Handler handler) {
        // Để render theo tọa độ x,y thì nhân thêm với tile witdth và tile height
        super(handler);

        testWorld = new World(handler, "/LittleKnight/Workspace/MyGame/res/worlds/testingWorld.txt");
        handler.setWorld(testWorld);
    }

    @Override
    public void tick() {
        // world file need to load firstly
        testWorld.tick();
    }

    @Override
    public void render(Graphics g) {
        testWorld.render(g);
    }
}
