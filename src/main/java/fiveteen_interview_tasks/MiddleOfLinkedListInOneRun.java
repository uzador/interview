package fiveteen_interview_tasks;

public class MiddleOfLinkedListInOneRun<T> {
    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{value=" + value + '}';
        }
    }

    private Node<T> head;

    public void add(T value) {
        final Node<T> n = new Node<>(value);
        if (head == null) {
            head = n;
        } else {
            getTail().next = n;
        }
    }

    public Node<T> getMiddle() {
        Node<T> current = head;
        Node<T> middle = head;
        int iteration = 1;
        while(current != null) {
            if (iteration % 2 == 0) {
                middle = middle.next;
            }
            current = current.next;
            iteration++;
        }

        return middle;
    }

    private Node<T> getTail() {
        Node<T> current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }

        return current;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        final MiddleOfLinkedListInOneRun<Integer> list = new MiddleOfLinkedListInOneRun<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.print();
        System.out.println(list.getMiddle());
    }
}
