package ru.pyatkinmv.puzzles.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Utils {
    private Utils() {
        throw new UnsupportedOperationException("Not for instantiation");
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] toArray(DummyLinkedList<E> list) {
        List<E> arrayList = new ArrayList<>();
        for (DummyLinkedList.Entry<E> entry = list.first; entry != null; entry = entry.next) {
            arrayList.add(entry.item);
        }
        return (E[]) arrayList.toArray();
    }

    public static <E> void addAll(DummyLinkedList<E> list, Collection<E> c) {
        for (E item : c) {
            list.addLast(item);
        }
    }
}
