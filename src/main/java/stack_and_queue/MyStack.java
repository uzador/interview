package stack_and_queue;

public class MyStack<T> {
    StackNode<T> head;

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        final T result = head.element;
        head = head.next;

        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(final T element) {
        StackNode<T> n = new StackNode<>(element);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return head.element;
    }
}
