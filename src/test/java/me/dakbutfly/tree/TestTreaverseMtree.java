package me.dakbutfly.tree;

import me.dakbutfly.queue.Mqueue;
import me.dakbutfly.queue.MqueueOverFlowException;
import me.dakbutfly.queue.MqueueUnderFlowException;
import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by rkdgusrnrlrl on 17. 3. 3.
 */
public class TestTreaverseMtree {
    // 루트 노드 를 큐애 넣기
    // 큐에서 노드를 꺼내고, 그 노드의 left와 right를 큐에 넣어줌
    // 꺼낸 노드의 left와 right 가 null 인 경우 큐에 넣지 않음
    // 꺼낸 노드가 null 일 경우 큐에 넣지 않음
    // 큐가 다 빌어있을 때까지 계속 꺼냄


    @Test
    public void 루트_노드를_큐에_녛기() throws Exception {
        //given
        MtreeNode<Integer> rootFive = new MtreeNode<Integer>(new Integer(5));
        MtreeNode<Integer> one = new MtreeNode<>(1);
        MtreeNode<Integer> two = new MtreeNode<>(2);
        MtreeNode<Integer> tree = new MtreeNode<>(3);
        MtreeNode<Integer> four = new MtreeNode<>(4);
        MtreeNode<Integer> six = new MtreeNode<>(6);
        MtreeNode<Integer> seven = new MtreeNode<>(7);
        MtreeNode<Integer> eight = new MtreeNode<>(8);
        MtreeNode<Integer> nine = new MtreeNode<>(9);

        rootFive.putLeft(four);
        rootFive.putRight(seven);

        Mqueue<MtreeNode> nodeMqueue = new Mqueue<>(10);

        //when
        putTreeNodeInQueue(nodeMqueue, rootFive);

        //then
        MtreeNode<Integer> integerMtreeNode = nodeMqueue.get();
        assertThat(integerMtreeNode, CoreMatchers.is(rootFive));
        assertThat(integerMtreeNode.getLeft(), CoreMatchers.is(rootFive.getLeft()));
        assertThat(integerMtreeNode.getRight(), CoreMatchers.is(rootFive.getRight()));
    }

    @Test
    public void 큐에서_노드를_꺼내고_그_노드의_left와_right를_큐에_넣어줌() throws Exception {
        //given
        MtreeNode<Integer> rootFive = new MtreeNode<Integer>(new Integer(5));
        MtreeNode<Integer> one = new MtreeNode<>(1);
        MtreeNode<Integer> two = new MtreeNode<>(2);
        MtreeNode<Integer> tree = new MtreeNode<>(3);
        MtreeNode<Integer> four = new MtreeNode<>(4);
        MtreeNode<Integer> six = new MtreeNode<>(6);
        MtreeNode<Integer> seven = new MtreeNode<>(7);
        MtreeNode<Integer> eight = new MtreeNode<>(8);
        MtreeNode<Integer> nine = new MtreeNode<>(9);

        rootFive.putLeft(four);
        rootFive.putRight(seven);

        Mqueue<MtreeNode> nodeMqueue = new Mqueue<>(10);

        //when
        putTreeNodeInQueue(nodeMqueue, rootFive);

        //then
        MtreeNode<Integer> integerMtreeNode = nodeMqueue.get();
        assertThat(integerMtreeNode, CoreMatchers.is(rootFive));
        MtreeNode secNode = nodeMqueue.get();
        assertThat(secNode, CoreMatchers.is(rootFive.getLeft()));
        MtreeNode thirdNode = nodeMqueue.get();
        assertThat(thirdNode, CoreMatchers.is(rootFive.getRight()));
    }

    @Test
    public void 꺼낸_노드의_left와_right_가_null_인_경우_큐에_넣지_않음() throws Exception {
        //given
        MtreeNode<Integer> rootFive = new MtreeNode<Integer>(new Integer(5));
        MtreeNode<Integer> one = new MtreeNode<>(1);
        MtreeNode<Integer> two = new MtreeNode<>(2);
        MtreeNode<Integer> tree = new MtreeNode<>(3);
        MtreeNode<Integer> four = new MtreeNode<>(4);
        MtreeNode<Integer> six = new MtreeNode<>(6);
        MtreeNode<Integer> seven = new MtreeNode<>(7);
        MtreeNode<Integer> eight = new MtreeNode<>(8);
        MtreeNode<Integer> nine = new MtreeNode<>(9);

        Mqueue<MtreeNode> nodeMqueue = new Mqueue<>(10);

        //when
        putTreeNodeInQueue(nodeMqueue, rootFive);

        //then
        MtreeNode<Integer> integerMtreeNode = nodeMqueue.get();
        assertThat(integerMtreeNode, CoreMatchers.is(rootFive));

        try {
            MtreeNode secNode = nodeMqueue.get();
            fail("nodeMqueue.get() should be return null");
        } catch (MqueueUnderFlowException e) {

        }

    }

