package com.epicness.factorydude.game.logic.factoryzone;

import static com.epicness.factorydude.game.GameConstants.CELLABLE_PROPERTY;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.Cellable;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;
import com.epicness.fundamentals.stuff.grid.Cell;

public class ConveyorAnimator {

    // Structure
    private GameStuff stuff;

    public void update(float delta) {
        Cell[][] cells = stuff.getFactoryZone().getHexGrid().getCells();
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                Cellable cellable = (Cellable) cells[column][row].getProperties().get(CELLABLE_PROPERTY);
                if (cellable instanceof ConveyorBelt) {
                    ((ConveyorBelt) cellable).addTime(delta);
                }
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}