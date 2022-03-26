package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.logic.enemies.EnemyAnimator;
import com.epicness.factorydude.game.logic.enemies.EnemyMover;
import com.epicness.factorydude.game.logic.enemies.EnemySpawner;
import com.epicness.factorydude.game.logic.enemies.WaveHandler;
import com.epicness.factorydude.game.logic.player.CameraHandler;
import com.epicness.factorydude.game.logic.player.PlayerAnimator;
import com.epicness.factorydude.game.logic.player.PlayerAttackHandler;
import com.epicness.factorydude.game.logic.player.PlayerMover;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    // Enemy
    private EnemyAnimator enemyAnimator;
    private EnemyMover enemyMover;
    private EnemySpawner enemySpawner;
    private WaveHandler waveHandler;
    // Player
    private CameraHandler cameraHandler;
    private PlayerAnimator playerAnimator;
    private PlayerAttackHandler playerAttackHandler;
    private PlayerMover playerMover;
    // Other
    private BuildingPanelHandler buildingPanelHandler;
    private BuildingPanelSlider buildingPanelSlider;
    private BuildingPlacer buildingPlacer;
    private FactoryZoneScaler factoryZoneScaler;
    private GameInputHandler gameInputHandler;
    private HexHighlighter hexHighlighter;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    @Override
    public void initHelpers() {
        // Enemy
        enemyAnimator = new EnemyAnimator();
        enemyMover = new EnemyMover();
        enemySpawner = new EnemySpawner();
        waveHandler = new WaveHandler();
        // Player
        cameraHandler = new CameraHandler();
        playerAnimator = new PlayerAnimator();
        playerAttackHandler = new PlayerAttackHandler();
        playerMover = new PlayerMover();
        // Other
        buildingPanelHandler = new BuildingPanelHandler();
        buildingPanelSlider = new BuildingPanelSlider();
        buildingPlacer = new BuildingPlacer();
        factoryZoneScaler = new FactoryZoneScaler();
        gameInputHandler = new GameInputHandler();
        hexHighlighter = new HexHighlighter();
    }

    @Override
    protected void setSharedLogic() {
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
    protected void setLogic() {
        enemyMover.setLogic(this);
        waveHandler.setLogic(this);
        buildingPanelHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        hexHighlighter.setLogic(this);
        playerAttackHandler.setLogic(this);
        playerMover.setLogic(this);
    }

    @Override
    public void initialLogic() {
        buildingPanelSlider.init();
        gameInputHandler.setupInput();
        playerAnimator.init();
    }

    @Override
    public void update(float delta) {
        // Enemy
        enemyAnimator.update(delta);
        enemyMover.update(delta);
        waveHandler.update(delta);
        // Player
        cameraHandler.update();
        playerAnimator.update(delta);
        playerAttackHandler.update(delta);
        playerMover.update(delta);
        // Other
        buildingPanelSlider.update(delta);
        factoryZoneScaler.update(delta);
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
        // Enemy
        enemyMover.setStuff(gameStuff);
        enemySpawner.setStuff(gameStuff);
        waveHandler.setStuff(gameStuff);
        // Player
        cameraHandler.setStuff(gameStuff);
        playerAnimator.setStuff(gameStuff);
        playerAttackHandler.setStuff(gameStuff);
        playerMover.setStuff(gameStuff);
        // Other
        buildingPanelHandler.setStuff(gameStuff);
        buildingPanelSlider.setStuff(gameStuff);
        enemyAnimator.setStuff(gameStuff);
        factoryZoneScaler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
        hexHighlighter.setStuff(gameStuff);
    }

    @Override
    public void setScreen(SharedScreen screen) {
        cameraHandler.setScreen(screen);
    }

    // Enemy
    public EnemyAnimator getEnemyAnimator() {
        return enemyAnimator;
    }

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
    }

    // Player
    public PlayerAnimator getPlayerAnimator() {
        return playerAnimator;
    }

    public PlayerAttackHandler getPlayerAttackHandler() {
        return playerAttackHandler;
    }

    public PlayerMover getPlayerMover() {
        return playerMover;
    }

    // Other
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
}