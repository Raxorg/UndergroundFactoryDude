package com.epicness.factorydude.game.stuff.pieces;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.epicness.factorydude.game.enums.PieceType;
import com.epicness.fundamentals.stuff.Sprited;

public class ActionPiece {

    private final Sprited sprited;
    private final Vector2 origin, destination;
    private float progress;
    private final PieceType type;

    public ActionPiece(Sprite actionSprite, PieceType type) {
        sprited = new Sprited(actionSprite);
        origin = new Vector2();
        destination = new Vector2();
        this.type = type;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
    }

    public float getWidth() {
        return sprited.getWidth();
    }

    public float getHeight() {
        return sprited.getHeight();
    }

    public Vector2 getOrigin() {
        return origin;
    }

    public Vector2 getDestination() {
        return destination;
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