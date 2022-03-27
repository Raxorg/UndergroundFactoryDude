package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.BUILDING_PANEL_SLIDE_DURATION;
import static com.epicness.factorydude.game.GameConstants.BUILDING_PANEL_WIDTH;

import com.epicness.factorydude.game.stuff.factoryzone.BuildingPanel;
import com.epicness.factorydude.game.stuff.GameStuff;

public class BuildingPanelSlider {

    // Structure
    private GameStuff stuff;
    // Logic
    private float progress;
    private boolean opening, closing, open, close;

    public void init() {
        stuff.getFactoryZone().getBuildingPanel().setX(-BUILDING_PANEL_WIDTH);
        close = true;
    }

    public void open() {
        if (open) {
            return;
        }
        if (close) {
            progress = 0f;
        }
        opening = true;
        closing = false;
        close = false;
    }

    public void close() {
        if (close) {
            return;
        }
        if (open) {
            progress = 1f;
        }
        opening = false;
        closing = true;
        open = false;
    }

    public void update(float delta) {
        if (!opening && !closing) {
            return;
        }
        BuildingPanel buildingPanel = stuff.getFactoryZone().getBuildingPanel();
        if (opening) {
            progress = progress + delta / BUILDING_PANEL_SLIDE_DURATION;
            progress = Math.min(progress, 1f);
            buildingPanel.setX(-BUILDING_PANEL_WIDTH + progress * BUILDING_PANEL_WIDTH);
            if (progress == 1f) {
                open = true;
                close = false;
                opening = false;
            }
        }
        if (closing) {
            progress = progress - delta / BUILDING_PANEL_SLIDE_DURATION;
            progress = Math.max(progress, 0f);
            buildingPanel.setX(-BUILDING_PANEL_WIDTH + progress * BUILDING_PANEL_WIDTH);
            if (progress == 0f) {
                open = false;
                close = true;
                closing = false;
            }
        }
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}