package ru.pyatkinmv.puzzles.lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.lists.LoopDetector.detect;

public class LoopDetectorTest {
    private DummyLinkedList<Integer> loop;

    @Before
    public void setUp() {
        loop = new DummyLinkedList<>(5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        loop.getLastEntry().next = loop.first;
    }

    @Test
    public void detectTest() {
        DummyLinkedList<Integer> list = new DummyLinkedList<>(1, 2, 3, 4);
        list.getLastEntry().next = loop.first;
        Optional<Entry<Integer>> loopFirstEntry = detect(list);
        assertTrue(loopFirstEntry.isPresent());
        Assert.assertEquals(loop.first, loopFirstEntry.get());
    }

    @Test
    public void detectInLoopTest() {
        Optional<Entry<Integer>> loopFirstEntry = detect(loop);
        assertTrue(loopFirstEntry.isPresent());
        Assert.assertEquals(loop.first, loopFirstEntry.get());
    }

    @Test
    public void detectNoLoopTest() {
        assertFalse(detect(new DummyLinkedList<>(1, 2, 3, 4, 5)).isPresent());
        assertFalse(detect(new DummyLinkedList<>()).isPresent());
    }

    @Test
    public void detectDoubleElemLoop() {
        Entry<Integer> first = new Entry<>(1);
        Entry<Integer> second = new Entry<>(2);
        first.next = second;
        second.next = first;
        DummyLinkedList<Integer> list = new DummyLinkedList<>();
        list.first = first;
        Optional<Entry<Integer>> loopFirstEntry = detect(list);
        assertTrue(loopFirstEntry.isPresent());
        Assert.assertEquals(first, loopFirstEntry.get());
    }


}