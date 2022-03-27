package com.epicness.factorydude.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;

import com.badlogic.gdx.Input;
import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler {

    @Override
    public void mouseMoved(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        logic.getBuildingPanelHandler().mouseUpdate(x, y);
        logic.getCursorHandler().mouseUpdate(x, y);
        logic.getHexHighlighter().mouseUpdate(x, y);
    }

    @Override
    public void mousePressed(float x, float y, int button) {
        GameLogic logic = (GameLogic) this.logic;
        if (button == Input.Buttons.LEFT) {
            logic.getPlayerAttackHandler().attack();
        } else if (button == Input.Buttons.RIGHT) {
            logic.getDashHandler().dash();
        }
    }

    @Override
    public void touchDown(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        logic.getBuildingPanelHandler().touchDown(x, y);
        logic.getHexHighlighter().touchDown(x, y);
    }

    @Override
    public void keyDown(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        switch (keycode) {
            case W:
                logic.getPlayerMover().verticalDirChange(true, true);
                break;
            case A:
                logic.getPlayerMover().horizontalDirChange(true, true);
                break;
            case S:
                logic.getPlayerMover().verticalDirChange(false, true);
                break;
            case D:
                logic.getPlayerMover().horizontalDirChange(false, true);
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        switch (keycode) {
            case W:
                logic.getPlayerMover().verticalDirChange(true, false);
                break;
            case A:
                logic.getPlayerMover().horizontalDirChange(true, false);
                break;
            case S:
                logic.getPlayerMover().verticalDirChange(false, false);
                break;
            case D:
                logic.getPlayerMover().horizontalDirChange(false, false);
                break;
            case F:
                logic.getFactoryZoneScaler().togglePressed();
                break;
        }
    }
}