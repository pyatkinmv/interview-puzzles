package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;
import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import static org.junit.Assert.*;
import static ru.pyatkinmv.puzzles.lists.Utils.*;

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

    @Test
    public void nullOrNextTest() {
        assertNull(nullOrNext(new Entry<>(2)));
        assertEquals(new Entry<>(2).item, nullOrNext(new DummyLinkedList<>(1, 2).first).item);
    }

    @Test
    public void getSizeTest() {
        assertEquals(0, getSize(new DummyLinkedList<>()));
        assertEquals(1, getSize(new DummyLinkedList<>(1)));
        assertEquals(7, getSize(new DummyLinkedList<>(1, 2, 3, 4, 5, 6, 7)));
    }
}