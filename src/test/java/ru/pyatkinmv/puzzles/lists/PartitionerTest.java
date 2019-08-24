package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;
import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.lists.Partitioner.partitionBy;

public class PartitionerTest {
    @Test
    public void partitionTest() {
        DummyLinkedList<Integer> list = new DummyLinkedList<>();
        list.addLast(3);
        list.addLast(5);
        list.addLast(8);
        list.addLast(5);
        list.addLast(10);
        list.addLast(2);
        list.addLast(1);
        partitionBy(0, list);
        assertTrue(isPartitionedBy(0, list));
        partitionBy(5, list);
        assertTrue(isPartitionedBy(5, list));
        partitionBy(6, list);
        assertTrue(isPartitionedBy(6, list));
        partitionBy(7, list);
        assertTrue(isPartitionedBy(7, list));
        partitionBy(8, list);
        assertTrue(isPartitionedBy(8, list));
        partitionBy(11, list);
        assertTrue(isPartitionedBy(11, list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void partitionEmptyTest() {
        partitionBy(5, new DummyLinkedList<>());
    }

    private <E extends Comparable<E>> boolean isPartitionedBy(E item, DummyLinkedList<E> list) {
        Entry<E> firstGreater = null;
        for (Entry<E> entry = list.first; entry != null; entry = entry.next) {
            if (firstGreater != null) {
                if (entry.item.compareTo(item) < 0) {
                    return false;
                }
                continue;
            }
            if (entry.item.compareTo(item) > 0) {
                firstGreater = entry;
            }
        }
        return true;
    }
}