package com.epicness.factorydude.game.stuff.hud;

import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_ANIM_SIZE;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_ANIM_Y;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_HEIGHT;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_TEXT_WIDTH;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_TEXT_X;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_TEXT_Y;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_WIDTH;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_X;
import static com.epicness.factorydude.game.GameConstants.COIN_COUNTER_Y;
import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_50;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedAnimation;
import com.epicness.fundamentals.stuff.Text;

public class CoinCounter {

    private final Sprited background;
    private final SpritedAnimation coinAnimation;
    private final Text text;

    public CoinCounter(Sprite backgroundSprite, Sprite[] coinAnimationFrames, BitmapFont font) {
        background = new Sprited(backgroundSprite);
        background.setPosition(COIN_COUNTER_X, COIN_COUNTER_Y);
        background.setSize(COIN_COUNTER_WIDTH, COIN_COUNTER_HEIGHT);
        background.setColor(BLACK_CLEAR_50);

        coinAnimation = new SpritedAnimation(coinAnimationFrames, 0.15f);
        coinAnimation.setPosition(COIN_COUNTER_X, COIN_COUNTER_ANIM_Y);
        coinAnimation.setSize(COIN_COUNTER_ANIM_SIZE);
        coinAnimation.enableLooping();

        text = new Text(font);
        text.setPosition(COIN_COUNTER_TEXT_X, COIN_COUNTER_TEXT_Y);
        text.setTextTargetWidth(COIN_COUNTER_TEXT_WIDTH);
        text.setCenterVertical(true);
        text.setHorizontalAlignment(Align.center);
        text.setText("0");
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        coinAnimation.draw(spriteBatch);
        text.draw(spriteBatch);
    }

    public void addTime(float time) {
        coinAnimation.addTime(time);
    }

    public int getCoins() {
        return Integer.parseInt(text.getText());
    }

    public void addCoin() {
        int coins = Integer.parseInt(text.getText()) + 1;
        text.setText(coins + "");
    }
}