package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

public class DuplicatesRemover {
    public static <E> void removeDuplicates(DummyLinkedList<E> list) {
        if (list.isEmpty()) {
            return;
        }

        Entry<E> current = list.getFirst();
        Entry<E> inner;
        while (current != null) {
            inner = current;
            while (inner.next != null) {
                if (inner.next.item.equals(current.item)) {
                    inner.next = inner.next.next;
                    continue;
                }
                inner = inner.next;
            }
            current = current.next;
        }
    }
}
