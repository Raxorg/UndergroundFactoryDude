package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.logic.enemies.BulletHandler;
import com.epicness.factorydude.game.logic.enemies.EnemyAnimator;
import com.epicness.factorydude.game.logic.enemies.EnemyAttackHandler;
import com.epicness.factorydude.game.logic.enemies.EnemyMover;
import com.epicness.factorydude.game.logic.enemies.EnemySpawner;
import com.epicness.factorydude.game.logic.enemies.WaveAnnouncer;
import com.epicness.factorydude.game.logic.enemies.WaveHandler;
import com.epicness.factorydude.game.logic.factoryzone.BuildingPanelHandler;
import com.epicness.factorydude.game.logic.factoryzone.BuildingPanelSlider;
import com.epicness.factorydude.game.logic.factoryzone.BuildingPlacer;
import com.epicness.factorydude.game.logic.factoryzone.FactoryZoneScaler;
import com.epicness.factorydude.game.logic.factoryzone.HexHighlighter;
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
    private BulletHandler bulletHandler;
    private EnemyAnimator enemyAnimator;
    private EnemyAttackHandler enemyAttackHandler;
    private EnemyMover enemyMover;
    private EnemySpawner enemySpawner;
    private WaveAnnouncer waveAnnouncer;
    private WaveHandler waveHandler;
    // Factory zone
    private BuildingPanelHandler buildingPanelHandler;
    private BuildingPanelSlider buildingPanelSlider;
    private BuildingPlacer buildingPlacer;
    private FactoryZoneScaler factoryZoneScaler;
    private HexHighlighter hexHighlighter;
    // Player
    private CameraHandler cameraHandler;
    private PlayerAnimator playerAnimator;
    private PlayerAttackHandler playerAttackHandler;
    private PlayerMover playerMover;
    // Other
    private CoinHandler coinHandler;
    private CursorHandler cursorHandler;
    private EffectHandler effectHandler;
    private GameInputHandler gameInputHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    @Override
    public void initHelpers() {
        // Enemy
        bulletHandler = new BulletHandler();
        enemyAnimator = new EnemyAnimator();
        enemyAttackHandler = new EnemyAttackHandler();
        enemyMover = new EnemyMover();
        enemySpawner = new EnemySpawner();
        waveAnnouncer = new WaveAnnouncer();
        waveHandler = new WaveHandler();
        // Factory zone
        buildingPanelHandler = new BuildingPanelHandler();
        buildingPanelSlider = new BuildingPanelSlider();
        buildingPlacer = new BuildingPlacer();
        factoryZoneScaler = new FactoryZoneScaler();
        hexHighlighter = new HexHighlighter();
        // Player
        cameraHandler = new CameraHandler();
        playerAnimator = new PlayerAnimator();
        playerAttackHandler = new PlayerAttackHandler();
        playerMover = new PlayerMover();
        // Other
        coinHandler = new CoinHandler();
        cursorHandler = new CursorHandler();
        effectHandler = new EffectHandler();
        gameInputHandler = new GameInputHandler();
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
        cursorHandler.init();
        gameInputHandler.setupInput();
        waveAnnouncer.announceWave(1);
    }

    @Override
    public void update(float delta) {
        // Enemy
        bulletHandler.update(delta);
        enemyAnimator.update(delta);
        enemyAttackHandler.update(delta);
        enemyMover.update(delta);
        waveAnnouncer.update(delta);
        waveHandler.update(delta);
        // Factory zone
        buildingPanelSlider.update(delta);
        factoryZoneScaler.update(delta);
        // Player
        playerAnimator.update(delta);
        playerAttackHandler.update(delta);
        playerMover.update(delta);
        cameraHandler.update();
        // Other
        coinHandler.update(delta);
        cursorHandler.update(delta);
        effectHandler.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        enemyAttackHandler.setAssets(gameAssets);
        enemySpawner.setAssets(gameAssets);
        buildingPlacer.setAssets(gameAssets);
        effectHandler.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        // Enemy
        bulletHandler.setStuff(gameStuff);
        enemyAnimator.setStuff(gameStuff);
        enemyAttackHandler.setStuff(gameStuff);
        enemyMover.setStuff(gameStuff);
        enemySpawner.setStuff(gameStuff);
        waveAnnouncer.setStuff(gameStuff);
        waveHandler.setStuff(gameStuff);
        // Factory zone
        buildingPanelHandler.setStuff(gameStuff);
        buildingPanelSlider.setStuff(gameStuff);
        factoryZoneScaler.setStuff(gameStuff);
        hexHighlighter.setStuff(gameStuff);
        // Player
        cameraHandler.setStuff(gameStuff);
        playerAnimator.setStuff(gameStuff);
        playerAttackHandler.setStuff(gameStuff);
        playerMover.setStuff(gameStuff);
        // Other
        coinHandler.setStuff(gameStuff);
        cursorHandler.setStuff(gameStuff);
        effectHandler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
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

    // Factory zone
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
    public CoinHandler getCoinHandler() {
        return coinHandler;
    }

    public CursorHandler getCursorHandler() {
        return cursorHandler;
    }

    public EffectHandler getEffectHandler() {
        return effectHandler;
    }
}