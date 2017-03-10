package me.dakbutfly.sort;

public class InsertSort {
    final CompareThenDo compareThenSwap;

    public InsertSort(CompareThenDo compareThenDo) {
        this.compareThenSwap = compareThenDo;
    }

    public void insertSort(int[] mixedIntArr) {
        int lastIdx = mixedIntArr.length;
        for (int i = 1; i < lastIdx; i++) {
            insertSort(mixedIntArr, i);
        }
    }

    public void insertSort(int[] sortedUntilIdxFour, int lastIdx) {
        for (int index = lastIdx; index > 0; index--) {
            compareThenSwap.compareThenSwap(sortedUntilIdxFour, index);
        }
    }
}