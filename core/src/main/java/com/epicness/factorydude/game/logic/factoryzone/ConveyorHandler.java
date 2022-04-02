package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.factorydude.game.stuff.cellables.Destination;
import com.epicness.factorydude.game.stuff.pieces.ActionPiece;
import com.epicness.fundamentals.stuff.grid.Cell;

public class ConveyorHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void rotateConveyor(ConveyorBelt conveyorBelt) {
        int column = conveyorBelt.getCell().getColumn();
        int row = conveyorBelt.getCell().getRow();
        int rotation = (int) ((conveyorBelt.getRotation() + 60f) % 360f);
        conveyorBelt.setRotation(rotation);
        Cell[][] cells = stuff.getFactoryZone().getHexGrid().getCells();
        int destColumn = column, destRow = row;
        switch (rotation) {
            case 0:
                destColumn++;
                break;
            case 60:
                if (row % 2 == 0) {
                    destColumn++;
                }
                destRow++;
                break;
            case 120:
                if (row % 2 != 0) {
                    destColumn--;
                }
                destRow++;
                break;
            case 180:
                destColumn--;
                break;
            case 240:
                if (row % 2 != 0) {
                    destColumn--;
                }
                destRow--;
                break;
            case 300:
                if (row % 2 == 0) {
                    destColumn++;
                }
                destRow--;
                break;
        }
        if (destColumn == -1 || destColumn == HEX_GRID_COLUMNS) {
            conveyorBelt.setDestination(null);
            return;
        }
        if (destRow == -1 || destRow == HEX_GRID_ROWS) {
            conveyorBelt.setDestination(null);
            return;
        }
        if (destColumn == column && destRow == row) {
            conveyorBelt.setDestination(null);
            return;
        }
        conveyorBelt.setDestination(cells[destColumn][destRow]);
    }

    public void update(float delta) {
        DelayedRemovalArray<ActionPiece> pieces = stuff.getFactoryZone().getPieces();
        pieces.begin();
        for (int i = 0; i < pieces.size; i++) {
            ActionPiece piece = pieces.get(i);
            float progress = Math.min(piece.getProgress() + delta / 2.5f, 1f);
            piece.setProgress(progress);
            Vector2 origin = piece.getOrigin().getCenter();
            Vector2 destination = piece.getDestination().getCenter();
            Vector2 position = new Vector2(origin).lerp(destination, progress);
            piece.setOriginBasedPosition(position.x, position.y);
            if (progress == 1f && destinationReached(piece)) {
                pieces.removeValue(piece, true);
            }
        }
        pieces.end();
    }

    private boolean destinationReached(ActionPiece piece) {
        Cellable cellable = (Cellable) piece.getDestination().getProperties().get(CELLABLE_PROPERTY);
        if (cellable instanceof ConveyorBelt) {
            ConveyorBelt conveyorBelt = (ConveyorBelt) cellable;
            piece.setOrigin(piece.getDestination());
            Cell destinationCell = conveyorBelt.getDestination();
            Cellable destination = (Cellable) destinationCell.getProperties().get(CELLABLE_PROPERTY);
            if (!(destination instanceof ConveyorBelt) && !(destination instanceof Destination)) {
                return false;
            }
            piece.setDestination(destinationCell);
            piece.setProgress(0f);
        } else if (cellable instanceof Destination) {
            logic.getDestinationHandler().gainPiece(piece);
            return true;
        }
        return false;
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}