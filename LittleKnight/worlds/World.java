package srcGame.beginGame.worlds;

import java.awt.Graphics;

import srcGame.beginGame.titles.Tile;
import srcGame.beginGame.utils.Utils;
import srcGame.beginGame.Handler;
import srcGame.beginGame.entities.EntityManager;
import srcGame.beginGame.entities.statics.*;
import srcGame.beginGame.entities.creatures.*;

public class World {
        private Handler handler;
        private int width, height;
        private int spawnX, spawnY;
        // contain id of tiles
        private int[][] tiles;

        // Entities
        private EntityManager entityManager;

        public World(Handler handler, String path) {
                this.handler = handler;
                entityManager = new EntityManager(handler, new Player(handler, 0, 0));
                // SPIKE ADDING SESSION

                // 1st floor
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(11), entityManager.getYCoordinate(51)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(12), entityManager.getYCoordinate(51)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(23), entityManager.getYCoordinate(44)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(17), entityManager.getYCoordinate(51)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(18), entityManager.getYCoordinate(51)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(27), entityManager.getYCoordinate(51)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(28), entityManager.getYCoordinate(51)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(29), entityManager.getYCoordinate(51)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(33), entityManager.getYCoordinate(50)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(37), entityManager.getYCoordinate(51)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(38), entityManager.getYCoordinate(51)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(39), entityManager.getYCoordinate(51)));
                // 2nd floor
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(30), entityManager.getYCoordinate(38)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(28), entityManager.getYCoordinate(36)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(23), entityManager.getYCoordinate(38)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(24), entityManager.getYCoordinate(38)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(21), entityManager.getYCoordinate(34)));
                entityManager.addEntity(new SpikeReverse(handler, entityManager.getXCoordinate(14),
                                entityManager.getYCoordinate(29)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(13), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(12), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(11), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(10), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(9), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(8), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(7), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(6), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(5), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(4), entityManager.getYCoordinate(36)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(3), entityManager.getYCoordinate(36)));

                // 3rd floor
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(10), entityManager.getYCoordinate(26)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(16), entityManager.getYCoordinate(22)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(21), entityManager.getYCoordinate(26)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(23), entityManager.getYCoordinate(26)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(29), entityManager.getYCoordinate(28)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(31), entityManager.getYCoordinate(28)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(29), entityManager.getYCoordinate(28)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(32), entityManager.getYCoordinate(14)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(29), entityManager.getYCoordinate(28)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(31), entityManager.getYCoordinate(16)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(29), entityManager.getYCoordinate(28)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(15), entityManager.getYCoordinate(16)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(17), entityManager.getYCoordinate(8)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(22), entityManager.getYCoordinate(6)));

                entityManager.addEntity(new SpikeRight(handler, entityManager.getXCoordinate(28),
                                entityManager.getYCoordinate(8)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(30), entityManager.getYCoordinate(9)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(31), entityManager.getYCoordinate(9)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(33), entityManager.getYCoordinate(9)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(34), entityManager.getYCoordinate(9)));

                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(32), entityManager.getYCoordinate(4)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(29), entityManager.getYCoordinate(4)));
                entityManager.addEntity(
                                new Spike(handler, entityManager.getXCoordinate(27), entityManager.getYCoordinate(4)));

                // TRAP ADDING SESSION
                entityManager.addEntity(new TrapSuspended(handler, entityManager.getXCoordinate(8),
                                entityManager.getYCoordinate(16), 80, 70));
                entityManager.addEntity(new TrapSuspended(handler, entityManager.getXCoordinate(6),
                                entityManager.getYCoordinate(16), 80, 70));


                // END FLAG                
                entityManager.addEntity(new EndFlag(handler, entityManager.getXCoordinate(3),
                                entityManager.getYCoordinate(5), 100, 200));

                // GOBLIN ADDING SESSION

                // 1st floor
                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(6),
                                entityManager.getYCoordinate(47), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(15),
                                entityManager.getYCoordinate(45), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(25),
                                entityManager.getYCoordinate(42), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(35),
                                entityManager.getYCoordinate(48), 48, 48));

                // 2nd floor
                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(34),
                                entityManager.getYCoordinate(38), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(32),
                                entityManager.getYCoordinate(38), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(8),
                                entityManager.getYCoordinate(25), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(25),
                                entityManager.getYCoordinate(35), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(26),
                                entityManager.getYCoordinate(23), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(32),
                                entityManager.getYCoordinate(26), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(32),
                                entityManager.getYCoordinate(23), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(27),
                                entityManager.getYCoordinate(21), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(29),
                                entityManager.getYCoordinate(21), 48, 48));

                // 3rd floor

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(21),
                                entityManager.getYCoordinate(14), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(24),
                                entityManager.getYCoordinate(15), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(1),
                                entityManager.getYCoordinate(13), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(10),
                                entityManager.getYCoordinate(8), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(13),
                                entityManager.getYCoordinate(8), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(20),
                                entityManager.getYCoordinate(6), 48, 48));

                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(36),
                                entityManager.getYCoordinate(7), 48, 48));

                // 4th floor
                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(34),
                                entityManager.getYCoordinate(2), 48, 48));
                entityManager.addEntity(new Goblin(handler, entityManager.getXCoordinate(24),
                                entityManager.getYCoordinate(2), 48, 48));
                // LOAD WORD SESSION
                loadWorld(path);

                entityManager.getPlayer().setX(spawnX);
                entityManager.getPlayer().setY(spawnY);
        }

        // update everything continuosly
        public void tick() {
                entityManager.tick();
        }

        public void render(Graphics g) {
                int xMoveLeftInPixel = (int) handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH;
                int xMoveRightInPixel = (int) ((handler.getGameCamera().getxOffset() + handler.getWidth())
                                / Tile.TILE_WIDTH + 1);

                int yMoveUpInPixel = (int) handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT;
                int yMoveDownInPixel = (int) ((handler.getGameCamera().getyOffset() + handler.getHeight())
                                / Tile.TILE_HEIGHT + 1);

                // Check if player move
                int xStart = (int) Math.max(0, xMoveLeftInPixel);
                int xEnd = (int) Math.min(width, xMoveRightInPixel);

                int yStart = (int) Math.max(0, yMoveUpInPixel);
                int yEnd = (int) Math.min(height, yMoveDownInPixel);
                for (int y = yStart; y < yEnd; y++)
                        for (int x = xStart; x < xEnd; x++) {
                                // since we render in terms of pixels, and our tiles are 64x64 pixels in size
                                // all of the tiles were drawn ontop of one another because the tiles[][] uses
                                // tile coordinates - not pixel
                                // so its gap it real small so we need to convert from coordinate to pixels
                                // since GameCamera work in float so we need to cast it to int
                                getTile(x, y).render(g,
                                                (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                                                (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
                        }
                entityManager.render(g);
        }

        public Tile getTile(int x, int y) {
                if (x < 0 || y < 0 || x >= width || y >= height)
                        return Tile.ground;

                // base on index, this method loads tiles correspond to its location
                Tile t = Tile.tiles[tiles[x][y]];
                if (t == null)
                        return Tile.ground;
                return t;
        }

        // get the file from computer and load all the data from it
        private void loadWorld(String path) {
                String file = Utils.loadFileAsString(path);
                String[] tokens = file.split("\\s+");

                width = Utils.parseInt(tokens[0]);
                height = Utils.parseInt(tokens[1]);
                spawnX = Utils.parseInt(tokens[2]);
                spawnY = Utils.parseInt(tokens[3]);

                tiles = new int[width][height];
                for (int y = 0; y < height; y++)
                        for (int x = 0; x < width; x++)
                                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
        }

        public EntityManager getEntityManager() {
                return entityManager;
        }

        public int getWidth() {
                return width;
        }

        public int getHeight() {
                return height;
        }

}