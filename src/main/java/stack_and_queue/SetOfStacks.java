package stack_and_queue;

import java.lang.reflect.Array;



public class SetOfStacks<T> {
    public static final int NUMBER_OF_STACKS = 10;
    private final int stackCapacity;
    private final StackOfSetOfStacks<T>[] stacks;
    private int current;

    public SetOfStacks(final int stackCapacity) {
        this.stackCapacity = stackCapacity;
//        this.stacks = (StackOfSetOfStacks<T>[]) new Object[NUMBER_OF_STACKS];
        this.stacks = (StackOfSetOfStacks<T>[])
                Array.newInstance(StackOfSetOfStacks.class, NUMBER_OF_STACKS);
        this.stacks[current] = new StackOfSetOfStacks<>(stackCapacity);
    }

    public void push(final T element) {
        checkFullCapacity();

        stacks[current].push(element);
    }

    public T pop() {
        checkEmptyCapacity();

        return stacks[current].pop();
    }

    private StackOfSetOfStacks<T> getStack() {
        checkFullCapacity();
        return stacks[current];
    }

    private void checkFullCapacity() {
        final boolean isStackIsFull = stacks[current].isFull();
        if (isStackIsFull && current == NUMBER_OF_STACKS) {
            throw new FullStackException();
        }

        if (isStackIsFull) {
            stacks[++current] = new StackOfSetOfStacks<>(stackCapacity);
        }
    }

    private void checkEmptyCapacity() {
        final boolean isStackEmpty = stacks[current].isEmpty();
        if (isStackEmpty && current != 0) {
            stacks[current] = null;
            current--;
        } else if (isStackEmpty) {
            throw new EmptyStackException();
        }
    }
}
