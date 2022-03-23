package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final BuildingPanelHandler buildingPanelHandler;
    private final FactoryZoneScaler factoryZoneScaler;
    private final GameInputHandler gameInputHandler;
    private final HexHighlighter hexHighlighter;
    private final PlayerAnimationHandler playerAnimationHandler;
    private final PlayerAttackHandler playerAttackHandler;
    private final PlayerMover playerMover;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        buildingPanelHandler = new BuildingPanelHandler();
        factoryZoneScaler = new FactoryZoneScaler();
        gameInputHandler = new GameInputHandler();
        hexHighlighter = new HexHighlighter();
        playerAnimationHandler = new PlayerAnimationHandler();
        playerAttackHandler = new PlayerAttackHandler();
        playerMover = new PlayerMover();

        gameInputHandler.setLogic(this);
        hexHighlighter.setLogic(this);
        playerAttackHandler.setLogic(this);
        playerMover.setLogic(this);

        factoryZoneScaler.setSharedLogic(sharedLogic);
        hexHighlighter.setSharedLogic(sharedLogic);
        playerAnimationHandler.setSharedLogic(sharedLogic);
        playerAttackHandler.setSharedLogic(sharedLogic);
        playerMover.setSharedLogic(sharedLogic);
    }

    @Override
    public void initialLogic() {
        buildingPanelHandler.init();
        gameInputHandler.setupInput();
        playerAnimationHandler.init();
    }

    @Override
    public void update(float delta) {
        buildingPanelHandler.update(delta);
        factoryZoneScaler.update(delta);
        playerAnimationHandler.update(delta);
        playerAttackHandler.update(delta);
        playerMover.update(delta);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        buildingPanelHandler.setStuff(gameStuff);
        factoryZoneScaler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
        hexHighlighter.setStuff(gameStuff);
        playerAnimationHandler.setStuff(gameStuff);
        playerAttackHandler.setStuff(gameStuff);
        playerMover.setStuff(gameStuff);
    }

    public BuildingPanelHandler getBuildingPanelHandler() {
        return buildingPanelHandler;
    }

    public FactoryZoneScaler getFactoryZoneScaler() {
        return factoryZoneScaler;
    }

    public HexHighlighter getHexHighlighter() {
        return hexHighlighter;
    }

    public PlayerAnimationHandler getPlayerAnimationSelector() {
        return playerAnimationHandler;
    }

    public PlayerAttackHandler getPlayerAttackHandler() {
        return playerAttackHandler;
    }

    public PlayerMover getPlayerMover() {
        return playerMover;
    }
}