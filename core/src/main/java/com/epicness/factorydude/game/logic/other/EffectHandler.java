package com.epicness.factorydude.game.logic.other;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.factorydude.game.stuff.effects.SlashEffect;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class EffectHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<SpritedAnimation> animations = stuff.getEffects();
        animations.begin();
        for (int i = 0; i < animations.size; i++) {
            SpritedAnimation animation = animations.get(i);
            animation.addTime(delta);
            if (animation.ended()) {
                animations.removeValue(animation, true);
            }
        }
        animations.end();
    }

    public void spawnSlash() {
        Player player = stuff.getPlayer();
        for (int i = 0; i < 2; i++) {
            SpritedAnimation slash = new SlashEffect(assets.getPlayerSlash(), 0.03f);
            slash.setPosition(player.getCenterX() - slash.getWidth() / 2f, player.getCenterY() - slash.getHeight() / 2f);
            stuff.getEffects().add(slash);
            if (i == 0) {
                slash.setColor(Color.CLEAR);
                continue;
            }
            float xAmount = 0f, yAmount = 0f;
            if (player.isFacingRight()) {
                xAmount = player.getWidth() * 0.75f;
            } else if (player.isFacingLeft()) {
                xAmount = -player.getWidth() * 0.75f;
                slash.setRotation(180f);
                slash.setFlip(false, true);
            } else if (player.isFacingUp()) {
                yAmount = player.getHeight() * 0.5f;
                slash.setRotation(90f);
                slash.setFlip(false, player.isFlipX());
            } else {
                yAmount = -player.getHeight() * 0.5f;
                slash.setRotation(-90f);
                slash.setFlip(false, player.isFlipX());
            }
            slash.translate(xAmount, yAmount);
        }
    }

    public void spawnDash() {
        Player player = stuff.getPlayer();
        SpritedAnimation dash = new SpritedAnimation(assets.getDash(), 0.05f);
        dash.setPosition(player.getCenterX() - dash.getWidth() / 2f, player.getCenterY() - dash.getHeight() / 2f);
        dash.setRotation(player.getSpeed().angleDeg());
        stuff.getEffects().add(dash);
    }

    public void spawnBloodEffects(float x, float y) {
        for (int i = 0; i < 10; i++) {
            SpritedAnimation bloodSplatter = new SpritedAnimation(assets.getBloodSplatterFrames(), 0.075f);
            SpritedAnimation bloodWound = new SpritedAnimation(assets.getBloodWoundFrames(), 0.075f);
            float bloodX = MathUtils.random(-50f, 50f);
            float bloodY = MathUtils.random(-50f, 50f);
            bloodSplatter.setPosition(x + bloodX, y + bloodY);
            bloodSplatter.setRotation(MathUtils.random(360f));
            bloodWound.setPosition(x + bloodX * 2f, y + bloodY * 2f);
            bloodWound.setRotation(MathUtils.random(360f));
            stuff.getEffects().add(bloodSplatter);
            stuff.getEffects().add(bloodWound);
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}