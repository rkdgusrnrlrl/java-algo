package me.dakbutfly.sort;

public class CompareThenSwap implements CompareThenDo{
    public CompareThenSwap() {
    }

    public void compareThenSwap(int[] ints, int lastIdx) {
        if (ints[lastIdx - 1] > ints[lastIdx]) {
            int tmep = ints[lastIdx];
            ints[lastIdx] = ints[lastIdx - 1];
            ints[lastIdx - 1] = tmep;
        }
    }
}