package com.epicness.factorydude.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;

import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler {

    @Override
    public void mouseMoved(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        logic.getHexHighlighter().mouseUpdate(x, y);
    }

    @Override
    public void keyDown(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        switch (keycode) {
            case W:
                logic.getPlayerHandler().verticalDirChange(true, true);
                break;
            case A:
                logic.getPlayerHandler().horizontalDirChange(true, true);
                break;
            case S:
                logic.getPlayerHandler().verticalDirChange(false, true);
                break;
            case D:
                logic.getPlayerHandler().horizontalDirChange(false, true);
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        switch (keycode) {
            case W:
                logic.getPlayerHandler().verticalDirChange(true, false);
                break;
            case A:
                logic.getPlayerHandler().horizontalDirChange(true, false);
                break;
            case S:
                logic.getPlayerHandler().verticalDirChange(false, false);
                break;
            case D:
                logic.getPlayerHandler().horizontalDirChange(false, false);
                break;
            case F:
                logic.getFactoryZoneScaler().togglePressed();
                break;
        }
    }
}