package ru.pyatkinmv.puzzles.lists.impl;

public class DoublyLinkedListTest extends LinkedListTest<DoublyLinkedList<String>> {
    @Override
    DoublyLinkedList<String> buildEmptyList() {
        return new DoublyLinkedList<>();
    }
}