package stack_and_queue;

public class StackMin2<T extends Comparable<T>> extends MyStack<T> {
    MyStack<T> s2;

    StackMin2() {
        s2 = new MyStack<>();
    }

    @Override
    public void push(final T element) {
        if (isEmpty()) {
            s2.push(element);
        } else {
            final T minElement = s2.peek();
            if (minElement.compareTo(element) >= 0) {
                s2.push(element);
            }
        }

        super.push(element);
    }

    @Override
    public T pop() {
        final T value = super.pop();
        final T minValue = s2.peek();
        if (value.compareTo(minValue) == 0) {
            s2.pop();
        }

        return minValue;
    }

    @Override
    public T peek() throws EmptyStackException {
        return s2.peek();
    }
}
