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
        DummyLinkedList<String> list = new DummyLinkedList<>("one", "two", "third");
        assertTrue(list.remove("two"));
        assertFalse(list.remove("two"));
        assertEquals("one", list.first.item);
        assertEquals("third", list.first.next.item);
        assertTrue(list.remove("one"));
        assertEquals("third", list.first.item);
        assertTrue(list.remove("third"));
        assertTrue(list.isEmpty());
    }

    @Test
    public void equalsTest() {
        DummyLinkedList<String> list1 = new DummyLinkedList<>("one", "two", "three");
        assertEquals(list1, list1);

        DummyLinkedList<String> list2 = new DummyLinkedList<>("one", "two", "three");
        assertEquals(list1, list2);

        DummyLinkedList<String> list3 = new DummyLinkedList<>("one", "two", "three", "four");
        assertNotEquals(list1, list3);

        DummyLinkedList<Integer> list4 = new DummyLinkedList<>(1, 2, 3, 4);
        assertNotEquals(list3, list4);

        assertNotEquals(null, list1);
        assertNotEquals(list1, null);
    }
}