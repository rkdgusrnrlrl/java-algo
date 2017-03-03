package me.dakbutfly.tree;

/**
 * Created by rkdgusrnrlrl on 17. 2. 25.
 */
public class MtreeNode<T> {
    private T value;
    private MtreeNode<T> left;
    private MtreeNode<T> right;


    public MtreeNode(T value) {
        this.value = value;
    }

    public void putLeft(MtreeNode<T> leftNode) {
        this.left = leftNode;
    }

    public void putRight(MtreeNode<T> rightNode) {
        this.right = rightNode;
    }

    public MtreeNode<T> getLeft() {
        return this.left;
    }

    public MtreeNode<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }
}
