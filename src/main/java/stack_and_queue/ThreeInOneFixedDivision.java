package stack_and_queue;

public class ThreeInOneFixedDivision<T> {
    private final int stackCapacity;
    private final T[] values;
    private final int[] sizes;
    private final int numberOfStacks = 3;

    ThreeInOneFixedDivision(final int capacity) {
        this.stackCapacity = capacity;
        values = (T[]) new Object[numberOfStacks * capacity];
        sizes = new int[numberOfStacks];
    }

    public T peek(final int stackNumber) throws EmptyStackException {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        return values[indexOfTop(stackNumber)];
    }

    public void push(final T element, final int stackNum) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = element;
    }

    public T pop(final int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        final int topIndex = indexOfTop(stackNum);
        T data = values[topIndex];
        values[topIndex] = null;
        sizes[stackNum]--;

        return data;
    }

    private int indexOfTop(final int number) {
        final int offset = stackCapacity * number;
        final int size = sizes[number];

        return offset + size - 1;
    }

    public boolean isFull(final int number) {
        return sizes[number] == stackCapacity;
    }

    public boolean isEmpty(final int number) {
        return sizes[number] == 0;
    }
}
