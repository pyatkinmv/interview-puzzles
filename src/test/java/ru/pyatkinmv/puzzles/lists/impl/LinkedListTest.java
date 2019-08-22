package ru.pyatkinmv.puzzles.lists.impl;

import static org.junit.Assert.*;

public abstract class LinkedListTest<L extends LinkedList<String>> {
    abstract L buildEmptyList();

    public void removeTest() {
        L list = buildEmptyList();
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        assertTrue(list.remove("two"));
        assertFalse(list.remove("two"));
        assertEquals(2, list.getSize());
        assertEquals("one", list.getFirst());
        assertEquals("three", list.getLast());
        assertTrue(list.remove("one"));
        assertEquals(1, list.getSize());
        assertEquals("three", list.getFirst());
        assertEquals("three", list.getLast());
        assertTrue(list.remove("three"));
        assertTrue(list.isEmpty());
    }

    public void isEmptyTest() {
        L list = buildEmptyList();
        assertTrue(list.isEmpty());
        list.addFirst("first");
        assertFalse(list.isEmpty());
    }

    public void getSizeTest() {
        L list = buildEmptyList();
        assertEquals(0, list.getSize());
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        assertEquals(3, list.getSize());
        list.removeLast();
        list.removeFirst();
        assertEquals(1, list.getSize());
        list.addLast("three");
        list.addLast("four");
        list.addFirst("one");
        assertEquals(4, list.getSize());
    }

    public void addFirstTest() {
        L list = buildEmptyList();
        list.addFirst("first");
        assertEquals("first", list.getFirst());
        list.addFirst("new first");
        assertEquals("new first", list.getFirst());
    }

    public void addLastTest() {
        L list = buildEmptyList();
        list.addLast("last");
        assertEquals("last", list.getLast());
        list.addLast("new last");
        assertEquals("new last", list.getLast());
    }

    public void removeFirstTest() {
        L list = buildEmptyList();
        list.addFirst("one");
        assertEquals("one", list.removeFirst());
        assertTrue(list.isEmpty());
        list.addFirst("two");
        list.addFirst("new one");
        assertEquals("new one", list.removeFirst());
        assertEquals(1, list.getSize());
    }

    public void removeLastTest() {
        L list = buildEmptyList();
        list.addLast("one");
        assertEquals("one", list.removeLast());
        assertTrue(list.isEmpty());
        list.addLast("zero");
        list.addLast("new one");
        assertEquals("new one", list.removeLast());
        assertEquals(1, list.getSize());
    }
}
