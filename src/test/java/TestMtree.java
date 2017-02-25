import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rkdgusrnrlrl on 17. 2. 24.
 */
public class TestMtree {
    /*
    * Tree
    * root 를 가장 위에 두고 가지(link) 밑으로 벌어지고 잎(leaf)가 달려 있다.
    * 나무 구조는 노트와 링크의 집힙이다
    * 노트는 버텍스 라고함, 정보를 담고 있음
    * 링크는 에지라고 함 노드간의 연결을 나타냄
    * 경로는 나무 내에서 링크에 의해 연결된 일련의 노드의 집합임
    * 나무를 링크에 의해 연결된 노드를 통해 이동할 때 이 이동 경로를 path 라고함
    * 나무의 제일 위에 뿌리를 root 라고 함
    * root 노드로 부터 다른 노드에 이르는 경로는 오직 하나 뿐임 이는 그래프 구조와 다른점임
    * 나무 구조에는 오직 아래 방향으로 내려간다.
    * 나무 구조에수 위는 뿌리와 가까워지는 걸 말한다.
    * 부모(parent) 특정 노드의 상위에 노드를 의미
    * 자식(children) 특정 노드의 하위 노드를 의미
    * 조부모(grandparent) 특정 노드의 두단계 위의 노드를 의미
    * 같은 부모를 같는 노드를 형제(sibling) 이라고 함
    * 자식이 없는 노드를 잎(leaf) 노드 또는 종료 노드(terminal node) 또는 외부 노드(external node) 라고 함
    * 자식이 하나라도 있는 노드는 비종료 노드(Nonterminal node) 또는 내부 노드(Internal node) 라고함
    * 큰 나무에 속해 있는 부분 작은 나무(subtree)라고 함
    * 레벨(level)은 root 현재 노드 까지의 경로를 거치는 동안의 노드 수를 의미, 즉 노드가 얼마나 떨어져 있는지를 의미
    * 나무의 높이(height)은 노드중 가장 높은 레벨을 의미
    *
    * */

    /*
    * 나무의 성질
    * 1. Root 에서 다른 노드로 가는 경로는 하나뿐임
    * 2. N개 의 노드는 N-1 개의 링크를 갖음
    * 3. full binary tree 의 경우 N개의 노드를 가진경우 높이는 logN + 1 임 
    * */

    /*
    * MtreeNode 명세
    * 필드
    *   - MtreeNode left 왼쪽 노드
    *   - MtreeNode right 오른쪽 노드
    *   - T value 노드의 값
    *  메서드
    *   - MtreeNode 생성자
    *     - T value : 해당 노드의 값
    *   - putLeft(MtreeNode<T> left) : void => 해당 노드에 left 노드를 할당함
    *   - getLeft() : MtreeNode<T> => 해당 노드에 left 노드 리턴
    *   - putRight(MtreeNode<T> right) : void => 해당 노드에 right 노드를 할당함
    *   - getRight() : MtreeNode<T> => 해당 노드에 right 노드 리턴
    * */


    /*
    *  트리 구조
    *               5
    *           4           7
    *       2           6       9
    *                       8
    *
    * */

    @Test
    public void Mtree에_값을_리턴_할_수_있음() throws Exception {
        MtreeNode<Integer> integerMtreeNode = new MtreeNode<>(5);
        Integer value = integerMtreeNode.getValue();
        assertThat(value, is(5));
    }

    @Test
    public void Mtree에_left와_right_필드_셋하고_확인하기() throws Exception {

        //given
        MtreeNode<Integer> integerMtreeNode = new MtreeNode<>(5);
        MtreeNode<Integer> four = new MtreeNode<>(4);
        MtreeNode<Integer> six = new MtreeNode<>(6);

        //when
        integerMtreeNode.putLeft(four);
        integerMtreeNode.putRight(six);

        //then
        assertThat(integerMtreeNode.getLeft(), is(four));
        assertThat(integerMtreeNode.getRight(), is(six));

    }

    /*
    * Comparator primary type 자동 구현
    * Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
    *
    *
    * */

    @Test
    public void Mtree_노트_탐색_테스트() throws Exception {
        /*
        *  트리 구조
        *               5
        *           4           7
        *       2           6       9
        *                       8
        *
        * */

        //given
        MtreeNode<Integer> rootFive = new MtreeNode<>(5);
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

        //then
        assertThat(rootFive.getLeft().getLeft().getRight(), is(tree));
        assertThat(rootFive.getRight().getRight().getLeft(), is(eight));
    }

    // findNodeInteger 해당 값이 노드 값은integerMtreeNode int 값으로 비교해서 tree 선택


    @Test
    public void 값이_5인_Root노드에서_findNode로_8을_인자로_넘겨주면_rightNode를_넘겨줌() throws Exception {
        MtreeNode<Integer> rootFive = new MtreeNode<>(5);
        MtreeNode<Integer> tree = new MtreeNode<>(3);
        MtreeNode<Integer> eight = new MtreeNode<>(8);
        rootFive.putLeft(tree);
        rootFive.putRight(eight);

        MtreeNode<Integer> shouldBeEight = findNodeInteger(rootFive, 8);
        assertThat(shouldBeEight, is(eight));
    }

    private MtreeNode<Integer> findNodeInteger(MtreeNode<Integer> rootFive, Integer integer) {
        Integer value = rootFive.getValue();
        if(value == integer) {
            return rootFive;
        } else if (value < integer) {
            return rootFive.getRight();
        } else {
            return rootFive.getLeft();
        }
    }

    @Test
    public void TreeSet의_Comparable_로직_확인() throws Exception {
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(5);
        integers.add(3);
        integers.add(4);
    }

    @Test
    public void Root_에서_다른_노드로_가는_경로는_하나뿐임() throws Exception {

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

        List<MtreeNode> expect = new ArrayList<>();
        expect.add(rootFive);
        expect.add(seven);
        expect.add(nine);
        expect.add(eight);

        //when
        List<MtreeNode> path = findPath(rootFive, 8);

        //then
        assertThat(path.size(), is(expect.size()));
        for (int i = 0; i < expect.size(); i++) {
            assertThat(path.get(i), is(expect.get(i)));
        }
    }

    @Test
    public void Root_에서_다른_노드로_가는_경로가_없는_경우_빈_List를_반환함() throws Exception {

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
        List<MtreeNode> path = findPath(rootFive, 10);

        //then
        assertThat(path.size(), is(0));
    }

    private List<MtreeNode> findPath(MtreeNode<Integer> fromNode, Integer toValue) {
        List<MtreeNode> path = new ArrayList<>();
        vistorTree(fromNode, toValue, path);
        return path;
    }
    // fromNode 가 null 인 경우 path = new ArrayList 를 해도 size 3인 리스트가 반환 되어 clear로 처리하니 해결
    // 아직 이유를 알 수 없음
    private void vistorTree(MtreeNode<Integer> fromNode, Integer toValue, List<MtreeNode> path) {
        if (fromNode == null) {
            path.clear();
        } else {
            path.add(fromNode);
            Integer value = fromNode.getValue();
            if (value == toValue) {

            } else if (value < toValue) {
                vistorTree(fromNode.getRight(), toValue, path);
            } else {
                vistorTree(fromNode.getLeft(), toValue, path);
            }
        }
    }

}
