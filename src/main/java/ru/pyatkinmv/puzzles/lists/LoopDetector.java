package ru.pyatkinmv.puzzles.lists;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

public class LoopDetector {
    public static <E> Optional<Entry<E>> detect(DummyLinkedList<E> list) {
        Entry<E> slow = list.first;
        Entry<E> fast = list.first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return empty();
        }
        slow = list.first;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return of(slow);
    }
}
