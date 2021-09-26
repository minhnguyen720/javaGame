package com.willie.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.willie.game.FlappyDemo;

public class GameOverState extends State {
    private Texture background, announcement, playButton;
    private Vector2 announcementPos, playButtonPos, backgroundPos, numberPos;
    private BitmapFont number;

    private int point;

    protected GameOverState(GameStateManager gsm, int point) {
        super(gsm);
        initFont();
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);

        this.point = point;

        background = new Texture("bg.png");
        announcement = new Texture("gameover.png");
        playButton = new Texture("playbtn.png");

        announcementPos = new Vector2(cam.position.x - cam.viewportWidth / 2 + 23, 270);
        playButtonPos = new Vector2(cam.position.x - cam.viewportWidth / 2 + 89, 105);
        backgroundPos = new Vector2(cam.position.x - cam.viewportWidth / 2, 0);

        if (point < 10)
            numberPos = new Vector2(cam.position.x - (cam.viewportWidth / 2) + 102, 235);
        else
            numberPos = new Vector2(cam.position.x - (cam.viewportWidth / 2) + 89, 235);

        System.out.println("================================= END ===============================");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, backgroundPos.x, backgroundPos.y);
        sb.draw(announcement, announcementPos.x, announcementPos.y, announcement.getWidth(), announcement.getHeight());
        sb.draw(playButton, playButtonPos.x, playButtonPos.y, playButton.getWidth() / 1.5f,
                playButton.getHeight() / 1.5f);
        number.draw(sb, Integer.toString(point), numberPos.x, numberPos.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        announcement.dispose();
    }

    private void initFont() {
        FreeTypeFontGenerator number = new FreeTypeFontGenerator(Gdx.files.internal("number.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter numberProperty = new FreeTypeFontGenerator.FreeTypeFontParameter();

        numberProperty.size = 50;
        numberProperty.color = Color.WHITE;
        numberProperty.borderWidth = 1.5f;
        numberProperty.borderColor = Color.BLACK;
        this.number = number.generateFont(numberProperty);
    }
}
