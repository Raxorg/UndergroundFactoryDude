package com.epicness.factorydude.game.logic.player;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.SharedScreen;

public class CameraHandler {

    // Structure
    private SharedScreen screen;
    private GameStuff stuff;

    public void update() {
        float playerX = stuff.getPlayer().getX();
        float playerY = stuff.getPlayer().getY();
        screen.getDynamicCamera().position.set(playerX, playerY, 0f);
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