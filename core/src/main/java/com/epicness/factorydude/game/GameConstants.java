package com.epicness.factorydude.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Player
    public static final float PLAYER_SPEED = 400f;
    // Factory zone
    public static final float SCALING_DURATION = 0.25f;
    // Hex grid
    public static final int HEX_GRID_COLUMNS = 10;
    public static final int HEX_GRID_ROWS = 5;
    public static final float HEX_GRID_CELL_SIZE = 100f;
    public static final float HEX_GRID_WIDTH = HEX_GRID_COLUMNS * (HEX_GRID_CELL_SIZE * 0.98f);
    public static final float HEX_GRID_HEIGHT = HEX_GRID_ROWS * (HEX_GRID_CELL_SIZE * 0.74f);
    public static final float HEX_GRID_STARTING_X = CAMERA_WIDTH / 2f - HEX_GRID_WIDTH / 2f;
    public static final float HEX_GRID_STARTING_Y = CAMERA_HEIGHT / 2f - HEX_GRID_HEIGHT / 2f;
}