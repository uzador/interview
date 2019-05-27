package trees_and_graphs;

import java.util.Arrays;

public class MinimalBST {
    private static class TNode<T> {
        private final T value;
        private TNode<T> left;
        private TNode<T> right;

        private TNode(T value) {
            this.value = value;
        }

        public void print() {
            System.out.println(value);
            if (left != null) {
                left.print();
            }
            if (right != null) {
                right.print();
            }

        }
    }

    public static TNode<Integer> createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TNode<Integer> createMinimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }

        final int mid = start + (end - start) / 2;
        final TNode n = new TNode<>(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);

        return n;
    }

    public static void main(String[] args) {
        final int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(array);

        final TNode<Integer> tree1 = MinimalBST.createMinimalBST(array);
        tree1.print();
    }
}
