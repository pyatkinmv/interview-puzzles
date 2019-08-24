package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static ru.pyatkinmv.puzzles.lists.Utils.toArray;

public class UtilsTest {
    @Test
    public void toIntArrayTest() {
        DummyLinkedList<Integer> ints = new DummyLinkedList<>(3, 5, 8);
        assertArrayEquals(new Integer[]{3, 5, 8}, toArray(ints));
    }

    @Test
    public void toStringArrayTest() {
        DummyLinkedList<String> strings = new DummyLinkedList<>("one", "two", "three");
        assertArrayEquals(new String[]{"one", "two", "three"}, toArray(strings));
    }

    @Test
    public void toEmptyArrayTest() {
        DummyLinkedList<Object> list = new DummyLinkedList<>();
        assertArrayEquals(new Object[0], toArray(list));
    }
}