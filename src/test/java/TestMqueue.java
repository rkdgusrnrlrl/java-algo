import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by rkdgusrnrlrl on 17. 2. 24.
 */
public class TestMqueue {
    /*
    * 환 형태의 큐front = (front + 1) % SIZE;
    * 1. 배열 형태
    *   처음과 끝이 따로 있지 않고 원처럼 계속 돌아가는 구조. 예를 들어 길이가 10인 배열이라면  9 다음은 10이 아니라 0이 됨
    *   queue 의 시작 인덱스를 알려주는 front 와 마지막을 알려주는(배열의 끝이 아니라) rear 이 있어야함
    *   값을 넣는 메서드로 put, 값을 꺼내는 메서드로 get 이 있어야 한다.
    *   이로 인해 한칸은 비워 둬야 하는데 초기에 값이 없을 때는 front 와 rear 가 같아야 하지만, 값이 가득 찬 경우 rear 가 front 앞에 있어야 하는데
    *   해당 칸은 비워두어야 한다.
    *    
    *    테스트 내용
    *   - 생성자로 사이즈를 할당하고 그 사이즈 만큰 값을 체울 수 있음 넘치는 경우 MqueueOverFlow Exception
    *   - 값이 비어 있는 경우 MqueueUnderFlow Exception, 값이 가득 찬경우 QueueOverFlow Exception
    *   - 배열 이상으로 put 해보기(get 한번 이상 필수)
    *   - 넣은 순서대로 값이 나와야 함
    * */

    @Test
    public void 생성자로_사이즈를_할당하고_그_사이즈_만큰_값을_체울_수_있음_넘치는_경우_MqueueOverFlow_Exception() throws Exception {
        Mqueue<Integer> integerMqueue = new Mqueue<>(3);
        integerMqueue.put(3);
        integerMqueue.put(3);
        integerMqueue.put(3);
        try {
            integerMqueue.put(3);
            fail();
        } catch (MqueueOverFlowException e) {

        }
    }

    @Test
    public void 값이_비어_있는_경우_QueueUnderFlow_Exception_값이_가득_찬경우_QueueOverFlow_Exception() throws Exception {
        Mqueue<Integer> mqueue = new Mqueue<Integer>(10);
        try {
            Integer i = mqueue.get();
            fail();
        } catch (MqueueUnderFlowException e) {

        }
    }

    @Test
    public void 값이_가득_찬경우_QueueOverFlow_Exception() throws Exception {
        Mqueue<Integer> integerMqueue = new Mqueue<>(3);
        integerMqueue.put(3);
        integerMqueue.put(3);
        integerMqueue.put(3);
        integerMqueue.get();
        integerMqueue.put(3);
        try {
            integerMqueue.put(3);
            fail();
        } catch (MqueueOverFlowException e) {

        }
    }

    @Test
    public void 넣은_순서대로_값이_나와야_함() throws Exception {
        Mqueue<Integer> integerMqueue = new Mqueue<>(3);
        integerMqueue.put(1);
        integerMqueue.put(2);
        integerMqueue.put(3);
        assertThat(integerMqueue.get(), is(1));
        assertThat(integerMqueue.get(), is(2));
        assertThat(integerMqueue.get(), is(3));

    }

    @Test
    public void get_put_연속으로_사이즈_이상_해도_Exception이_나지_않음() throws Exception {
        Mqueue<Integer> integerMqueue = new Mqueue<>(3);
        integerMqueue.put(1);
        assertThat(integerMqueue.get(), is(1));
        integerMqueue.put(2);
        assertThat(integerMqueue.get(), is(2));
        integerMqueue.put(3);
        assertThat(integerMqueue.get(), is(3));
        integerMqueue.put(4);
        assertThat(integerMqueue.get(), is(4));
        integerMqueue.put(5);
        assertThat(integerMqueue.get(), is(5));
    }

    /*
    리스트 사이즈 제한 해도 계속 add 하면 사이즈가 늘어난다.
    @Test
    public void 리스트_사이즈_제한() throws Exception {
        ArrayList<Integer> integers = new ArrayList<>(10);
        for (int i = 0; i < 15; i++) {
            integers.add(i);
        }
    }*/

    private class Mqueue<T> {
        Object[] store;
        final int SIZE;
        int rear;
        int front;

        public Mqueue(int i) {
            SIZE = i+1;
            front = 0;
            rear = 0;
            store = new Object[SIZE];
        }

        public T get() throws MqueueUnderFlowException {
            if (front == rear) {
                throw new MqueueUnderFlowException();
            } else {
                T returnVal = (T) store[front];
                front = (front + 1) % SIZE;
                return returnVal;
            }
        }

        public void put(T i) throws MqueueOverFlowException {
            int next = (rear + 1) % SIZE;
            if (next != front) {
                store[rear] = i;
                rear = next;
            } else {
                throw new MqueueOverFlowException();
            }
        }
    }

    private class MqueueUnderFlowException extends Exception {
    }

    private class MqueueOverFlowException extends Exception {
    }
}
