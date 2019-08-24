package ru.pyatkinmv.puzzles.lists;

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

    public static class Entry<E> {
        E item;
        Entry<E> next;

        Entry(E item) {
            this.item = item;
        }
    }
}
