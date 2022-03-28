package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;
import static com.epicness.factorydude.game.enums.PieceType.CHONKY_BOOSTER;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.factorydude.game.stuff.cellables.Factory;
import com.epicness.factorydude.game.stuff.pieces.ActionPiece;
import com.epicness.fundamentals.stuff.grid.Cell;

import java.util.ArrayList;
import java.util.List;

public class FactoryHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;

    public void update(float delta) {
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
        factory.affectCooldown(-factory.getCooldown() + 4f);
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
                } else if (!(cells[c][r].getProperties().get(CELLABLE_PROPERTY) instanceof ConveyorBelt)) {
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
        Cell cell = candidates.get(random);
        ActionPiece piece = new ActionPiece(assets.getChonkyIcon(), CHONKY_BOOSTER);
        float x = factoryCell.getX() + cell.getWidth() / 2f - piece.getWidth() / 2f;
        float y = factoryCell.getY() + cell.getHeight() / 2f - piece.getHeight() / 2f;
        piece.setPosition(x, y);
        piece.getOrigin().set(x, y);
        float destinationX = cell.getX() + cell.getWidth() / 2f - piece.getWidth() / 2f;
        float destinationY = cell.getY() + cell.getHeight() / 2f - piece.getHeight() / 2f;
        piece.getDestination().set(destinationX, destinationY);
        stuff.getFactoryZone().getPieces().add(piece);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}