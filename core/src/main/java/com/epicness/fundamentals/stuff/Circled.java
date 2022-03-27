package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.utils.CollisionUtils;

public class Circled {

    private final Circle circle;
    private Color color;

    public Circled(float radius) {
        circle = new Circle();
        circle.radius = radius;
        color = Color.BLACK;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(circle.x, circle.y, circle.radius);
    }

    public void drawContour(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color.cpy().set(1 - color.r, 1 - color.g, 1 - color.b, 1f));
        shapeRenderer.circle(circle.x, circle.y, circle.radius);
    }

    public boolean collides(Rectangle rectangle) {
        Vector2 circleCenter = new Vector2(circle.x, circle.y);
        return CollisionUtils.circleRectCollision(
                circleCenter, rectangle.getCenter(new Vector2()),
                circle.radius, rectangle.width, rectangle.height
        );
    }

    public float getX() {
        return circle.x;
    }

    public void setX(float x) {
        this.circle.x = x;
    }

    public float getY() {
        return circle.y;
    }

    public void setY(float y) {
        circle.y = y;
    }

    public Vector2 getPosition() {
        return new Vector2(circle.x, circle.y);
    }

    public void setPosition(float x, float y) {
        circle.setPosition(x + circle.radius, y + circle.radius);
    }

    public void setOriginBasedPosition(float x, float y) {
        circle.setPosition(circle.x, circle.y);
    }

    public void translate(float xAmount, float yAmount) {
        circle.x += xAmount;
        circle.y += yAmount;
    }

    public void translateX(float amount) {
        circle.x += amount;
    }

    public void translateY(float amount) {
        circle.y += amount;
    }

    public float getRadius() {
        return circle.radius;
    }

    public void setRadius(float radius) {
        circle.radius = radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}