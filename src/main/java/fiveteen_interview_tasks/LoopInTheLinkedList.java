package fiveteen_interview_tasks;

public class LoopInTheLinkedList<T extends Comparable<T>> {
    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    Node<T> head;

    public void addToTail(T value) {
        Node<T> n = new Node<>(value);
        if (isEmpty()) {
            head = n;
        } else {
            getTail().next = n;
        }
    }

    public void addToTail(final Node<T> node) {
        if (isEmpty()) {
            head = node;
        } else {
            getTail().next = node;
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

    public boolean isLoopDetected() {
        if (isEmpty()) {
            return false;
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.value.compareTo(fast.value) == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        final LoopInTheLinkedList<Integer> list = new LoopInTheLinkedList<>();
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        n4.next = n1;

        list.addToTail(n1);
        list.addToTail(n2);
        list.addToTail(n3);
        list.addToTail(n4);

        System.out.println(list.isLoopDetected());
    }
}
