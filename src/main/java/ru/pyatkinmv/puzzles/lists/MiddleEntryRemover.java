package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

public class MiddleEntryRemover {
    public static <E> void remove(Entry<E> entry) {
        if (entry.next == null) {
            throw new IllegalArgumentException("Could not remove last element");
        }
        Entry<E> next = entry.next;
        entry.item = next.item;
        entry.next = next.next;
    }
}
