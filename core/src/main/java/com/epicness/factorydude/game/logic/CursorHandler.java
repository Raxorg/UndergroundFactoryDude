package com.epicness.factorydude.game.logic;

import com.badlogic.gdx.Gdx;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class CursorHandler {

    // Structure
    private GameStuff stuff;

    public void init() {
        Gdx.input.setCursorCatched(true);
    }

    public void update(float delta) {
        stuff.getCursor().addTime(delta);
    }

    public void mouseUpdate(float x, float y) {
        SpritedAnimation cursor = stuff.getCursor();
        cursor.setPosition(x - cursor.getWidth() / 2f, y - cursor.getHeight() / 2f);
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}