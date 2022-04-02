package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.factorydude.game.stuff.cellables.Factory;
import com.epicness.fundamentals.stuff.grid.Cell;

public class BuildingPlacer {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void placeCellable(Cell cell, int option) {
        int coins = logic.getCoinHandler().getCoins();
        if (coins <= 0) {
            return;
        }
        logic.getCoinHandler().subtractCoin();
        Cellable cellable;
        switch (option) {
            case 0:
                cellable = new Factory(assets.getFactory());
                break;
            case 1:
            default:
                cellable = placeConveyorBelt(cell);
                break;
        }
        float cellCenterX = cell.getX() + cell.getWidth() / 2f;
        float cellCenterY = cell.getY() + cell.getHeight() / 2f;
        cellable.setPosition(cellCenterX - cellable.getSize() / 2f, cellCenterY - cellable.getSize() / 2f);
        cellable.setOriginCenter();
        cell.getProperties().put(CELLABLE_PROPERTY, cellable);
    }

    private ConveyorBelt placeConveyorBelt(Cell cell) {
        ConveyorBelt conveyorBelt = new ConveyorBelt(assets.getConveyorBeltFrames(), cell);
        Cell[][] cells = stuff.getFactoryZone().getHexGrid().getCells();
        if (cell.getColumn() == cells.length - 1) {
            return conveyorBelt;
        }
        conveyorBelt.setDestination(cells[cell.getColumn() + 1][cell.getRow()]);
        return conveyorBelt;
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}