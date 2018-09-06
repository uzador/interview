package stack_and_queue;

public class MyQueue<T> {
    QueueNode<T> head;
    QueueNode<T> tail;

    public MyQueue<T> add(final T element) {
        final QueueNode<T> n = new QueueNode<>(element);
        if (tail != null) {
            tail.next = n;
        }
        tail = n;

        if (head == null) {
            head = tail;
        }

        return this;
    }

    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return head.element;
    }

    public T remove() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        final T element = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return element;
    }

    public void printHead() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        QueueNode<T> n = head;
        while (n != null) {
            System.out.print(n.element + " ");
            n = n.next;
        }
    }

    public void printTail() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        QueueNode<T> n = tail;
        while (n != null) {
            System.out.print(n.element + " ");
            n = n.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) throws EmptyQueueException {
        final MyQueue<Integer> q = new MyQueue<>();
        q.add(1).add(2).add(3).add(4).add(5);
        q.printHead();
        System.out.println();
        q.printTail();
        System.out.println();

        q.remove();
        q.printHead();
        System.out.println();
        q.printTail();
        System.out.println();

        q.remove();
        q.printHead();
        System.out.println();
        q.printTail();
        System.out.println();


        q.remove();
        q.printHead();
        System.out.println();
        q.printTail();
        System.out.println();


        q.remove();
        q.printHead();
        System.out.println();
        q.printTail();
        System.out.println();


        q.remove();
        q.printHead();
        System.out.println();
        q.printTail();
        System.out.println();
    }
}
