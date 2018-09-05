package stack_and_queue;

public class MyStack<T> {
    Node<T> head;

    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        }

        final T result = head.element;
        head = head.next;

        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(final T element) {
        Node<T> n = new Node<>(element);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public T peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        }

        return head.element;
    }
}
