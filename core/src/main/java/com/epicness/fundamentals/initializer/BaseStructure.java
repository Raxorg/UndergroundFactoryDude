package com.epicness.fundamentals.initializer;

import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.fundamentals.stuff.Stuff;

public class BaseStructure {

    private final Logic logic;
    private final Renderer renderer;
    private final Stuff stuff;

    public BaseStructure(Logic logic, Renderer renderer, Stuff stuff) {
        this.logic = logic;
        this.renderer = renderer;
        this.stuff = stuff;
    }

    public Logic getLogic() {
        return logic;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public Stuff getStuff() {
        return stuff;
    }
}