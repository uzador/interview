package stack_and_queue;

public class StackNode<T> {
    T element;
    StackNode<T> next;

    StackNode(T element) {
        this.element = element;
    }
}
