package com.epicness.factorydude.splash;

import com.epicness.factorydude.game.GameInitializer;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;

public class SplashLogic extends Logic {

    public SplashLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    @Override
    public void initialLogic() {
        sharedLogic.getTransitionHandler().startTransition(new GameInitializer());
        sharedLogic.getTransitionHandler().allowTransition();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getTransitionHandler().update();
    }
}