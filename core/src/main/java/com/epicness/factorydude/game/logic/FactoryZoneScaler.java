package com.epicness.factorydude.game.logic;

import static com.epicness.factorydude.game.GameConstants.SCALING_DURATION;

import com.epicness.factorydude.game.stuff.FactoryZone;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.logic.SharedLogic;

public class FactoryZoneScaler {

    // Structure
    private SharedLogic sharedLogic;
    private GameStuff stuff;
    // Logic
    private boolean scalingUp, scalingDown, showing;
    private float progress;

    public void togglePressed() {
        if (scalingUp) {
            scaleDown();
            progress = 1f - progress;
            return;
        }
        if (scalingDown) {
            scaleUp();
            progress = 1f - progress;
            return;
        }
        if (showing) {
            scaleDown();
        } else {
            scaleUp();
        }
        progress = 0f;
    }

    private void scaleUp() {
        scalingUp = true;
        scalingDown = false;
        sharedLogic.getPauseTracker().set(true);
    }

    private void scaleDown() {
        scalingUp = false;
        scalingDown = true;
    }

    public void update(float delta) {
        if (!scalingUp && !scalingDown) {
            return;
        }
        progress = Math.min(progress + delta / SCALING_DURATION, 1f);
        FactoryZone factoryZone = stuff.getFactoryZone();
        if (scalingUp) {
            factoryZone.setScale(progress);
        } else if (scalingDown) {
            factoryZone.setScale(1f - progress);
        }
        if (progress == 1f) {
            if (scalingDown) {
                sharedLogic.getPauseTracker().set(false);
            }
            showing = scalingUp;
            scalingUp = false;
            scalingDown = false;
        }
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}