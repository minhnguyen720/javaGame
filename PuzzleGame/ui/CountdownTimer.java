package com.willie.game.ui;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.willie.game.AlphaProject;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownTimer implements Screen {
    private Timer timer;
    private AlphaProject project;
    private final ShapeRenderer shapeRenderer;

    private float second = 15 * 60;
    private int DEFAULT_WIDTH = 20;
    private final float DEFAULT_SEC = second;

    public CountdownTimer(final AlphaProject project) {
        this.project = project;
        shapeRenderer = new ShapeRenderer();
    }

    public void initTimer() {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 0.1f;
                System.out.println(second);
                if (second <= 0.009) {
                    timer.stop();
                    project.setScreen(project.mainMenuScreen);
                }
            }
        });
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(10, project.camera.viewportHeight / 2 + 40, (DEFAULT_WIDTH * DEFAULT_SEC) / 100, 15);

        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(10, project.camera.viewportHeight / 2 + 40, (second * DEFAULT_WIDTH) / 100, 15);

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
    }

}
