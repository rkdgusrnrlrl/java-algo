package me.dakbutfly.queue;

/**
 * Created by rkdgusrnrlrl on 17. 3. 3.
 */
public class Mqueue<T> {
    Object[] store;
    final int SIZE;
    int rear;
    int front;

    public Mqueue(int i) {
        SIZE = i + 1;
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
