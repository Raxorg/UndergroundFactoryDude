package com.epicness.factorydude.game.stuff.pieces;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.enums.PieceType;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.grid.Cell;

public class ActionPiece {

    private final Sprited sprited;
    private Cell origin, destination;
    private float progress;
    private final PieceType type;

    public ActionPiece(Sprite actionSprite, PieceType type, Cell originCell, Cell destinationCell) {
        sprited = new Sprited(actionSprite);
        sprited.setOriginCenter();
        float x = originCell.getX() + originCell.getWidth() / 2f;
        float y = originCell.getY() + originCell.getHeight() / 2f;
        setOriginBasedPosition(x, y);
        origin = originCell;
        destination = destinationCell;
        this.type = type;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public void setOriginBasedPosition(float x, float y) {
        sprited.setOriginBasedPosition(x, y);
    }

    public float getWidth() {
        return sprited.getWidth();
    }

    public float getHeight() {
        return sprited.getHeight();
    }

    public Cell getOrigin() {
        return origin;
    }

    public void setOrigin(Cell origin) {
        this.origin = origin;
    }

    public Cell getDestination() {
        return destination;
    }

    public void setDestination(Cell destination) {
        this.destination = destination;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public PieceType getType() {
        return type;
    }
}