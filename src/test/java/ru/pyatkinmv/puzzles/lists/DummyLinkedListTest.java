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
        assertEquals("one", list.getFirst().item);
        assertEquals("two", list.getFirst().next.item);
        assertEquals("third", list.getFirst().next.next.item);
    }

    @Test
    public void removeTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        list.addLast("one");
        list.addLast("two");
        list.addLast("third");
        assertTrue(list.remove("two"));
        assertFalse(list.remove("two"));
        assertEquals("one", list.getFirst().item);
        assertEquals("third", list.getFirst().next.item);
        assertTrue(list.remove("one"));
        assertEquals("third", list.getFirst().item);
        assertTrue(list.remove("third"));
        assertTrue(list.isEmpty());
    }
}