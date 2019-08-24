package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;
import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import static org.junit.Assert.assertArrayEquals;
import static ru.pyatkinmv.puzzles.lists.DuplicatesRemover.removeDuplicates;

public class DuplicatesRemoverTest {
    @Test
    public void removeDuplicatesTest() {
        DummyLinkedList<Integer> list = new DummyLinkedList<>(1, 2, 1, 3, 2, 4, 3, 4, 3, 2, 4, 5, 3, 5, 1, 6, 6,
                3, 2, 2, 7, 6, 7, 5, 3, 1, 4, 2, 8, 7, 8, 5, 3, 9, 4, 8, 6, 2, 7, 10, 3, 9, 6, 1, 10, 8);
        removeDuplicates(list);

        int[] expected = new int[10];
        for (int i = 1; i <= 10; ++i) {
            expected[i - 1] = i;
        }

        int[] actual = new int[10];
        int i = 0;
        for (Entry<Integer> entry = list.first; entry != null; entry = entry.next) {
            actual[i++] = entry.item;
        }

        assertArrayEquals(expected, actual);
    }
}