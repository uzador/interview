package stack_and_queue;

public class MinStackNode<T extends Comparable<T>> {
    T element;
    T min;
    MinStackNode<T> next;

    MinStackNode(final T element, final T minElement) {
        this.element = element;
        this.min = minElement;
    }
}
