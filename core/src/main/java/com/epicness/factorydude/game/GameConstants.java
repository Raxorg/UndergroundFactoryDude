package com.epicness.factorydude.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Cellables
    public static final String CELLABLE_PROPERTY = "Cellable";
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
    // Building panel
    public static final float BUILDING_PANEL_WIDTH = 300f;
    public static final float BUILDING_PANEL_HEIGHT = CAMERA_HEIGHT;
    public static final float BUILDING_PANEL_SLIDE_DURATION = 0.3f;
    // Panel option
    public static final float OPTION_SIZE = BUILDING_PANEL_WIDTH / 2f;
    public static final float OPTION_X_OFFSET = BUILDING_PANEL_WIDTH / 2f - OPTION_SIZE / 2f;
    // Factory option
    public static final float FACTORY_OPTION_Y = BUILDING_PANEL_HEIGHT / 2f - OPTION_SIZE / 2f;
    // Coin counter
    public static final float COIN_COUNTER_WIDTH = 300f;
    public static final float COIN_COUNTER_HEIGHT = 100f;
    public static final float COIN_COUNTER_Y = CAMERA_HEIGHT - COIN_COUNTER_HEIGHT;
    public static final float COIN_COUNTER_ANIM_SIZE = COIN_COUNTER_HEIGHT * 0.8f;
    public static final float COIN_COUNTER_ANIM_Y = COIN_COUNTER_Y + COIN_COUNTER_HEIGHT / 2f - COIN_COUNTER_ANIM_SIZE / 2f;
    public static final float COIN_COUNTER_TEXT_X = CAMERA_WIDTH - COIN_COUNTER_WIDTH + COIN_COUNTER_ANIM_SIZE;
    public static final float COIN_COUNTER_TEXT_Y = COIN_COUNTER_Y + COIN_COUNTER_HEIGHT / 2f;
    public static final float COIN_COUNTER_TEXT_WIDTH = COIN_COUNTER_WIDTH - COIN_COUNTER_ANIM_SIZE;
    // Bullet
    public static final float BULLET_SIZE = 50f;
    public static final float BULLET_RADIUS = BULLET_SIZE / 2f;
    public static final float BULLET_BOUNDS_RADIUS = BULLET_RADIUS / 2f;
}