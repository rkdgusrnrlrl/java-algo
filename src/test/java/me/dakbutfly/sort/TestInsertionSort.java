package me.dakbutfly.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by rkdgusrnrlrl on 17. 3. 6.
 */
public class TestInsertionSort {
    private final CompareThenDo compareThenSwap = new CompareThenSwap();
    private final InsertSort insertSort = new InsertSort(compareThenSwap);
    // 인덱스 0 값과 인덱스 1 값을 비교함
    // 값이 작은 값은 0 인덱스로 보냄
    // 0 ~ 1 까지는 정렬됨
    // 인덱스 2 값을 정렬된 0 ~ 1 사이중 어디에 들어갈지 비교함
    // 해당 인덱스에 값을 삽입

    //배열을 사용하는 경우
    // 비교하는 로직
    // 비교값보다 작은역우 스왑 아니면 멈추기


    @Test
    public void int배열정열하기() throws Exception {
        int[] mixedIntArr = {5, 3, 2, 6, 9,  4, 7, 1};
        insertSort.insertSort(mixedIntArr);
        for (int i = 1; i <mixedIntArr.length; i++) {
            assertThat(mixedIntArr[i], greaterThan(mixedIntArr[i-1]));
        }
    }

    @Test
    public void 마지막값이_들어갈_위치에_넣어주기() throws Exception {
        int[] sortedUntilIdxFour = {2, 3, 5, 6, 7,  4, 9, 1};
        int lastIdx = 5;
        insertSort.insertSort(sortedUntilIdxFour, lastIdx);
        assertThat(sortedUntilIdxFour[2], is(4));
    }

    @Test
    public void 이전값과_비교해서_크거나_같은경우_스왑하지_않음() throws Exception {
        int[] ints = {2, 3};
        compareThenSwap.compareThenSwap(ints, 1);
        assertThat(ints[0], is(2));
        assertThat(ints[1], is(3));
    }

    @Test
    public void 이전값과_비교해서_크거나_같은경우_스왑함() throws Exception {
        int[] ints = {3, 2};
        compareThenSwap.compareThenSwap(ints, 1);
        assertThat(ints[0], is(2));
        assertThat(ints[1], is(3));
    }
    
}
