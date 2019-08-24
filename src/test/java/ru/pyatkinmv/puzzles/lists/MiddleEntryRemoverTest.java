package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static ru.pyatkinmv.puzzles.lists.MiddleEntryRemover.remove;
import static ru.pyatkinmv.puzzles.lists.Utils.addAll;
import static ru.pyatkinmv.puzzles.lists.Utils.toArray;

public class MiddleEntryRemoverTest {
    @Test
    public void removeTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        addAll(list, asList("one", "two", "three", "four", "five"));
        remove(list.first.next.next);
        assertArrayEquals(new String[]{"one", "two", "four", "five"}, toArray(list));
        remove(list.first.next);
        assertArrayEquals(new String[]{"one", "four", "five"}, toArray(list));
        remove(list.first);
        assertArrayEquals(new String[]{"four", "five"}, toArray(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeLastTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        list.addLast("one");
        remove(list.first);
    }
}