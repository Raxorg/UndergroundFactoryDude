package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.logic.enemies.EnemyAnimator;
import com.epicness.factorydude.game.logic.enemies.EnemyMover;
import com.epicness.factorydude.game.logic.enemies.EnemySpawner;
import com.epicness.factorydude.game.logic.enemies.WaveHandler;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final EnemyAnimator enemyAnimator;
    private final EnemyMover enemyMover;
    private final EnemySpawner enemySpawner;
    private final WaveHandler waveHandler;
    private final BuildingPanelHandler buildingPanelHandler;
    private final BuildingPanelSlider buildingPanelSlider;
    private final BuildingPlacer buildingPlacer;
    private final FactoryZoneScaler factoryZoneScaler;
    private final GameInputHandler gameInputHandler;
    private final HexHighlighter hexHighlighter;
    private final PlayerAnimator playerAnimator;
    private final PlayerAttackHandler playerAttackHandler;
    private final PlayerMover playerMover;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        enemyAnimator = new EnemyAnimator();
        enemyMover = new EnemyMover();
        enemySpawner = new EnemySpawner();
        waveHandler = new WaveHandler();
        buildingPanelHandler = new BuildingPanelHandler();
        buildingPanelSlider = new BuildingPanelSlider();
        buildingPlacer = new BuildingPlacer();
        factoryZoneScaler = new FactoryZoneScaler();
        gameInputHandler = new GameInputHandler();
        hexHighlighter = new HexHighlighter();
        playerAnimator = new PlayerAnimator();
        playerAttackHandler = new PlayerAttackHandler();
        playerMover = new PlayerMover();

        enemyMover.setLogic(this);
        waveHandler.setLogic(this);
        buildingPanelHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        hexHighlighter.setLogic(this);
        playerAttackHandler.setLogic(this);
        playerMover.setLogic(this);

        enemyAnimator.setSharedLogic(sharedLogic);
        enemyMover.setSharedLogic(sharedLogic);
        waveHandler.setSharedLogic(sharedLogic);
        buildingPanelHandler.setSharedLogic(sharedLogic);
        factoryZoneScaler.setSharedLogic(sharedLogic);
        hexHighlighter.setSharedLogic(sharedLogic);
        playerAnimator.setSharedLogic(sharedLogic);
        playerAttackHandler.setSharedLogic(sharedLogic);
        playerMover.setSharedLogic(sharedLogic);
    }

    @Override
    public void initialLogic() {
        buildingPanelSlider.init();
        gameInputHandler.setupInput();
        playerAnimator.init();
    }

    @Override
    public void update(float delta) {
        enemyAnimator.update(delta);
        enemyMover.update(delta);
        waveHandler.update(delta);
        buildingPanelSlider.update(delta);
        factoryZoneScaler.update(delta);
        playerAnimator.update(delta);
        playerAttackHandler.update(delta);
        playerMover.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        enemySpawner.setAssets(gameAssets);
        buildingPlacer.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        enemyMover.setStuff(gameStuff);
        enemySpawner.setStuff(gameStuff);
        waveHandler.setStuff(gameStuff);
        buildingPanelHandler.setStuff(gameStuff);
        buildingPanelSlider.setStuff(gameStuff);
        enemyAnimator.setStuff(gameStuff);
        factoryZoneScaler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
        hexHighlighter.setStuff(gameStuff);
        playerAnimator.setStuff(gameStuff);
        playerAttackHandler.setStuff(gameStuff);
        playerMover.setStuff(gameStuff);
    }

    public EnemyAnimator getEnemyAnimator() {
        return enemyAnimator;
    }

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
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

    public PlayerAnimator getPlayerAnimator() {
        return playerAnimator;
    }

    public PlayerAttackHandler getPlayerAttackHandler() {
        return playerAttackHandler;
    }

    public PlayerMover getPlayerMover() {
        return playerMover;
    }
}