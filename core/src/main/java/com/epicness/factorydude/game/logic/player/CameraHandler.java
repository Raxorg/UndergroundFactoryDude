package com.epicness.factorydude.game.logic.player;

import static com.epicness.factorydude.game.GameConstants.FLOOR_HEIGHT;
import static com.epicness.factorydude.game.GameConstants.FLOOR_WIDTH;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.SharedScreen;

public class CameraHandler {

    // Structure
    private SharedScreen screen;
    private GameStuff stuff;

    public void update() {
        float playerX = stuff.getPlayer().getX();
        float playerY = stuff.getPlayer().getY();
        float x = MathUtils.clamp(playerX, CAMERA_WIDTH / 2f, FLOOR_WIDTH - CAMERA_WIDTH / 2f);
        float y = MathUtils.clamp(playerY, CAMERA_HEIGHT / 2f, FLOOR_HEIGHT - CAMERA_HEIGHT / 2f);
        screen.getDynamicCamera().position.set(x, y, 0f);
        screen.getDynamicCamera().update();
    }

    // Structure
    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}