package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pyatkinmv.puzzles.lists.ListReverser.reverse;

public class ListReverserTest {
    @Test
    public void reverseTest() {
        DummyLinkedList<String> expected = new DummyLinkedList<>("five", "four", "three", "two", "one");
        DummyLinkedList<String> actual = reverse(new DummyLinkedList<>("one", "two", "three", "four", "five"));
        assertEquals(expected, actual);
        assertEquals(new DummyLinkedList<>(), reverse(new DummyLinkedList<>()));
    }
}