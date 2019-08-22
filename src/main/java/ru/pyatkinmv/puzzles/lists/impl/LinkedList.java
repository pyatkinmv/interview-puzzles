package ru.pyatkinmv.puzzles.lists.impl;

import java.util.NoSuchElementException;

public interface LinkedList<E> {
    void addFirst(E entry);

    void addLast(E entry);

    E removeFirst();

    E removeLast();

    boolean remove(E item);

    E getFirst();

    E getLast();

    int getSize();

    boolean isEmpty();

    default void validateSize() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}
