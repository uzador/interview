package stack_and_queue;

public class StackMin<T extends Comparable<T>> {
    MinStackNode<T> head;

    public void push(final T element) {
        final MinStackNode<T> n = new MinStackNode<>(element, element);

        if (isEmpty()) {
            head = n;
        } else {
            if (head.min.compareTo(element) <= 0) {
                n.min = head.min;
            }

            n.next = head;
            head = n;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        final T result = head.min;
        head = head.next;

        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return head.min;

    }

    public boolean isEmpty() {
        return head == null;
    }
}
