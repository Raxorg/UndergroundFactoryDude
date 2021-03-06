package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Factory extends StaticCellable {

    private float cooldown;

    public Factory(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y + 20f);
    }

    public float getCooldown() {
        return cooldown;
    }

    public void affectCooldown(float amount) {
        cooldown += amount;
    }
}