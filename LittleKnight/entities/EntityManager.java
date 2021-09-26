package srcGame.beginGame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import srcGame.beginGame.Handler;
import srcGame.beginGame.entities.creatures.Player;
import srcGame.beginGame.titles.Tile;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {

        // RENDER ORDER
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            if(!e.isActive())
                entities.remove(e);
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    // lấy bất cứ entity nào đc bỏ vào rồi add vào ArrayList
    // sau đó có thể tick và render
    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


    public int getXCoordinate(float x) {
        return (int) (x * Tile.TILE_WIDTH);
    }

    public int getYCoordinate(float y) {
        return (int) (y * Tile.TILE_HEIGHT);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }
}