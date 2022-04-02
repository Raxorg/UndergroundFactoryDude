package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.SpritedAnimation;
import com.epicness.fundamentals.stuff.grid.Cell;

public class ConveyorBelt implements Cellable {

    private final SpritedAnimation animation;
    private final Cell cell;
    private Cell destination;

    public ConveyorBelt(Sprite[] conveyorFrames, Cell cell) {
        animation = new SpritedAnimation(conveyorFrames, 0.25f);
        animation.setSize(75f);
        animation.enableLooping();

        this.cell = cell;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        animation.draw(spriteBatch);
    }

    @Override
    public void setPosition(float x, float y) {
        animation.setPosition(x, y);
    }

    @Override
    public void setOriginCenter() {
        animation.setOriginCenter();
    }

    @Override
    public void setScale(float scale) {
        animation.setScale(scale);
    }

    @Override
    public float getSize() {
        return animation.getWidth();
    }

    public void addTime(float time) {
        animation.addTime(time);
    }

    public float getRotation() {
        return animation.getRotation();
    }

    public void setRotation(float degrees) {
        animation.setRotation(degrees);
    }

    public Cell getCell() {
        return cell;
    }

    public Cell getDestination() {
        return destination;
    }

    public void setDestination(Cell destination) {
        this.destination = destination;
    }
}