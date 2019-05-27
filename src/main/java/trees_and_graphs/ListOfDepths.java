package trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths<T extends Comparable<T>> {
    private static class Node<T> {
        private final T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }

        public void print() {
            System.out.print(value + " ");
            if (left != null) left.print();
            if (right != null) right.print();
        }

        @Override
        public String toString() {
            return "Node{value=" + value + '}';
        }
    }

    Node<T> root;

    public void print() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else {
            root.print();
        }
    }

    public void add(T value) {
        if (isEmpty()) {
            root = new Node<>(value);
        } else {
            add(root, value);
        }
    }

    private void add(final Node<T> node, final T value) {
        if (value.compareTo(node.value) <= 0) {
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                add(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                add(node.right, value);
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public List<List<Node<T>>> createLevelLinkedList() {
        final List<List<Node<T>>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);

        return lists;
    }

    private void createLevelLinkedList(final Node<T> root, final List<List<Node<T>>> lists, int level) {
        if (root == null) {
            return;
        }

        List<Node<T>> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);

        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public List<List<Node<T>>> createLevelLinkedListWithBfs() {
        final List<List<Node<T>>> result = new ArrayList<>();
        List<Node<T>> current = new LinkedList<>();

        if (!isEmpty()) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            List<Node<T>> parents = current;
            current = new LinkedList<>();
            for(final Node<T> parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final ListOfDepths<Integer> tree = new ListOfDepths<>();
        tree.add(100);
        tree.add(90);
        tree.add(110);
        tree.add(85);
        tree.add(95);
        tree.add(105);
        tree.add(115);
        tree.add(82);
        tree.add(87);
        tree.add(92);
        tree.add(97);
        tree.add(102);
        tree.add(107);
        tree.add(112);
        tree.add(117);

        tree.print();
        System.out.println();
//        final List<List<Node<Integer>>> lists = tree.createLevelLinkedList();
        final List<List<Node<Integer>>> lists = tree.createLevelLinkedListWithBfs();

        System.out.println(lists);
    }
}
