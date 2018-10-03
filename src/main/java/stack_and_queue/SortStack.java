package stack_and_queue;

public class SortStack<T extends Comparable<T>> {
    final StackForSort<T> f = new StackForSort<>();
    final StackForSort<T> s = new StackForSort<>();

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return s.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return s.peek();
    }

    public void push(final T element) {
        if (isEmpty()) {
            s.push(element);
        } else {
            while (!s.isEmpty() && element.compareTo(s.peek()) >= 0) {
                f.push(s.pop());
            }

            s.push(element);
            while (!f.isEmpty()) {
                s.push(f.pop());
            }
        }
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof SortStack) {
            SortStack<T> thatStack = (SortStack<T>) that;

            while (this.isEmpty() && thatStack.isEmpty()) {
                if (this.pop().compareTo(thatStack.pop()) != 0) {
                    return false;
                }
            }

            if (!this.isEmpty() || !thatStack.isEmpty()) {
                return false;
            }
        }

        return false;
    }

    private static class StackForSort<T extends Comparable<T>> {
        StackNode<T> top;

        public boolean isEmpty() {
            return top == null;
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            final T result = top.element;
            top = top.next;

            return result;
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            return top.element;
        }

        public void push(final T element) {
            StackNode<T> n = new StackNode<>(element);
            if (isEmpty()) {
                top = n;
            } else {
                n.next = top;
                top = n;
            }
        }
    }
}
