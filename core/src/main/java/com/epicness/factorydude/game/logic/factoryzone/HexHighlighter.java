package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.factorydude.game.stuff.factoryzone.HexGrid;
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
                if (!cell.contains(x, y)) {
                    continue;
                }
                selectCell(cell);
                Cellable cellable = (Cellable) cell.getProperties().get(CELLABLE_PROPERTY);
                if (cellable != null) {
                    cellableSelected(cellable);
                    return;
                }
                emptyCellSelected();
                return;
            }
        }
        logic.getBuildingPanelSlider().close();
        if (selectedCell != null) {
            selectedCell.setColor(Color.WHITE);
        }
        selectedCell = null;
    }

    private void selectCell(Cell cell) {
        if (selectedCell != null) {
            selectedCell.setColor(Color.WHITE);
        }
        cell.setColor(Color.BLUE);
        selectedCell = cell;
    }

    private void cellableSelected(Cellable cellable) {
        logic.getBuildingPanelSlider().close();
        if (cellable instanceof ConveyorBelt) {
            logic.getConveyorHandler().rotateConveyor((ConveyorBelt) cellable);
        }
    }

    private void emptyCellSelected() {
        logic.getBuildingPanelSlider().open();
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