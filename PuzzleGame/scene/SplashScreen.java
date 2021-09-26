package com.willie.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.willie.game.AlphaProject;
import com.willie.game.ui.GameFont;

public class SplashScreen implements Screen {
    public Stage stage;
    private final AlphaProject project;
    private final GameFont label;

    public SplashScreen (final AlphaProject project) {
        this.project = project;
        stage = new Stage(new StretchViewport(AlphaProject.WIDTH, AlphaProject.HEIGHT, project.camera));
        label = new GameFont(project,stage);
    }

    @Override
    public void show() {
        System.out.println("LOADED");

        Gdx.input.setInputProcessor(stage);

        final Texture background = project.assetManager.get("background/parallax-mountain-bg.png", Texture.class);
        Image actorBackground = new Image(background);
        stage.addActor(actorBackground);

        Runnable transition = new Runnable() {
            @Override
            public void run() {
                    project.setScreen(project.mainMenuScreen);
            }
        };

        actorBackground.setPosition(0, 0);
        actorBackground.setSize(project.camera.viewportWidth, project.camera.viewportHeight);
        actorBackground.addAction(Actions.sequence(Actions.alpha(0f),Actions.fadeIn(2f),Actions.delay(1f),Actions.run(transition)));

        label.initLabel(120,230,"ALPHA PROJECT DEMO", 3,true);

        project.gameMusic.playMusic();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,false);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        label.dispose();
    }

    public void update(float deltaTime) {
        stage.act(deltaTime);
    }
}
