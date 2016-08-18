/*
Author  : Jin (actually auto-generated)
Owner   : Jin
Date    : 16-Aug-2016
 */

package bluepizza.voicetrivia.questions;

/**
 * Simply pairs an object with a boolean value indicating whether or not it's selected.
 */
public class Selectable<T> {

    /**
     * If this value is selected.
     */
    public boolean isSelected;

    /**
     * The value held by this selectable.
     */
    private final T _value;

    /**
     * Instantiates a new Selectable.
     * @param value The value held by this selectable.
     */
    public Selectable(T value) {
        _value = value;
        isSelected = false;
    }

    /**
     * The value held by this selectable.
     * @return The value held by this selectable.
     */
    public T getValue() {
        return _value;
    }

}
