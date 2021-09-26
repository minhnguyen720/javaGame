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
import com.willie.game.ui.OrangeButton;
import com.willie.game.ui.GreenButton;
import com.willie.game.ui.GameFont;

public class MainMenuScreen implements Screen {
    public Stage stage;

    private final GameFont gameFont;
    private final GreenButton playButton;
    private final OrangeButton exitButton;
    private final AlphaProject project;

    public MainMenuScreen(final AlphaProject project) {
        this.project = project;

        stage = new Stage(new StretchViewport(AlphaProject.WIDTH, AlphaProject.HEIGHT, project.camera));
        gameFont = new GameFont(project, stage);
        playButton = new GreenButton(project, stage);
        exitButton = new OrangeButton(project, stage);
    }

    @Override
    public void show() {
        System.out.println("MAIN MENU SCREEN");

        Gdx.input.setInputProcessor(stage);

        stage.clear();

        final Texture background = project.assetManager.get("background/parallax-mountain-bg.png", Texture.class);
        Image actorBackground = new Image(background);
        actorBackground.setPosition(0, 0);
        actorBackground.setSize(project.camera.viewportWidth, project.camera.viewportHeight);
        stage.addActor(actorBackground);

        final Texture title = project.assetManager.get("ui/Title.png", Texture.class);
        Image titleActor = new Image(title);

        titleActor.setPosition(project.camera.viewportWidth / 2 - (float) title.getWidth() / 2,
                project.camera.viewportHeight / 2 + 30);

        titleActor.addAction(Actions.sequence(Actions.alpha(0f), Actions.fadeIn(.5f)));

        stage.addActor(titleActor);

        playButton.initPlayButton("Play", project.camera.viewportWidth / 2 - playButton.getWidth() - 50,
                project.camera.viewportHeight / 2 - 70);
        exitButton.initHomeButton("Exit", project.camera.viewportWidth / 2 - exitButton.getWidth() - 50,
                project.camera.viewportHeight / 2 - 150);
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
        stage.getViewport().update(width, height, false);
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
        gameFont.dispose();
        exitButton.dispose();
        playButton.dispose();
    }

    public void update(float deltaTime) {
        stage.act(deltaTime);
    }
}
