package com.epicness.factorydude.game.logic.factoryzone;

import com.badlogic.gdx.graphics.Color;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.grid.Cell;

public class BuildingPanelHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;

    public void mouseUpdate(float x, float y) {
        if (!sharedLogic.getPauseTracker().get()) {
            return;
        }
        Sprited factoryOption = stuff.getFactoryZone().getBuildingPanel().getFactoryOption();
        Sprited conveyorOption = stuff.getFactoryZone().getBuildingPanel().getConveyorOption();
        factoryOption.setColor(Color.WHITE);
        conveyorOption.setColor(Color.WHITE);
        if (factoryOption.contains(x, y)) {
            factoryOption.setColor(Color.GREEN);
        } else if (conveyorOption.contains(x, y)) {
            conveyorOption.setColor(Color.GREEN);
        }
    }

    public void touchDown(float x, float y) {
        if (!sharedLogic.getPauseTracker().get()) {
            return;
        }
        Sprited factoryOption = stuff.getFactoryZone().getBuildingPanel().getFactoryOption();
        Sprited conveyorOption = stuff.getFactoryZone().getBuildingPanel().getConveyorOption();
        int selectedOption;
        if (factoryOption.contains(x, y)) {
            selectedOption = 0;
        } else if (conveyorOption.contains(x, y)) {
            selectedOption = 1;
        } else {
            return;
        }
        Cell selectedCell = logic.getHexHighlighter().getSelectedCell();
        if (selectedCell == null) {
            return;
        }
        logic.getBuildingPlacer().placeCellable(selectedCell, selectedOption);
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}