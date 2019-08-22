package ru.pyatkinmv.puzzles.lists.impl;

import org.junit.Test;

public class SinglyLinkedListTest extends LinkedListTest<SinglyLinkedList<String>> {
    @Override
    SinglyLinkedList<String> buildEmptyList() {
        return new SinglyLinkedList<>();
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