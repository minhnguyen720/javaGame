package com.willie.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.willie.game.AlphaProject;
import com.willie.game.actors.SlideButton;
import com.willie.game.ui.CountdownTimer;
import com.willie.game.ui.GameFont;
import com.willie.game.ui.GreenButton;
import com.willie.game.ui.OrangeButton;

public class GameScreen implements Screen {

    // App reference
    private final AlphaProject project;

    // Private vars
    private final Stage stage;
    private int score = 0;
    private final Texture background;

    // Game label
    private final GameFont gameFont;

    // Timer
    CountdownTimer timer;

    // Game grid
    private final GreenButton number;
    private final int boardSize = 4;
    private int holeX, holeY;
    private SlideButton[][] buttonGrid;

    // Nav-button
    private final OrangeButton backButton;

    public GameScreen(final AlphaProject project) {
        this.project = project;
        stage = new Stage();
        background = new Texture(Gdx.files.internal("background/parallax-mountain-bg.png"));
        number = new GreenButton(project, stage);
        backButton = new OrangeButton(project, stage);
        gameFont = new GameFont(project,stage);
        timer = new CountdownTimer(project);

    }

    private void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void show() {
        System.out.println("PLAY SCREEN");
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        backButton.initBackButton("Back", 20, project.camera.viewportHeight - 60,true);
        gameFont.initLabel(420,400,"Score: " + score,3,false);

        initGrid();
        timer.initTimer();
        timer.startTimer();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        project.batch.begin();
        project.batch.draw(background,0,0,project.camera.viewportWidth,project.camera.viewportHeight);
        project.batch.end();

        stage.draw();

        timer.render(delta);
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
        timer.dispose();
    }

    // init game grid
    private void initGrid() {
        // init randomize grid numbers
        Array<Integer> nums = new Array<Integer>();
        for (int i = 1; i < boardSize * boardSize; i++) {
            nums.add(i);
        }
        nums.shuffle();

        // hole location
        holeX = MathUtils.random(0, boardSize - 1);
        holeY = MathUtils.random(0, boardSize - 1);

        buttonGrid = new SlideButton[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                if (row != holeY || column != holeX) {

                    // Grid vars
                    float offsetX = 40f;
                    float buttonGapX = 51 * column;
                    float buttonGapY = -51 * row;

                    int id = nums.removeIndex(0); // remove and return the element correspond to the index
                    buttonGrid[row][column] = new SlideButton(id + "", number.getSkin(), "default", id);

                    buttonGrid[row][column].setPosition(((project.camera.viewportWidth / 7) * 2 + offsetX + buttonGapX),
                            (project.camera.viewportHeight / 5) * 2 + buttonGapY);

                    buttonGrid[row][column].setSize(50, 50);

                    buttonGrid[row][column].addAction(sequence(alpha(0), delay(id / 60f),
                            parallel(fadeIn(.5f), moveBy(0, -10, .25f, Interpolation.pow5Out))));

                    // Move button click listener
                    buttonGrid[row][column].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            // in order to move button, we need to know which button can be move
                            // since we don't know exactly which button is pressed, we need to find x and y
                            // value of that button
                            int buttonX = 0, buttonY = 0;
                            boolean buttonFound = false;
                            SlideButton selectedButton = (SlideButton) event.getListenerActor();

                            for (int row = 0; row < boardSize && !buttonFound; row++) {
                                for (int column = 0; column < boardSize && !buttonFound; column++) {
                                    // if the current button is not null and it have the same coordinate with
                                    // selected button
                                    // then we confirm that the selected button at corresponding coordinate is
                                    // pressed
                                    if (buttonGrid[row][column] != null && selectedButton == buttonGrid[row][column]) {
                                        buttonX = column;
                                        buttonY = row;

                                        buttonFound = true;
                                    }
                                }
                            }
                            if (holeX == buttonX || holeY == buttonY) {
                                moveButton(buttonX, buttonY);

                                if (solutionChecker()) {
                                    System.out.println("Score: " + ++score);
                                    project.gameMusic.playSound();
                                    stage.clear();

                                    gameFont.initLabel(420,400,"Score: " + score,3,false);
                                    backButton.initBackButton("Back", 20, project.camera.viewportHeight - 80,false);

                                    initGrid();
                                }
                            }
                        }
                    });

                    stage.addActor(buttonGrid[row][column]);
                }
            }
        }
    }

    private void moveButton(int x, int y) {
        SlideButton button;
        // Vertical movement
        if (x < holeX) {
            for (; x < holeX; holeX--) {
                button = buttonGrid[holeY][holeX - 1];
                button.addAction(moveBy(51, 0, .5f, Interpolation.pow5Out));
                // Swap
                buttonGrid[holeY][holeX] = button;
                buttonGrid[holeY][holeX - 1] = null;
            }
        } else {
            for (; x > holeX; holeX++) {
                button = buttonGrid[holeY][holeX + 1];
                button.addAction(moveBy(-51, 0, .5f, Interpolation.pow5Out));
                // Swap
                buttonGrid[holeY][holeX] = button;
                buttonGrid[holeY][holeX + 1] = null;
            }
        }

        // Horizontal movement
        if (y < holeY) {
            for (; y < holeY; holeY--) {
                button = buttonGrid[holeY - 1][holeX];
                button.addAction(moveBy(0, -51, .5f, Interpolation.pow5Out));
                // Swap
                buttonGrid[holeY][holeX] = button;
                buttonGrid[holeY - 1][holeX] = null;
            }
        } else {
            for (; y > holeY; holeY++) {
                button = buttonGrid[holeY + 1][holeX];
                button.addAction(moveBy(0, 51, .5f, Interpolation.pow5Out));
                // Swap
                buttonGrid[holeY][holeX] = button;
                buttonGrid[holeY + 1][holeX] = null;
            }
        }
    }

    private boolean solutionChecker() {
        int idCheck = 1;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (buttonGrid[i][j] != null) {
                    if (buttonGrid[i][j].getId() == idCheck++) {
                        if (idCheck == boardSize * boardSize) {
                            return true;
                        }
                    } else
                        return false;
                } else
                    return false;
            }
        }
        return false;
    }

}
