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

public class OrangeButton extends ButtonAbstract {
    private final Skin buttonSkin;

    public OrangeButton(final AlphaProject project, Stage stage) {
        super(project, stage);
        buttonSkin = new Skin();
    }

    public void initBackButton(String content, float x, float y,boolean activeEffect) {
        skinInit();

        // Back button
        TextButton backButton = new TextButton(content, buttonSkin, "default");
        backButton.setPosition(x, y);
        backButton.setSize(70, 40);

        addFunction(backButton, "menu");

        // Actions
        if(activeEffect)
            backButton.addAction(Actions.sequence(Actions.alpha(0f),
                Actions.parallel(Actions.fadeIn(.3f), Actions.moveBy(0, -20, .4f, Interpolation.pow5Out))));

        stage.addActor(backButton);
    }

    public void dispose() {
        buttonSkin.dispose();
    }

    public void initHomeButton(String content, float x, float y) {

        skinInit();

        // exitButton
        TextButton exitButton = new TextButton(content, buttonSkin, "default");
        exitButton.setPosition(x, y);
        exitButton.setSize(100, 59);

        addFunction(exitButton, "exit");

        // Actions
        exitButton.addAction(Actions.sequence(Actions.alpha(0f),
                Actions.parallel(Actions.fadeIn(.3f), Actions.moveBy(0, -20, .4f, Interpolation.pow5Out))));

        stage.addActor(exitButton);
    }

    @Override
    public void skinInit() {
        buttonSkin
                .addRegions(project.assetManager.get("ui/jsonFiles/orangeButton/orangeBtn.atlas", TextureAtlas.class));
        buttonSkin.load(Gdx.files.internal("ui/jsonFiles/orangeButton/orangeBtn.json"));
    }

    // Button functions
    private void addFunction(Actor actor, String action) {
        if (action == "menu") {
            actor.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    project.setScreen(project.mainMenuScreen);
                }
            });
        }

        if (action == "exit") {
            actor.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Gdx.app.exit();
                }
            });
        }
    }
}
