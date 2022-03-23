package com.epicness.factorydude.game.stuff;

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
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.grid.Cell;

public class FactoryZone {

    private final Sprited background;
    private final HexGrid hexGrid;
    private final BuildingPanel buildingPanel;

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

        buildingPanel = new BuildingPanel(sharedAssets, assets);

        setScale(0f);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        hexGrid.draw(spriteBatch);
        drawCellables(spriteBatch);
        buildingPanel.draw(spriteBatch);
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
        buildingPanel.setScale(scale);
    }

    public HexGrid getHexGrid() {
        return hexGrid;
    }

    public BuildingPanel getBuildingPanel() {
        return buildingPanel;
    }
}