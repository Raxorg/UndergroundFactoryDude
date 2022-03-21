package com.epicness.factorydude.splash;

import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.initializer.BaseStructure;
import com.epicness.fundamentals.initializer.Initializer;

public class SplashInitializer extends Initializer {

    public SplashInitializer(SplashAssets assets) {
        super(assets);
    }

    @Override
    protected BaseStructure defineBaseStructure(SharedResources sharedResources) {
        return new BaseStructure(
                new SplashLogic(sharedResources.getLogic()),
                new SplashRenderer(),
                new SplashStuff()
        );
    }
}