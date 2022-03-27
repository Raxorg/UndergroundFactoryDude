package com.epicness.fundamentals.utils;

import com.badlogic.gdx.math.Vector2;

public class CollisionUtils {

    static public Boolean circleRectCollision(Vector2 circleCenter, Vector2 rectCenter,
                                              float radius, float width, float height) {
        float distanceY = Math.abs(circleCenter.y - rectCenter.y);
        if (distanceY > (height / 2 + radius)) return false;

        float distanceX = Math.abs(circleCenter.x - rectCenter.x);
        if (distanceX > (width / 2 + radius)) return false;

        if (distanceX <= (width / 2)) return true;
        if (distanceY <= (height / 2)) return true;

        float a = distanceX - width / 2;
        float b = distanceY - height / 2;
        float cSqr = a * a + b * b;
        return (cSqr <= (radius * radius));
    }
}