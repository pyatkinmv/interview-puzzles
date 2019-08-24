package ru.pyatkinmv.puzzles.lists;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static ru.pyatkinmv.puzzles.lists.Utils.addAll;

public class KthToLastElementGetterTest {
    private KthToLastElementGetter<String> getter;
    private DummyLinkedList<String> list;
    private DummyLinkedList<String> emptyList;
    private DummyLinkedList<String> listWithOneElem;

    @Before
    public void setUp() {
        getter = new KthToLastElementGetter<>();

        list = new DummyLinkedList<>();
        addAll(list, asList("one", "two", "three", "four", "five"));

        emptyList = new DummyLinkedList<>();

        listWithOneElem = new DummyLinkedList<>();
        listWithOneElem.addLast("one");
    }

    @Test
    public void getTest() {
        assertEquals("five", getter.get(1, list));
        assertEquals("four", getter.get(2, list));
        assertEquals("three", getter.get(3, list));
        assertEquals("two", getter.get(4, list));
        assertEquals("one", getter.get(5, list));
        assertEquals("one", getter.get(1, listWithOneElem));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFromEmptyTest() {
        getter.get(1, emptyList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getExceedSizeTest() {
        getter.get(2, listWithOneElem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIncorrectIndexTest() {
        getter.get(0, listWithOneElem);
    }

    @Test
    public void getRecursiveTest() {
        assertEquals("five", getter.getRecursive(1, list));
        assertEquals("four", getter.getRecursive(2, list));
        assertEquals("three", getter.getRecursive(3, list));
        assertEquals("two", getter.getRecursive(4, list));
        assertEquals("one", getter.getRecursive(5, list));
        assertEquals("one", getter.getRecursive(1, listWithOneElem));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRecursiveFromEmptyTest() {
        getter.getRecursive(1, emptyList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRecursiveExceedSizeTest() {
        getter.getRecursive(2, listWithOneElem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRecursiveIncorrectIndexTest() {
        getter.getRecursive(0, listWithOneElem);
    }

    @Test
    public void getIterativeTest() {
        assertEquals("five", getter.getIterative(1, list));
        assertEquals("four", getter.getIterative(2, list));
        assertEquals("three", getter.getIterative(3, list));
        assertEquals("two", getter.getIterative(4, list));
        assertEquals("one", getter.getIterative(5, list));
        assertEquals("one", getter.getIterative(1, listWithOneElem));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIterativeFromEmptyTest() {
        getter.getIterative(1, emptyList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIterativeExceedSizeTest() {
        getter.getIterative(2, listWithOneElem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIterativeIncorrectIndexTest() {
        getter.getIterative(0, listWithOneElem);
    }
}