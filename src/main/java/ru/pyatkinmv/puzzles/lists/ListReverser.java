package ru.pyatkinmv.puzzles.lists;

public class ListReverser {
    public static <E> DummyLinkedList<E> reverse(DummyLinkedList<E> list) {
        DummyLinkedList.Entry<E> prev = null;
        DummyLinkedList.Entry<E> current = list.first;
        DummyLinkedList.Entry<E> next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.first = prev;
        return list;
    }
}
