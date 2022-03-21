package com.epicness.factorydude.game;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.initializer.BaseStructure;
import com.epicness.fundamentals.initializer.Initializer;

public class GameInitializer extends Initializer {
    public GameInitializer() {
        super(new GameAssets());
    }

    @Override
    protected BaseStructure defineBaseStructure(SharedResources sharedResources) {
        return new BaseStructure(
                new GameLogic(sharedResources.getLogic()),
                new GameRenderer(),
                new GameStuff()
        );
    }
}