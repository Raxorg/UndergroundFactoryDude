package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Destination;
import com.epicness.factorydude.game.stuff.pieces.ActionPiece;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.grid.Cell;

public class DestinationHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private int boosters;

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

    public void gainPiece(ActionPiece piece) {
        Text counter = stuff.getChonkyCount();
        switch (piece.getType()) {
            case ATTACK:
                // TODO: 2/4/2022
                System.out.println("attack piece gained");
                break;
            case DASH:
                // TODO: 2/4/2022
                System.out.println("dash piece gained");
                break;
            case MOVE:
                // TODO: 2/4/2022
                System.out.println("move piece gained");
                break;
            case CHONKY_BOOSTER:
            default:
                counter.setText("Chonky Boosters: " + ++boosters);
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}