package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {
        throw new UnsupportedOperationException("Not for instantiation");
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] toArray(DummyLinkedList<E> list) {
        List<E> arrayList = new ArrayList<>();
        for (Entry<E> entry = list.first; entry != null; entry = entry.next) {
            arrayList.add(entry.item);
        }
        return (E[]) arrayList.toArray();
    }

    public static <E> DummyLinkedList<E> copy(DummyLinkedList<E> list) {
        if (list.first == null) {
            return new DummyLinkedList<>();
        }
        Entry<E> result = null;
        Entry<E> first = null;
        for (Entry<E> entry = list.first; entry != null; entry = entry.next) {
            if (first == null) {
                first = new Entry<>(entry.item);
                result = first;
                continue;
            }
            result.next = new Entry<>(entry.item);
            result = result.next;
        }
        DummyLinkedList<E> resultList = new DummyLinkedList<>();
        resultList.first = first;
        return resultList;
    }
}
