package srcGame.beginGame;

import srcGame.beginGame.entities.Entity;
import srcGame.beginGame.entities.creatures.Player;
import srcGame.beginGame.gfx.GameCamera;
import srcGame.beginGame.input.KeyManager;
import srcGame.beginGame.input.MouseManager;
import srcGame.beginGame.worlds.World;

public class Handler {
    private Game game;
    private World world;
    private Entity entity;
    private Player player;

    public Handler (Game game) {
        this.game = game;
    }
    
    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    public Entity getEntity() {
        return entity;
    }

    public Player getPlayer() {
        return player;
    }
}
