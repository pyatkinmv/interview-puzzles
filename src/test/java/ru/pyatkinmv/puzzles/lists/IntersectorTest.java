package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;
import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import java.util.Optional;

import static org.junit.Assert.*;

public class IntersectorTest {
    @Test
    public void intersectWithDifferentSizeTest() {
        DummyLinkedList<Integer> list1 = new DummyLinkedList<>(1);
        DummyLinkedList<Integer> list2 = new DummyLinkedList<>(2, 4);
        DummyLinkedList<Integer> intersection = new DummyLinkedList<>(5, 6, 7);
        list1.first.next = intersection.first;
        list2.first.next.next = intersection.first;
        Optional<Entry<Integer>> firstEqual = new Intersector<>(list1, list2).intersect();
        assertTrue(firstEqual.isPresent());
        assertEquals(intersection.first, firstEqual.get());
    }

    @Test
    public void intersectWithSameSizeTest() {
        DummyLinkedList<Integer> list1 = new DummyLinkedList<>(1);
        DummyLinkedList<Integer> list2 = new DummyLinkedList<>(2);
        DummyLinkedList<Integer> intersection = new DummyLinkedList<>(5, 6, 7);
        list1.first.next = intersection.first;
        list2.first.next = intersection.first;
        Optional<Entry<Integer>> firstEqual = new Intersector<>(list1, list2).intersect();
        assertTrue(firstEqual.isPresent());
        assertEquals(intersection.first, firstEqual.get());
    }

    @Test
    public void intersectSameTest() {
        DummyLinkedList<Integer> list1 = new DummyLinkedList<>(1, 2, 3, 4, 5);
        Optional<Entry<Integer>> firstEqual = new Intersector<>(list1, list1).intersect();
        assertTrue(firstEqual.isPresent());
        assertEquals(list1.first, firstEqual.get());
    }

    @Test
    public void intersectEmptyTest() {
        DummyLinkedList<Integer> list1 = new DummyLinkedList<>(1, 2, 3, 4, 5);
        Optional<Entry<Integer>> firstEqual = new Intersector<>(list1, new DummyLinkedList<>()).intersect();
        assertFalse(firstEqual.isPresent());
        firstEqual = new Intersector<Integer>(new DummyLinkedList<>(), new DummyLinkedList<>()).intersect();
        assertFalse(firstEqual.isPresent());
    }

    @Test
    public void intersectSameContentTest() {
        DummyLinkedList<Integer> list1 = new DummyLinkedList<>(1, 2, 3, 4, 5);
        DummyLinkedList<Integer> list2 = new DummyLinkedList<>(1, 2, 3, 4, 5);
        Optional<Entry<Integer>> firstEqual = new Intersector<>(list1, list2).intersect();
        assertFalse(firstEqual.isPresent());
    }
}