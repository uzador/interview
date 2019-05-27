package fiveteen_interview_tasks;

import java.util.stream.IntStream;

public class NthElementFromTheEnd<T extends Comparable<T>> {
    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public String toString() {
            return "Node{value=}" + value;
        }
    }

    Node<T> head;

    public void addToTail(T value) {
        final Node<T> n = new Node<>(value);
        if (isEmpty()) {
            head = n;
        } else {
            getTail().next = n;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    private Node<T> getTail() {
        if (isEmpty()) {
            return null;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }

        Node<T> current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public T getNthFromEnd(int idx) {
        if (isEmpty()) {
            return null;
        }

        int slowCount = 1;
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slowCount++;

            slow = slow.next;
            fast = fast.next.next;
        }

        int elements = slowCount * 2;
        if (fast.next == null) {
            elements--;
        }

        if (elements < idx) {
            return null;
        }

        int idxFromStart = elements - idx;

        System.out.println("idxFromStart: " + idxFromStart);

        Node<T> current;
        int iterations;
        if (idxFromStart < slowCount) {
            current = head;
            iterations = idxFromStart - 1;
        } else if (idxFromStart == slowCount) {
            return slow.value;
        } else {
            iterations = idxFromStart - slowCount;
            current = slow;
        }

        System.out.println("slowCount: " + slowCount);
        System.out.println("elements: " + elements);
        System.out.println("iterations: " + iterations);

        for(int i = 0; i < iterations; i++) {
            current = current.next;
        }

        return current.value;
    }

    public static void main(String[] args) {
        final NthElementFromTheEnd<Integer> list = new NthElementFromTheEnd<>();
        IntStream.rangeClosed(1, 10).forEach(list::addToTail);

        list.print();

        int idx = 6;
        System.out.println("idx[" + idx + "]: " + list.getNthFromEnd(idx));
    }
}
