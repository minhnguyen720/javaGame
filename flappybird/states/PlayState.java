package com.willie.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.willie.game.FlappyDemo;
import com.willie.game.audio.SoundEffect;
import com.willie.game.sprites.Bird;
import com.willie.game.sprites.Tube;

public class PlayState extends State {
    private static final int GROUND_Y_OFFSET = -40;
    private static final int TUBE_COUNT = 4;
    
    private boolean IS_LOSE = false;
    private int TUBE_SPACING = 130;
    private int POINT = 0;

    private final Bird bird;
    private final Texture background, ground;
    public BitmapFont font25;
    private final Vector2 groundPos1, groundPos2;
    private final Array<Tube> tubes;
    private final SoundEffect sfx;
    private Tube tube;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        initFont();

        bird = new Bird(10, 250);
        bird.setMovement(100);

        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);

        background = new Texture("bg.png");
        ground = new Texture("ground.png");

        groundPos1 = new Vector2((cam.position.x - (cam.viewportWidth / 2)), GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x - (cam.viewportWidth / 2) + ground.getWidth()), GROUND_Y_OFFSET);

        sfx = new SoundEffect();
        tubes = new Array<Tube>();

        addTube();

        System.out.println("================================ GAME REPORT ====================================");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        updateGround();
        bird.update(deltaTime);
        collisionCheck();
        cam.update();
        checkLose();
    }

    @Override
    public void render(SpriteBatch sb) {

        // example: the bench is 2 meters wide in the park is translated to 380 pixels
        // on the photo, this is called projection matrix.
        // cam.combined describes where things in the game world should be rendered to
        // the screen.
        // sb.setProjectionMatrix(cam.combined) means instruct the game knows that
        // things appear in viewport need to be rendered.
        // whenever the camera moved or resized the screen you should call
        // setProjectionMatrix.
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBotTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
            sb.draw(ground, groundPos1.x, groundPos1.y, ground.getWidth(), ground.getHeight());
            sb.draw(ground, groundPos2.x, groundPos2.y, ground.getWidth(), ground.getHeight());
        }
        font25.draw(sb, Integer.toString(POINT), cam.position.x - 15, cam.viewportHeight / 2 + 150);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        bird.dispose();
        ground.dispose();
        sfx.dispose();
        font25.dispose();
        
        for (Tube tube : tubes) {
            tube.dispose();
        }
    }

    private void updateGround() {
        if ((cam.position.x - (cam.viewportWidth / 2)) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if ((cam.position.x - (cam.viewportWidth / 2)) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }

    private void initFont() {
        FreeTypeFontGenerator number = new FreeTypeFontGenerator(Gdx.files.internal("number.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontProperty = new FreeTypeFontGenerator.FreeTypeFontParameter();

        fontProperty.size = 25;
        fontProperty.color = Color.WHITE;
        fontProperty.borderWidth = 1.5f;
        fontProperty.borderColor = Color.BLACK;
        font25 = number.generateFont(fontProperty);
    }

    private void checkLose() {
        if (IS_LOSE) {
            gsm.set(new GameOverState(gsm, POINT));
        }
    }

    private void collisionCheck() {
        cam.position.x = bird.getPosition().x + 105;

        for (int i = 0; i < tubes.size; i++) {
            tube = tubes.get(i);

            if ((cam.position.x - (cam.viewportWidth / 2)) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                sfx.playCrossed();
                POINT++;

                bird.increseSpeed();

                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if (tube.collisionChecker(bird.getPlayerBound())) {
                sfx.playHit();
                IS_LOSE = true;
            }
        }

        if (bird.getPosition().y < ground.getHeight() + GROUND_Y_OFFSET) {
            sfx.playHit();
            IS_LOSE = true;
        }
    }

    private void addTube() {
        for (int i = 1; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
    }
}


