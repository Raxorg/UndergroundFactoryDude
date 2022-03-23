package com.epicness.factorydude.game.logic;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.fundamentals.stuff.grid.Cell;

public class BuildingPlacer {

    // Structure
    private GameAssets assets;

    public void placeCellable(Cell selectedCell) {
        Cellable cellable = new Cellable(assets.getFactory());
        cellable.setPosition(selectedCell.getX(), selectedCell.getY());
        selectedCell.getProperties().put(CELLABLE_PROPERTY, cellable);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}