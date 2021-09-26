package com.willie.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

import com.willie.game.AlphaProject;

public class LoadingScreen implements Screen {

    private final AlphaProject project;
    private final Texture background;
    private final ShapeRenderer shapeRenderer;
    private float progress;


    public LoadingScreen(AlphaProject project) {
        this.project = project;

        // shapeRenderer creates specific shape
        this.shapeRenderer = new ShapeRenderer();

        background = new Texture(Gdx.files.internal("background/parallax-mountain-bg.png"));
    }

    public void update(float delta) {
        // project.assetManager.getProgress() return value from 0 to 1, 1 is loading finished.
        /* MathUtils.lerp(progress,project.assetManager.getProgress(),.1f) means:
            - We have: progress is A which is where we actually at and project.assetManager.getProgress() is B which is where we want to go.
            - Also have this equation: A = A + (B - A) * lerp and this equation repeat until A = B, this will help slow the loading bar down,
            its pace depends on the lerp value.
         */
       progress = MathUtils.lerp(progress,project.assetManager.getProgress(),.1f);

        /* project.assetManager.update() will return false until all the assets in the queue are loaded.
        then we switch to another screen.
        */
        if(project.assetManager.update() && progress >= project.assetManager.getProgress() - .001f) {
            project.setScreen(project.splashScreen);
        }
    }

    public void queueAssets() {
        project.assetManager.load("background/parallax-mountain-bg.png", Texture.class);
        project.assetManager.load("ui/Title.png",Texture.class);
        project.assetManager.load("ui/jsonFiles/greenButton/greenBtn.atlas", TextureAtlas.class);
        project.assetManager.load("ui/jsonFiles/orangeButton/orangeBtn.atlas",TextureAtlas.class);
        project.assetManager.load("ui/jsonFiles/labelSkin.atlas",TextureAtlas.class);
    }

    @Override
    public void show() {
        System.out.println("LOADING");
        shapeRenderer.setProjectionMatrix(project.camera.combined);
        progress = 0f;
        // queueAssets is a container of all the asset in this scene
        queueAssets();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        project.batch.begin();
        project.batch.draw(background,0,0,project.camera.viewportWidth,project.camera.viewportHeight);
        project.batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(32, project.camera.viewportHeight / 5, project.camera.viewportWidth - 64, 32 );

        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(32, project.camera.viewportHeight / 5, progress * (project.camera.viewportWidth - 64), 32 );
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

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
        shapeRenderer.dispose();
        background.dispose();
    }
}