    @Test
    public void 꺼낸_노드가_null_일_경우_큐에_넣지_않음() throws Exception {
        //given
        MtreeNode<Integer> rootFive = null;

        Mqueue<MtreeNode> nodeMqueue = new Mqueue<>(10);

        //when
        putTreeNodeInQueue(nodeMqueue, rootFive);

        //then
        try {
            MtreeNode secNode = nodeMqueue.get();
            fail("nodeMqueue.get() should be return null");
        } catch (MqueueUnderFlowException e) {

        }

    }

    @Test
    public void 큐를_사용한_탐색로직() throws Exception {
        //given
        MtreeNode<Integer> rootFive = new MtreeNode<Integer>(new Integer(5));
        MtreeNode<Integer> one = new MtreeNode<>(1);
        MtreeNode<Integer> two = new MtreeNode<>(2);
        MtreeNode<Integer> tree = new MtreeNode<>(3);
        MtreeNode<Integer> four = new MtreeNode<>(4);
        MtreeNode<Integer> six = new MtreeNode<>(6);
        MtreeNode<Integer> seven = new MtreeNode<>(7);
        MtreeNode<Integer> eight = new MtreeNode<>(8);
        MtreeNode<Integer> nine = new MtreeNode<>(9);


        rootFive.putLeft(four);
        rootFive.getLeft().putLeft(two);
        rootFive.getLeft().getLeft().putLeft(one);
        rootFive.getLeft().getLeft().putRight(tree);

        rootFive.putRight(seven);
        rootFive.getRight().putLeft(six);
        rootFive.getRight().putRight(nine);
        rootFive.getRight().getRight().putLeft(eight);

        //when
        List<MtreeNode> path = levelorderTraverse(rootFive);
        
    }

    private List<MtreeNode> levelorderTraverse(MtreeNode<Integer> rootFive) throws MqueueOverFlowException {
        List<MtreeNode> mtreeNodes = new ArrayList<>();
        Mqueue<MtreeNode> nodeMqueue = new Mqueue<>(10);
        nodeMqueue.put(rootFive);
            try {
                while (true) {
                    MtreeNode mtreeNode = nodeMqueue.get();
                    putTreeNodeInQueue(nodeMqueue, mtreeNode);
                    mtreeNodes.add(mtreeNode);
                }
            } catch (MqueueUnderFlowException e) {
                e.printStackTrace();
            }


        return mtreeNodes;
    }

    @Test
    public void 계층별_탐색하는_메서드_작성() throws Exception {
        //given
        MtreeNode<Integer> rootFive = new MtreeNode<Integer>(new Integer(5));
        MtreeNode<Integer> one = new MtreeNode<>(1);
        MtreeNode<Integer> two = new MtreeNode<>(2);
        MtreeNode<Integer> tree = new MtreeNode<>(3);
        MtreeNode<Integer> four = new MtreeNode<>(4);
        MtreeNode<Integer> six = new MtreeNode<>(6);
        MtreeNode<Integer> seven = new MtreeNode<>(7);
        MtreeNode<Integer> eight = new MtreeNode<>(8);
        MtreeNode<Integer> nine = new MtreeNode<>(9);


        rootFive.putLeft(four);
        rootFive.getLeft().putLeft(two);
        rootFive.getLeft().getLeft().putLeft(one);
        rootFive.getLeft().getLeft().putRight(tree);

        rootFive.putRight(seven);
        rootFive.getRight().putLeft(six);
        rootFive.getRight().putRight(nine);
        rootFive.getRight().getRight().putLeft(eight);

        //when

        List<MtreeNode> result = levelorderTraverse(rootFive);

        //then

        List<MtreeNode> expect = new ArrayList<>();
        expect.add(rootFive);
        expect.add(four);
        expect.add(seven);
        expect.add(two);
        expect.add(six);
        expect.add(nine);
        expect.add(one);
        expect.add(tree);
        expect.add(eight);

        assertNotNull(result);
        assertThat(result.size(), is(expect.size()));
        for (int i = 0; i < expect.size(); i++) {
            assertThat(result.get(i), CoreMatchers.is(expect.get(i)));
        }

    }

    private List<MtreeNode> putTreeNodeInQueue(Mqueue<MtreeNode> mqueue, MtreeNode five) throws MqueueOverFlowException {
        if (five != null) {

            MtreeNode left = five.getLeft();
            if (left != null) {
                mqueue.put(left);
            }
            MtreeNode right = five.getRight();
            if (right != null) {
                mqueue.put(right);
            }
        }
        return new ArrayList<>();
    }

}
