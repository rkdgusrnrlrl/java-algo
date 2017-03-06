package me.dakbutfly.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rkdgusrnrlrl on 17. 3. 6.
 */
public class TestSelectSort {

    private final String string = "TOLEARNSORTALGORITHM";

    @Test
    public void 문자열이_알파벳으로_정렬됨() throws Exception {
        String result = selectSort(string);
        String expect = "AAEGHILLMNOOORRRSTTT";
        assertThat(result, is(expect));
    }
    
    // i 에서 n - 1 중에 가장 작은 값을 i와 교
    // i + 1 에서 n - 1 중에 가장 작은 값을 i + 1 교환
    // ...
    
    // 배열에서 가장 작은 값을 가장 작은 값의 인덱스를 알아넴
    //
    // 값 교환


    @Test
    public void 배열에서_가장_작은_값의_인덱스를_알아넴() throws Exception {
        char[] chars = string.toCharArray();
        int index = findIndexOfMin(chars, 0, chars.length);
        int expect = 4;
        assertThat(index, is(expect));
    }

    @Test
    public void 배열에서_시작점을_중간에두고_가장_작은_값의_인덱스를_알아넴() throws Exception {
        char[] chars = string.toCharArray();

        int index = findIndexOfMin(chars, 12, chars.length);
        int expect = 13;
        assertThat(index, is(expect));
    }
    @Test
    public void 가장작은값이_같은값인경우_기존_인덱스를_유지() throws Exception {

        char[] chars = {'A', 'D', 'B', 'A', 'C'};
        int index = findIndexOfMin(chars, 0, chars.length);
        int expect = 0;
        assertThat(index, is(expect));
    }





    @Test
    public void 값_교환() throws Exception {
        char[] chars = string.toCharArray();
        swarp(chars, 0, 4);
        assertThat(chars[0], is('A'));
    }

    private void swarp(char[] chars, int from, int to) {
        char beforeFromVal = chars[from];
        chars[from] = chars[to];
        chars[to] = beforeFromVal;
    }

    private int findIndexOfMin(char[] chars, int from, int to) {
        char min = chars[from];
        int ind = from;
        for (int i = from; i < to; i++) {
            if (min > chars[i]) {
                min = chars[i];
                ind = i;
            }
        }
        return ind;
    }

    private String selectSort(String string) {

        char[] chars = string.toCharArray();
        for (int currentIdx = 0; currentIdx < chars.length; currentIdx++) {
            int indexOfMin = findIndexOfMin(chars, currentIdx, chars.length);
            swarp(chars, currentIdx, indexOfMin);
        }
        return new String(chars);
    }
}
