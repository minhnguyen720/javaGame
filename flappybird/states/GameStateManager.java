package com.willie.game.states;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
    }

    public void pop() {
        states.pop().dispose();
    }

    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }

    // peek function use to find the top element of the stack
    public void update(float deltaTime) {
        states.peek().update(deltaTime);
    }

    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
