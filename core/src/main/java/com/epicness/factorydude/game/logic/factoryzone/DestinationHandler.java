package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Destination;
import com.epicness.fundamentals.stuff.grid.Cell;

public class DestinationHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;

    public void spawnDestination() {
        Cell middleCell = stuff.getFactoryZone().getHexGrid().getCells()[HEX_GRID_COLUMNS / 2][HEX_GRID_ROWS / 2];
        float cellCenterX = middleCell.getX() + middleCell.getWidth() / 2f;
        float cellCenterY = middleCell.getY() + middleCell.getHeight() / 2f;
        Destination destination = new Destination(assets.getDestination());
        destination.setPosition(cellCenterX - destination.getSize() / 2f, cellCenterY - destination.getSize() / 2f);
        destination.setOriginCenter();
        destination.setScale(0f);
        middleCell.getProperties().put(CELLABLE_PROPERTY, destination);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}