package com.epicness.fundamentals.logic.behaviors;

import com.epicness.fundamentals.stuff.SpriteAnimation;

public class AnimationUpdater {

    private SpriteAnimation animation;
    private boolean enabled;

    public void setup(SpriteAnimation animation) {
        this.animation = animation;
        enabled = true;
    }

    public void update(float delta) {
        if (!enabled) {
            return;
        }
        animation.addTime(delta);
    }
}