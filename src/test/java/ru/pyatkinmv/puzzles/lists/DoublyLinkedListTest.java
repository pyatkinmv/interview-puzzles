package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

public class DoublyLinkedListTest extends LinkedListTest<DoublyLinkedList<String>> {
    @Override
    DoublyLinkedList<String> buildEmptyList() {
        return new DoublyLinkedList<>();
    }

    @Test
    public void removeTest() {
        super.removeTest();
    }

    @Test
    public void isEmptyTest() {
        super.isEmptyTest();
    }

    @Test
    public void getSizeTest() {
        super.getSizeTest();
    }

    @Test
    public void addFirstTest() {
        super.addFirstTest();
    }

    @Test
    public void addLastTest() {
        super.addLastTest();
    }

    @Test
    public void removeFirstTest() {
        super.removeFirstTest();
    }

    @Test
    public void removeLastTest() {
        super.removeLastTest();
    }
}