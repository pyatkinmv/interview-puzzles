package ru.pyatkinmv.puzzles.lists.impl;

public class SinglyLinkedListTest extends LinkedListTest<SinglyLinkedList<String>> {
    @Override
    SinglyLinkedList<String> buildEmptyList() {
        return new SinglyLinkedList<>();
    }
}