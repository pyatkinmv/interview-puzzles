package ru.pyatkinmv.puzzles.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pyatkinmv.puzzles.lists.Number.sum;

public class NumberTest {
    @Test
    public void sumTest() {
        assertEquals(912, sum(new Number(295), new Number(617)).toInt());
        assertEquals(146, sum(new Number(134), new Number(12)).toInt());
        assertEquals(12345, sum(new Number(12345), new Number(0)).toInt());
        assertEquals(200, sum(new Number(99), new Number(101)).toInt());
        assertEquals(10000, sum(new Number(1), new Number(9999)).toInt());
        assertEquals(1_889_884_777, sum(new Number(989_896_988), new Number(899_987_789)).toInt());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumNegativeTest() {
        new Number(-1);
    }

    @Test
    public void toIntTest() {
        assertEquals(617, new Number(617).toInt());
        assertEquals(295, new Number(295).toInt());
    }

    @Test(expected = ArithmeticException.class)
    public void toIntOverflowTest() {
        sum(new Number(2_147_483_647), new Number(2_147_483_647)).toInt();
    }
}