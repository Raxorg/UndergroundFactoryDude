package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;
import com.epicness.fundamentals.stuff.interfaces.Scrollable;

public class IconedSpritedText implements Buttonable, Scrollable {

    private final Sprited background;
    private final Text label;
    private final Sprited icon;
    private float iconScale;

    public IconedSpritedText(Sprite backgroundSprite, BitmapFont font, Sprite iconSprite) {
        background = new Sprited(backgroundSprite);
        label = new Text(font);
        label.setHorizontalAlignment(Align.center);
        label.setCenterVertical(true);
        icon = new Sprited(iconSprite);
        iconScale = 0.65f;
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        label.draw(spriteBatch);
        icon.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return background.getBoundingRectangle().contains(x, y);
    }

    public void setX(float x) {
        background.setX(x);
        label.setX(x);
        icon.setX(x + background.getWidth() - background.getHeight() / 2f - icon.getWidth() / 2f);
    }

    @Override
    public float getY() {
        return background.getY();
    }

    @Override
    public void setY(float y) {
        background.setY(y);
        label.setY(y + background.getHeight() / 2f);
        icon.setY(y + background.getHeight() / 2f - icon.getHeight() / 2f);
    }

    @Override
    public void translateY(float y) {
        background.translateY(y);
        label.translateY(y);
        icon.translateY(y);
    }

    public void setPosition(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setSize(float size) {
        setSize(size, size);
    }

    public void setSize(float width, float height) {
        background.setSize(width, height);
        label.setTextTargetWidth(width - height);
        label.setY(background.getY() + height / 2f);
        setIconScale(iconScale);
    }

    public void setBackgroundColor(Color color) {
        background.setColor(color);
    }

    public void setTextColor(Color color) {
        label.setColor(color);
    }

    public void setIconColor(Color color) {
        icon.setColor(color);
    }

    public void setColor(Color color) {
        setBackgroundColor(color);
        setTextColor(color);
        setIconColor(color);
    }

    public String getText() {
        return label.getText();
    }

    public void setText(String text) {
        label.setText(text);
    }

    public void setIconScale(float scale) {
        float width = background.getWidth(), height = background.getHeight();
        icon.setSize(height * scale);
        icon.setX(background.getX() + width - height / 2f - icon.getWidth() / 2f);
        icon.setY(background.getY() + height / 2f - icon.getHeight() / 2f);
        iconScale = scale;
    }
}