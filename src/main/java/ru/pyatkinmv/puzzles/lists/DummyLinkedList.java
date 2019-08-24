package ru.pyatkinmv.puzzles.lists;

import java.util.Objects;

public class DummyLinkedList<E> {
    public Entry<E> first;

    public void addLast(E item) {
        Entry<E> last = new Entry<>(item);
        if (isEmpty()) {
            first = last;
        } else {
            getLastEntry().next = last;
        }
    }

    public E getFirst() {
        return first.item;
    }

    private Entry<E> getLastEntry() {
        Entry<E> last = first;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public boolean remove(E item) {
        if (isEmpty()) {
            return false;
        }
        if (item.equals(first.item)) {
            first = first.next;
            return true;
        }
        if (first.next == null) {
            return false;
        }
        Entry<E> entry = first;
        while (!item.equals(entry.next.item)) {
            if (entry.next.next == null) {
                return false;
            }
            entry = entry.next;
        }
        entry.next = entry.next.next;
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        DummyLinkedList<?> list = (DummyLinkedList<?>) o;
        Entry<E> entry1 = this.first;
        Entry<?> entry2 = list.first;
        while (entry1 != null && entry2 != null) {
            if (!Objects.equals(entry1.item, entry2.item)) {
                return false;
            }
            entry1 = entry1.next;
            entry2 = entry2.next;
        }

        return checkSizeEquals(entry1, entry2);
    }

    private boolean checkSizeEquals(Entry<E> entry1, Entry<?> entry2) {
        return entry1 == null && entry2 == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    public static class Entry<E> {
        E item;
        Entry<E> next;

        Entry(E item) {
            this.item = item;
        }
    }
}
