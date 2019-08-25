package ru.pyatkinmv.puzzles.lists;

import ru.pyatkinmv.puzzles.lists.DummyLinkedList.Entry;

import static java.lang.Math.pow;
import static ru.pyatkinmv.puzzles.lists.Utils.nullOrNext;

public class Number {
    private final DummyLinkedList<Integer> list;

    public Number(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number could not be negative");
        }

        list = new DummyLinkedList<>();
        list.first = number == 0 ? new Entry<>(0) : buildList(number);
    }

    private Number(DummyLinkedList<Integer> list) {
        this.list = list;
    }

    public static Number sum(Number num1, Number num2) {
        DummyLinkedList<Integer> list = new DummyLinkedList<>();
        list.first = sum(num1.list.first, num2.list.first, 0);
        return new Number(list);
    }

    private static Entry<Integer> sum(Entry<Integer> entry1, Entry<Integer> entry2, int remainder) {
        if (entry1 == null && entry2 == null && remainder == 0) {
            return null;
        }
        int value = remainder;
        if (entry1 != null) {
            value += entry1.item;
        }
        if (entry2 != null) {
            value += entry2.item;
        }
        Entry<Integer> result = new Entry<>(value % 10);
        if (entry1 != null || entry2 != null) {
            result.next = sum(nullOrNext(entry1), nullOrNext(entry2), value / 10);
        }
        return result;
    }

    private Entry<Integer> buildList(int number) {
        if (number == 0) {
            return null;
        }
        Entry<Integer> entry = new Entry<>(number % 10);
        entry.next = buildList(number / 10);
        return entry;
    }

    public int toInt() {
        int degree = 0;
        long result = 0;
        Entry<Integer> entry = list.first;
        while (entry != null) {
            result += (long) pow(10, degree) * entry.item;
            ++degree;
            entry = entry.next;
        }

        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow int range");
        }
        return (int) result;
    }
}
