package com.epicness.fundamentals.logic.behaviors;

import com.epicness.fundamentals.logic.interfaces.Listener;

import java.util.ArrayList;

public class Tracker<A> {

    private A trackedObject;
    private final ArrayList<Listener<A>> listeners;

    public Tracker(A objectToTrack) {
        trackedObject = objectToTrack;
        listeners = new ArrayList<>();
    }

    public A get() {
        return trackedObject;
    }

    public void set(A trackedObject) {
        this.trackedObject = trackedObject;
        listeners.forEach(listener -> listener.onChange(trackedObject));
    }

    public void listen(Listener<A> listener) {
        listeners.add(listener);
    }
}