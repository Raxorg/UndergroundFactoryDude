package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final FactoryZoneScaler factoryZoneScaler;
    private final GameInputHandler gameInputHandler;
    private final PlayerHandler playerHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        factoryZoneScaler = new FactoryZoneScaler();
        gameInputHandler = new GameInputHandler();
        playerHandler = new PlayerHandler();

        gameInputHandler.setLogic(this);

        playerHandler.setSharedLogic(sharedLogic);
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        factoryZoneScaler.update(delta);
        playerHandler.update(delta);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        factoryZoneScaler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
        playerHandler.setStuff(gameStuff);
    }

    public FactoryZoneScaler getFactoryZoneScaler() {
        return factoryZoneScaler;
    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }
}