package stack_and_queue;

public class StackOfSetOfStacks<T> {
    StackNode<T> head;
    private final int capacity;
    private int size;

    public StackOfSetOfStacks(final int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void push(final T element) {
        final StackNode<T> n = new StackNode<>(element);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }

        size++;
    }

    public T pop() {
        final T result = head.element;
        head = head.next;
        size--;

        return result;
    }

    public T peek() {
        return head.element;
    }
}
