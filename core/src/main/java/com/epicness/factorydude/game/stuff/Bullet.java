package com.epicness.factorydude.game.stuff;

import static com.epicness.factorydude.game.GameConstants.BULLET_BOUNDS_RADIUS;
import static com.epicness.factorydude.game.GameConstants.BULLET_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.Circled;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class Bullet {

    private final SpritedAnimation animation;
    private final Circled circled;
    private final Vector2 speed;

    public Bullet(Sprite[] bulletFrames) {
        animation = new SpritedAnimation(bulletFrames, 0.1f);
        animation.setSize(BULLET_SIZE);
        animation.enableLooping();
        circled = new Circled(BULLET_BOUNDS_RADIUS);
        speed = new Vector2();
    }

    public void draw(SpriteBatch spriteBatch) {
        animation.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        circled.drawContour(shapeRenderer);
    }

    public boolean collides(Rectangle rectangle) {
        return circled.collides(rectangle);
    }

    public void setPosition(float x, float y) {
        animation.setPosition(x - BULLET_BOUNDS_RADIUS, y - BULLET_BOUNDS_RADIUS);
        circled.setPosition(x, y);
    }

    public void translate(float xAmount, float yAmount) {
        animation.translate(xAmount, yAmount);
        circled.translate(xAmount, yAmount);
    }

    public void setColor(Color color) {
        animation.setColor(color);
    }

    public void addTime(float seconds) {
        animation.addTime(seconds);
    }

    public Vector2 getSpeed() {
        return speed;
    }
}