package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.AnimationUpdater;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final FactoryZoneScaler factoryZoneScaler;
    private final GameInputHandler gameInputHandler;
    private final HexHighlighter hexHighlighter;
    private final PlayerMover playerMover;
    private final PlayerRotator playerRotator;
    private final AnimationUpdater playerAnimationUpdater;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        factoryZoneScaler = new FactoryZoneScaler();
        gameInputHandler = new GameInputHandler();
        hexHighlighter = new HexHighlighter();
        playerMover = new PlayerMover();
        playerRotator = new PlayerRotator();
        playerAnimationUpdater = new AnimationUpdater();

        gameInputHandler.setLogic(this);
        playerRotator.setLogic(this);

        factoryZoneScaler.setSharedLogic(sharedLogic);
        hexHighlighter.setSharedLogic(sharedLogic);
        playerMover.setSharedLogic(sharedLogic);
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
        playerRotator.init();
    }

    @Override
    public void update(float delta) {
        factoryZoneScaler.update(delta);
        playerMover.update(delta);
        playerAnimationUpdater.update(delta);
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
        hexHighlighter.setStuff(gameStuff);
        playerMover.setStuff(gameStuff);
        playerRotator.setStuff(gameStuff);
    }

    public FactoryZoneScaler getFactoryZoneScaler() {
        return factoryZoneScaler;
    }

    public HexHighlighter getHexHighlighter() {
        return hexHighlighter;
    }

    public PlayerMover getPlayerHandler() {
        return playerMover;
    }

    public AnimationUpdater getPlayerAnimationUpdater() {
        return playerAnimationUpdater;
    }
}