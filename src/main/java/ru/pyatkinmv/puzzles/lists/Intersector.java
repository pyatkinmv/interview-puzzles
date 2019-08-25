package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import java.util.Optional;

import static java.lang.Math.abs;
import static ru.pyatkinmv.puzzles.lists.Utils.getSize;

public class Intersector<E> {
    private final DummyLinkedList<E> list1;
    private final DummyLinkedList<E> list2;

    public Intersector(DummyLinkedList<E> list1, DummyLinkedList<E> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public Optional<Entry<E>> intersect() {
        Entry<E> entry1 = list1.first;
        Entry<E> entry2 = list2.first;
        int size1 = getSize(list1);
        int size2 = getSize(list2);
        if (size1 > size2) {
            entry1 = shift(entry1, abs(size1 - size2));
        } else if (size2 > size1) {
            entry2 = shift(entry2, abs(size1 - size2));
        }
        return Optional.of(intersect(entry1, entry2));
    }

    private Entry<E> shift(Entry<E> entry, int diff) {
        while (diff != 0) {
            entry = entry.next;
            --diff;
        }
        return entry;
    }

    private Entry<E> intersect(Entry<E> e1, Entry<E> e2) {
        Entry<E> firstEqual = null;
        while (e1 != null && e2 != null) {
            if (e1 == e2 && firstEqual == null) {
                firstEqual = e1;
            }
            e1 = e1.next;
            e2 = e2.next;
        }
        return firstEqual;
    }
}
