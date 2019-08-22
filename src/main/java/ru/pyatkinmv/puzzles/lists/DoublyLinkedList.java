package ru.pyatkinmv.puzzles.lists;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private Entry<E> first;
    private Entry<E> last;
    private int size = 0;

    @Override
    public void addFirst(E item) {
        Entry<E> entry = new Entry<>(item);
        if (isEmpty()) {
            first = entry;
            last = entry;
        } else {
            entry.next = first;
            first.prev = entry;
            first = entry;
        }
        ++size;
    }

    @Override
    public void addLast(E item) {
        Entry<E> entry = new Entry<>(item);
        if (isEmpty()) {
            last = entry;
            first = entry;
        } else {
            entry.prev = last;
            last.next = entry;
            last = entry;
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
        E item = last.item;
        last = last.prev;
        --size;
        return item;
    }

    @Override
    public boolean remove(E item) {
        if (isEmpty()) {
            return false;
        }
        Entry<E> entry = first;
        while (!item.equals(entry.item)) {
            if (entry.next == null) {
                return false;
            }
            entry = entry.next;
        }
        remove(entry);
        --size;
        return true;
    }

    private void remove(Entry<E> entry) {
        if (first == last) {
            first = null;
            last = null;
            return;
        }
        if (entry == first) {
            first.next.prev = null;
            first = first.next;
            return;
        }
        if (entry == last) {
            last.prev.next = null;
            last = last.prev;
            return;
        }
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
    }

    @Override
    public E getFirst() {
        validateSize();
        return first.item;
    }

    @Override
    public E getLast() {
        validateSize();
        return last.item;
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
        Entry<E> prev;
        Entry<E> next;

        Entry(E item) {
            this.item = item;
        }
    }
}
