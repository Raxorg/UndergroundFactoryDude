package com.epicness.factorydude;

import com.badlogic.gdx.Game;
import com.epicness.factorydude.splash.SplashAssets;
import com.epicness.factorydude.splash.SplashInitializer;
import com.epicness.fundamentals.SharedResources;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class FactoryGame extends Game {
    @Override
    public void create() {
        SplashAssets splashAssets = new SplashAssets();
        splashAssets.queueAssetLoading();
        splashAssets.finishLoading();
        splashAssets.initializeAssets();
        new SplashInitializer(splashAssets).initialize(new SharedResources());
    }
}