package stack_and_queue;

public class QueueViaStacks<T> {
    private final Stack<T> head;
    private final Stack<T> tail;

    public QueueViaStacks() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    public void add(T element) {
        head.push(element);
    }

    public T remove() {
        shift();
        return tail.pop();
    }

    public T peek() {
        shift();
        return tail.peek();
    }

    public boolean isEmpty() {
        return head.isEmpty() && tail.isEmpty();
    }

    private void shift() {
        if (tail.isEmpty()) {
            while(!head.isEmpty()) {
                tail.push(head.pop());
            }
        }
    }

    private static class Stack<T> {
        StackNode<T> head;

        public void push(T element) {
            StackNode<T> n = new StackNode<T>(element);
            if (isEmpty()) {
                head = n;
            } else {
                n.next = head;
                head = n;
            }
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            T result = head.element;
            head.element = null;
            head = head.next;
            return result;
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            T result = head.element;
            head = head.next;
            return result;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }
}
