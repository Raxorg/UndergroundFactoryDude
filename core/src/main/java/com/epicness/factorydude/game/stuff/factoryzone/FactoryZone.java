package com.epicness.factorydude.game.stuff.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_CELL_SIZE;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_ROWS;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_STARTING_X;
import static com.epicness.factorydude.game.GameConstants.HEX_GRID_STARTING_Y;
import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_50;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.pieces.ActionPiece;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.grid.Cell;

public class FactoryZone {

    private final Sprited background;
    private final HexGrid hexGrid;
    private final DelayedRemovalArray<ActionPiece> pieces;
    private final BuildingPanel buildingPanel;
    private final Text slowMotionText;

    public FactoryZone(SharedAssets sharedAssets, GameAssets assets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        background.setOriginCenter();
        background.setColor(BLACK_CLEAR_50);

        hexGrid = new HexGrid(HEX_GRID_COLUMNS, HEX_GRID_ROWS, assets.getHex());
        hexGrid.setCellSize(HEX_GRID_CELL_SIZE);
        for (int column = 0; column < hexGrid.getCells().length; column++) {
            for (int row = 0; row < hexGrid.getCells()[column].length; row++) {
                hexGrid.getCells()[column][row].setOriginCenter();
            }
        }
        hexGrid.translate(HEX_GRID_STARTING_X, HEX_GRID_STARTING_Y);

        pieces = new DelayedRemovalArray<>();
        buildingPanel = new BuildingPanel(sharedAssets, assets);

        slowMotionText = new Text(assets.getNormalTimesSquare());
        slowMotionText.setY(CAMERA_HEIGHT);
        slowMotionText.setTextTargetWidth(CAMERA_WIDTH);
        slowMotionText.setText("Slow motion");
        slowMotionText.setHorizontalAlignment(Align.center);

        setScale(0f);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        hexGrid.draw(spriteBatch);
        drawCellables(spriteBatch);
        for (int i = 0; i < pieces.size; i++) {
            pieces.get(i).draw(spriteBatch);
        }
        buildingPanel.draw(spriteBatch);
        slowMotionText.draw(spriteBatch);
    }

    private void drawCellables(SpriteBatch spriteBatch) {
        for (int column = 0; column < hexGrid.getCells().length; column++) {
            for (int row = 0; row < hexGrid.getCells()[column].length; row++) {
                Cell cell = hexGrid.getCells()[column][row];
                if (cell.getProperties().get(CELLABLE_PROPERTY) == null) {
                    continue;
                }
                Cellable cellable = (Cellable) cell.getProperties().get(CELLABLE_PROPERTY);
                cellable.draw(spriteBatch);
            }
        }
    }

    public float getScale() {
        return background.getScale();
    }

    public void setScale(float scale) {
        background.setScale(scale);
        for (int column = 0; column < hexGrid.getCells().length; column++) {
            for (int row = 0; row < hexGrid.getCells()[column].length; row++) {
                Cell cell = hexGrid.getCells()[column][row];
                cell.setScale(scale);
                if (cell.getProperties().get(CELLABLE_PROPERTY) == null) {
                    continue;
                }
                Cellable cellable = (Cellable) cell.getProperties().get(CELLABLE_PROPERTY);
                cellable.setScale(scale);
            }
        }
        for (int i = 0; i < pieces.size; i++) {
            pieces.get(i).setScale(scale);
        }
        buildingPanel.setScale(scale);
        slowMotionText.setScale(scale == 0f ? 0.001f : scale);
    }

    public HexGrid getHexGrid() {
        return hexGrid;
    }

    public DelayedRemovalArray<ActionPiece> getPieces() {
        return pieces;
    }

    public BuildingPanel getBuildingPanel() {
        return buildingPanel;
    }
}