package com.epicness.factorydude.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.grid.Grid;

public class HexGrid extends Grid {

    public HexGrid(int columns, int rows, Sprite cellSprite) {
        super(columns, rows, cellSprite);
    }

    @Override
    public void setCellSize(float size) {
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                float xOffset = row % 2 == 0 ? size / 2f : 0f;
                float x = column * (size * 0.98f) + xOffset;
                float y = row * (size * 0.74f);
                cells[column][row].setPosition(x, y);
                cells[column][row].setSize(size);
            }
        }
    }

    @Override
    public float getWidth() {
        return columns * 0.98f;
    }

    @Override
    public float getHeight() {
        return rows * 0.7f;
    }
}