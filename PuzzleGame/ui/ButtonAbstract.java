package com.willie.game.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.willie.game.AlphaProject;

public abstract class ButtonAbstract extends Actor {
    protected final AlphaProject project;
    protected final Stage stage;

    public ButtonAbstract(final AlphaProject project, Stage stage) {
        this.project = project;
        this.stage = stage;
    }

    public abstract void dispose();
    public abstract void skinInit();
}
