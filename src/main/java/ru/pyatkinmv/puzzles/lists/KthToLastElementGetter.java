package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

public class KthToLastElementGetter<E> {
    private static final String INDEX_EXCEED_LIST_SIZE = "k > list.size";

    public E get(int k, DummyLinkedList<E> list) {
        int size = getSize(list);
        if (k > size) {
            throw new IllegalArgumentException(INDEX_EXCEED_LIST_SIZE);
        }

        int n = size - k + 1;

        int i = 0;
        for (Entry<E> entry = list.first; entry != null; entry = entry.next) {
            ++i;
            if (i == n) {
                return entry.item;
            }
        }

        throw new IllegalArgumentException("k < 1");
    }

    private int getSize(DummyLinkedList list) {
        int size = 0;
        for (Entry entry = list.first; entry != null; entry = entry.next) {
            ++size;
        }
        return size;
    }

    public E getIterative(int k, DummyLinkedList<E> list) {
        validateIndex(k);
        Entry<E> e2 = list.first;
        int i2 = 0;
        while (i2 != k) {
            if (e2 == null) {
                throw new IllegalArgumentException(INDEX_EXCEED_LIST_SIZE);
            }
            ++i2;
            e2 = e2.next;
        }
        Entry<E> e1 = list.first;
        while (e2 != null) {
            e1 = e1.next;
            e2 = e2.next;
        }
        return e1.item;
    }


    public E getRecursive(int k, DummyLinkedList<E> list) {
        validateIndex(k);
        Entry<E> entry = getRecursive(k, new MutableInt(0), list.first);
        if (entry == null) {
            throw new IllegalArgumentException(INDEX_EXCEED_LIST_SIZE);
        }
        return entry.item;
    }

    private Entry<E> getRecursive(int k, MutableInt index, Entry<E> head) {
        if (head == null) {
            return null;
        }
        Entry<E> entry = getRecursive(k, index, head.next);
        index.setValue(index.getValue() + 1);
        if (k == index.getValue()) {
            return head;
        }
        return entry;
    }

    private void validateIndex(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k < 1");
        }
    }

    private class MutableInt {
        private int value;

        MutableInt(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }
}
