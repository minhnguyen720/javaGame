package com.willie.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.willie.game.AlphaProject;

public class GreenButton extends ButtonAbstract {

    // private vars
    private final Skin buttonSkin;

    public GreenButton(final AlphaProject project, Stage stage) {
        super(project, stage);
        buttonSkin = new Skin();
    }

    public void initPlayButton(String content, float x, float y) {
        skinInit();

        // Play Button
        TextButton playButton = new TextButton(content, buttonSkin, "default");
        playButton.setPosition(x, y);
        playButton.setSize(100, 59);

        // Actions
        playButton.addAction(Actions.sequence(Actions.alpha(0f),
                Actions.parallel(Actions.fadeIn(.3f), Actions.moveBy(0, -20, .4f, Interpolation.pow5Out))));

        addFunction(playButton, "game");

        stage.addActor(playButton);
    }

    public void dispose() {
        buttonSkin.dispose();
    }

    @Override
    public void skinInit() {
        buttonSkin
                .addRegions(project.assetManager.get("ui/jsonFiles/greenButton/greenBtn.atlas", TextureAtlas.class));
        buttonSkin.load(Gdx.files.internal("ui/jsonFiles/greenButton/greenBtn.json"));
    }

    private void addFunction(Actor actor, String action) {
        if (action == "game") {
            actor.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    project.setScreen(project.gameScreen);
                }
            });
        }
    }

    public Skin getSkin() {
        skinInit();
        return buttonSkin;
    }
}
