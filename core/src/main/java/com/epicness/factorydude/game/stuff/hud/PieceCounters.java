package com.epicness.factorydude.game.stuff.hud;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_50;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.IconedSpritedText;

public class PieceCounters {

    private final IconedSpritedText attackCounter, dashCounter, moveCounter, chonkyCounter;

    public PieceCounters(SharedAssets sharedAssets, GameAssets assets) {
        attackCounter = new IconedSpritedText(
                sharedAssets.getPixel(),
                assets.getSmallTimesSquare(),
                assets.getAttackIcon()
        );
        dashCounter = new IconedSpritedText(
                sharedAssets.getPixel(),
                assets.getSmallTimesSquare(),
                assets.getDashIcon()
        );
        moveCounter = new IconedSpritedText(
                sharedAssets.getPixel(),
                assets.getSmallTimesSquare(),
                assets.getMoveIcon()
        );
        chonkyCounter = new IconedSpritedText(
                sharedAssets.getPixel(),
                assets.getSmallTimesSquare(),
                assets.getChonkyIcon()
        );

        IconedSpritedText[] counters = new IconedSpritedText[4];
        counters[0] = attackCounter;
        counters[1] = dashCounter;
        counters[2] = moveCounter;
        counters[3] = chonkyCounter;
        for (int i = 0; i < counters.length; i++) {
            counters[i].setText("0");
            counters[i].setY(CAMERA_HEIGHT * 0.3f + CAMERA_HEIGHT * 0.1f * i);
            counters[i].setSize(100f, 50f);
            counters[i].setBackgroundColor(BLACK_CLEAR_50);
            counters[i].setIconScale(0.8f);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        attackCounter.draw(spriteBatch);
        dashCounter.draw(spriteBatch);
        moveCounter.draw(spriteBatch);
        chonkyCounter.draw(spriteBatch);
    }

    public IconedSpritedText getAttackCounter() {
        return attackCounter;
    }

    public IconedSpritedText getDashCounter() {
        return dashCounter;
    }

    public IconedSpritedText getMoveCounter() {
        return moveCounter;
    }

    public IconedSpritedText getChonkyCounter() {
        return chonkyCounter;
    }
}