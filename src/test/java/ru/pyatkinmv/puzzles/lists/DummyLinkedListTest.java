package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class DummyLinkedListTest {
    @Test
    public void addLastTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        list.addLast("one");
        list.addLast("two");
        list.addLast("third");
        assertEquals("one", list.first.item);
        assertEquals("two", list.first.next.item);
        assertEquals("third", list.first.next.next.item);
    }

    @Test
    public void removeTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        list.addLast("one");
        list.addLast("two");
        list.addLast("third");
        assertTrue(list.remove("two"));
        assertFalse(list.remove("two"));
        assertEquals("one", list.first.item);
        assertEquals("third", list.first.next.item);
        assertTrue(list.remove("one"));
        assertEquals("third", list.first.item);
        assertTrue(list.remove("third"));
        assertTrue(list.isEmpty());
    }
}