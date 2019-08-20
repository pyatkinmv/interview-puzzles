package ru.pyatkinmv.puzzles.rotator;

public interface Rotator<T> {
    T rotate(T rotatable, boolean clockwise);
}
