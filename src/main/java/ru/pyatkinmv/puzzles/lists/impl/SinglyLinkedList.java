package ru.pyatkinmv.puzzles.lists.impl;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Entry<E> first;
    private int size = 0;

    @Override
    public void addFirst(E item) {
        first = new Entry<>(item, first);
        ++size;
    }

    @Override
    public void addLast(E item) {
        Entry<E> last = new Entry<>(item);
        if (isEmpty()) {
            first = last;
        } else {
            getLastEntry().next = last;
        }
        ++size;
    }

    @Override
    public E removeFirst() {
        validateSize();
        E item = first.item;
        first = first.next;
        --size;
        return item;
    }

    @Override
    public E removeLast() {
        validateSize();
        Entry<E> entry = first;
        if (size == 1) {
            first = null;
            --size;
            return entry.item;
        }
        while (entry.next.next != null) {
            entry = entry.next;
        }
        E item = entry.next.item;
        entry.next = null;
        --size;
        return item;
    }

    @Override
    public boolean remove(E item) {
        if (isEmpty()) {
            return false;
        }
        if (item.equals(first.item)) {
            first = first.next;
            --size;
            return true;
        }
        if (size == 1) {
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
        --size;
        return true;
    }

    @Override
    public E getFirst() {
        validateSize();
        return first.item;
    }

    @Override
    public E getLast() {
        validateSize();
        return getLastEntry().item;
    }

    private Entry<E> getLastEntry() {
        Entry<E> last = first;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Entry<E> {
        E item;
        Entry<E> next;

        Entry(E item) {
            this.item = item;
        }

        Entry(E item, Entry<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
