package com.willie.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.willie.game.AlphaProject;

public class GameFont extends Actor {
    private BitmapFont title;
    private final AlphaProject project;
    private final Skin labelSkin;
    private final Stage stage;

    public GameFont(final AlphaProject project, Stage stage) {
        this.project = project;
        this.stage = stage;

        title = new BitmapFont();
        labelSkin = new Skin();
    }

    public void initFont(int size) {
        FreeTypeFontGenerator title = new FreeTypeFontGenerator(Gdx.files.internal("font/font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter titleProperty = new FreeTypeFontGenerator.FreeTypeFontParameter();

        titleProperty.size = size;
        titleProperty.color = Color.WHITE;
        titleProperty.borderWidth = 2f;
        titleProperty.borderColor = Color.BLACK;
        this.title = title.generateFont(titleProperty);
    }

    public void dispose() {
        title.dispose();
        labelSkin.dispose();
    }

    public void initLabel(float x, float y, String content, float fontScale, boolean activeEffect) {
        labelSkin.addRegions(project.assetManager.get("ui/jsonFiles/labelSkin.atlas", TextureAtlas.class));
        labelSkin.load(Gdx.files.internal("ui/jsonFiles/labelSkin.json"));

        Label label = new Label(content, labelSkin, "default");
        label.setPosition(x, y);
        label.setFontScale(fontScale);

        if(activeEffect)
            label.addAction(sequence(alpha(0f), fadeIn(1f),delay(1f),fadeOut(1f)));

        stage.addActor(label);
    }
}
