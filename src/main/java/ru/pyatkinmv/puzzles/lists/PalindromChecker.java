package ru.pyatkinmv.puzzles.lists;


import static ru.pyatkinmv.puzzles.lists.ListReverser.reverse;
import static ru.pyatkinmv.puzzles.lists.Utils.copy;

public class PalindromChecker {
    public static <E> boolean isPalindrom(DummyLinkedList<E> list) {
        DummyLinkedList<E> reversed = reverse(copy(list));
        return list.equals(reversed);
    }
}
