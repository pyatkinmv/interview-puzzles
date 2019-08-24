package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.lists.PalindromChecker.isPalindrom;

public class PalindromCheckerTest {
    @Test
    public void isPalindromTest() {
        assertTrue(isPalindrom(new DummyLinkedList<>()));
        assertTrue(isPalindrom(new DummyLinkedList<>(1)));
        assertTrue(isPalindrom(new DummyLinkedList<>(1, 2, 1)));
        assertTrue(isPalindrom(new DummyLinkedList<>(1, 2, 2, 1)));
        assertTrue(isPalindrom(new DummyLinkedList<>(1, 2, 3, 2, 1)));
        assertTrue(isPalindrom(new DummyLinkedList<>(1, 2, 3, 4, 4, 3, 2, 1)));

        assertFalse(isPalindrom(new DummyLinkedList<>(1, 2)));
        assertFalse(isPalindrom(new DummyLinkedList<>(1, 2, 3)));
        assertFalse(isPalindrom(new DummyLinkedList<>(1, 2, 3, 2, 1, 1)));
    }

}