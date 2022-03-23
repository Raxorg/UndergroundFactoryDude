package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final BuildingPanelHandler buildingPanelHandler;
    private final BuildingPanelSlider buildingPanelSlider;
    private final BuildingPlacer buildingPlacer;
    private final FactoryZoneScaler factoryZoneScaler;
    private final GameInputHandler gameInputHandler;
    private final HexHighlighter hexHighlighter;
    private final PlayerAnimationHandler playerAnimationHandler;
    private final PlayerAttackHandler playerAttackHandler;
    private final PlayerMover playerMover;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        buildingPanelHandler = new BuildingPanelHandler();
        buildingPanelSlider = new BuildingPanelSlider();
        buildingPlacer = new BuildingPlacer();
        factoryZoneScaler = new FactoryZoneScaler();
        gameInputHandler = new GameInputHandler();
        hexHighlighter = new HexHighlighter();
        playerAnimationHandler = new PlayerAnimationHandler();
        playerAttackHandler = new PlayerAttackHandler();
        playerMover = new PlayerMover();

        buildingPanelHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        hexHighlighter.setLogic(this);
        playerAttackHandler.setLogic(this);
        playerMover.setLogic(this);

        buildingPanelHandler.setSharedLogic(sharedLogic);
        factoryZoneScaler.setSharedLogic(sharedLogic);
        hexHighlighter.setSharedLogic(sharedLogic);
        playerAnimationHandler.setSharedLogic(sharedLogic);
        playerAttackHandler.setSharedLogic(sharedLogic);
        playerMover.setSharedLogic(sharedLogic);
    }

    @Override
    public void initialLogic() {
        buildingPanelSlider.init();
        gameInputHandler.setupInput();
        playerAnimationHandler.init();
    }

    @Override
    public void update(float delta) {
        buildingPanelSlider.update(delta);
        factoryZoneScaler.update(delta);
        playerAnimationHandler.update(delta);
        playerAttackHandler.update(delta);
        playerMover.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        buildingPlacer.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        buildingPanelHandler.setStuff(gameStuff);
        buildingPanelSlider.setStuff(gameStuff);
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

    public BuildingPanelSlider getBuildingPanelSlider() {
        return buildingPanelSlider;
    }

    public BuildingPlacer getBuildingPlacer() {
        return buildingPlacer;
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