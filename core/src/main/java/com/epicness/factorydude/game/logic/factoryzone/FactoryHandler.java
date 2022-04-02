package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;
import static com.epicness.factorydude.game.enums.PieceType.ATTACK;
import static com.epicness.factorydude.game.enums.PieceType.CHONKY_BOOSTER;
import static com.epicness.factorydude.game.enums.PieceType.DASH;
import static com.epicness.factorydude.game.enums.PieceType.MOVE;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.factorydude.game.stuff.cellables.Destination;
import com.epicness.factorydude.game.stuff.cellables.Factory;
import com.epicness.factorydude.game.stuff.pieces.ActionPiece;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.grid.Cell;

import java.util.ArrayList;
import java.util.List;

public class FactoryHandler {

    // Structure
    private GameAssets assets;
    private SharedLogic sharedLogic;
    private GameStuff stuff;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            delta /= 7f;
        }
        Cell[][] cells = stuff.getFactoryZone().getHexGrid().getCells();
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                Cellable cellable = (Cellable) cells[column][row].getProperties().get(CELLABLE_PROPERTY);
                if (!(cellable instanceof Factory)) {
                    continue;
                }
                updateFactory((Factory) cellable, column, row, delta, cells);
            }
        }
    }

    private void updateFactory(Factory factory, int column, int row, float delta, Cell[][] cells) {
        factory.affectCooldown(-delta);
        if (factory.getCooldown() > 0f) {
            return;
        }
        factory.affectCooldown(-factory.getCooldown() + 7f);
        int minColumn = Math.max(0, column - 1), maxColumn = Math.min(HEX_GRID_COLUMNS - 1, column + 1);
        int minRow = Math.max(0, row - 1), maxRow = Math.min(HEX_GRID_ROWS - 1, row + 1);
        List<Cell> candidates = new ArrayList<>();
        for (int c = minColumn; c <= maxColumn; c++) {
            for (int r = minRow; r <= maxRow; r++) {
                if (row % 2 == 0 && r % 2 != 0 && c == column - 1) {
                    continue;
                } else if (row % 2 != 0 && r % 2 == 0 && c == column + 1) {
                    continue;
                } else if (c == column && r == row) {
                    continue;
                }
                Cellable cellable = (Cellable) cells[c][r].getProperties().get(CELLABLE_PROPERTY);
                if (!(cellable instanceof ConveyorBelt) && !(cellable instanceof Destination)) {
                    continue;
                }
                candidates.add(cells[c][r]);
            }
        }
        if (candidates.isEmpty()) {
            return;
        }
        producePiece(cells[column][row], candidates);
    }

    private void producePiece(Cell factoryCell, List<Cell> candidates) {
        int random = MathUtils.random(candidates.size() - 1);
        Cell destination = candidates.get(random);
        ActionPiece piece = produceRandomPiece(factoryCell, destination);
        piece.setScale(stuff.getFactoryZone().getScale());
        stuff.getFactoryZone().getPieces().add(piece);
    }

    private ActionPiece produceRandomPiece(Cell origin, Cell destination) {
        int random = MathUtils.random(3);
        switch (random) {
            case 0:
                return new ActionPiece(assets.getAttackIcon(), ATTACK, origin, destination);
            case 1:
                return new ActionPiece(assets.getDashIcon(), DASH, origin, destination);
            case 2:
                return new ActionPiece(assets.getMoveIcon(), MOVE, origin, destination);
            case 3:
            default:
                return new ActionPiece(assets.getChonkyIcon(), CHONKY_BOOSTER, origin, destination);
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}