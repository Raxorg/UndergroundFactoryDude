package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Destination;
import com.epicness.factorydude.game.stuff.pieces.ActionPiece;
import com.epicness.fundamentals.stuff.IconedSpritedText;
import com.epicness.fundamentals.stuff.grid.Cell;

public class DestinationHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private int attacks, dashes, moves, boosters;

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
        IconedSpritedText counter;
        switch (piece.getType()) {
            case ATTACK:
                counter = stuff.getPieceCounters().getAttackCounter();
                counter.setText(++attacks + "");
                break;
            case DASH:
                counter = stuff.getPieceCounters().getDashCounter();
                counter.setText(++dashes + "");
                break;
            case MOVE:
                counter = stuff.getPieceCounters().getMoveCounter();
                counter.setText(++moves + "");
                break;
            case CHONKY_BOOSTER:
            default:
                counter = stuff.getPieceCounters().getChonkyCounter();
                counter.setText(++boosters + "");
        }
    }

    public void reduceAttack() {
        stuff.getPieceCounters().getAttackCounter().setText(--attacks + "");
    }

    public void reduceDash() {
        stuff.getPieceCounters().getDashCounter().setText(--dashes + "");
    }

    public void reduceBoosters() {
        boosters -= 5;
        stuff.getPieceCounters().getChonkyCounter().setText(boosters + "");
        if (boosters <= 0) {
            stuff.getMessage().setScale(5f);
            stuff.getMessage().setText("YOU LOST");
            stuff.getMessage().setColor(Color.RED);
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