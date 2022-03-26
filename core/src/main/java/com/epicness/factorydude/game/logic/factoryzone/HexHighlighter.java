package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.HexGrid;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.grid.Cell;

public class HexHighlighter {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Cell selectedCell;

    public void mouseUpdate(float x, float y) {
        if (!sharedLogic.getPauseTracker().get()) {
            return;
        }
        HexGrid hexGrid = stuff.getFactoryZone().getHexGrid();
        boolean highlighted = false;
        for (int column = 0; column < HEX_GRID_COLUMNS; column++) {
            for (int row = 0; row < HEX_GRID_ROWS; row++) {
                Cell cell = hexGrid.getCells()[column][row];
                if (cell == selectedCell) {
                    continue;
                }
                cell.setColor(Color.WHITE);
                if (cell.contains(x, y) && !highlighted) {
                    cell.setColor(Color.CYAN);
                    highlighted = true;
                }
            }
        }
    }

    public void touchDown(float x, float y) {
        if (!sharedLogic.getPauseTracker().get()) {
            return;
        }
        HexGrid hexGrid = stuff.getFactoryZone().getHexGrid();
        for (int column = 0; column < HEX_GRID_COLUMNS; column++) {
            for (int row = 0; row < HEX_GRID_ROWS; row++) {
                Cell cell = hexGrid.getCells()[column][row];
                if (cell.contains(x, y)) {
                    logic.getBuildingPanelSlider().open();
                    cell.setColor(Color.BLUE);
                    if (selectedCell != null) {
                        selectedCell.setColor(Color.WHITE);
                    }
                    selectedCell = cell;
                    return;
                }
            }
        }
        logic.getBuildingPanelSlider().close();
        if (selectedCell != null) {
            selectedCell.setColor(Color.WHITE);
        }
        selectedCell = null;
    }

    public Cell getSelectedCell() {
        return selectedCell;
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}