package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.factorydude.game.stuff.cellables.Factory;
import com.epicness.fundamentals.stuff.grid.Cell;

public class BuildingPlacer {

    // Structure
    private GameAssets assets;

    public void placeCellable(Cell cell, int option) {
        Cellable cellable;
        switch (option) {
            case 0:
                cellable = new Factory(assets.getFactory());
                break;
            case 1:
            default:
                cellable = new ConveyorBelt(assets.getConveyorBeltFrames());
                break;
        }
        float cellCenterX = cell.getX() + cell.getWidth() / 2f;
        float cellCenterY = cell.getY() + cell.getHeight() / 2f;
        cellable.setPosition(cellCenterX - cellable.getSize() / 2f, cellCenterY - cellable.getSize() / 2f);
        cellable.setOriginCenter();
        cell.getProperties().put(CELLABLE_PROPERTY, cellable);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}