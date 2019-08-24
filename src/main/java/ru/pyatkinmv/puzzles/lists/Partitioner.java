package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

public class Partitioner {
    public static <E extends Comparable<E>> void partitionBy(E item, DummyLinkedList<E> list) {
        if (list.first == null) {
            throw new IllegalArgumentException("list is empty");
        }

        Entry<E> firstLess = null;
        Entry<E> lastLess = null;
        Entry<E> firstGreater = null;
        Entry<E> lastGreater = null;

        Entry<E> current = list.first;
        while (current != null) {
            Entry<E> next = current.next;
            current.next = null;
            if (current.item.compareTo(item) < 0) {
                if (firstLess == null) {
                    firstLess = current;
                    lastLess = current;
                } else {
                    lastLess.next = current;
                    lastLess = current;
                }

            } else {
                if (firstGreater == null) {
                    firstGreater = current;
                    lastGreater = current;
                } else {
                    lastGreater.next = current;
                    lastGreater = current;
                }
            }
            current = next;
        }

        if (lastLess == null) {
            list.first = firstGreater;
            return;
        }

        lastLess.next = firstGreater;
        list.first = firstLess;
    }
}
