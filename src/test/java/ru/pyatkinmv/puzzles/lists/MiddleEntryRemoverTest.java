package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;
import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static ru.pyatkinmv.puzzles.lists.MiddleEntryRemover.remove;

public class MiddleEntryRemoverTest {
    @Test
    public void removeTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        list.addLast("four");
        list.addLast("five");
        remove(list.first.next.next);
        assertArrayEquals(new String[]{"one", "two", "four", "five"}, toArray(list));
        remove(list.first.next);
        assertArrayEquals(new String[]{"one", "four", "five"}, toArray(list));
        remove(list.first);
        assertArrayEquals(new String[]{"four", "five"}, toArray(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeLastTest() {
        DummyLinkedList<String> list = new DummyLinkedList<>();
        list.addLast("one");
        remove(list.first);
    }

    @SuppressWarnings("unchecked")
    private <E> E[] toArray(DummyLinkedList<E> list) {
        List<E> arrayList = new ArrayList<>();
        for (Entry<E> entry = list.first; entry != null; entry = entry.next) {
            arrayList.add(entry.item);
        }
        return (E[]) arrayList.toArray();
    }
}