package com.epicness.factorydude.game.logic;

import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.HexGrid;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.grid.Cell;

public class HexHighlighter {

    // Structure
    private SharedLogic sharedLogic;
    private GameStuff stuff;

    public void mouseUpdate(float x, float y) {
        if (!sharedLogic.getPauseTracker().get()) {
            return;
        }
        HexGrid hexGrid = stuff.getFactoryZone().getHexGrid();
        boolean highlighted = false;
        for (int column = 0; column < HEX_GRID_COLUMNS; column++) {
            for (int row = 0; row < HEX_GRID_ROWS; row++) {
                Cell cell = hexGrid.getCells()[column][row];
                cell.setColor(Color.WHITE);
                if (cell.contains(x, y) && !highlighted) {
                    cell.setColor(Color.RED);
                    highlighted = true;
                }
            }
        }
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}