package stack_and_queue;

import java.lang.reflect.Array;



public class SetOfStacks<T> {
    private static final int NUMBER_OF_STACKS = 10;
    private final int stackCapacity;
    private final StackOfSetOfStacks<T>[] stacks;
    private int current;

    public SetOfStacks(final int stackCapacity) {
        this.stackCapacity = stackCapacity;
        this.stacks = (StackOfSetOfStacks<T>[])
                Array.newInstance(StackOfSetOfStacks.class, NUMBER_OF_STACKS);
    }

    public void push(final T element) {
//        checkFullCapacity();
//        stacks[current].push(element);
        StackOfSetOfStacks<T> stack = getLastStack();
        if (stack != null && !stack.isFull() && current != NUMBER_OF_STACKS - 1) {
            stack.push(element);
        } else if (stack == null) {
            stack = new StackOfSetOfStacks<>(stackCapacity);
            stack.push(element);
            stacks[current] = stack;
        } else if (stack.isFull() && current != NUMBER_OF_STACKS - 1) {
            stack = new StackOfSetOfStacks<>(stackCapacity);
            stack.push(element);
            stacks[++current] = stack;
        } else {
            throw new FullStackException();
        }
    }

    public T pop() {
//        checkEmptyCapacity();
//        return stacks[current].pop();
        final StackOfSetOfStacks<T> stack = getLastStack();

        if (stack == null) {
            throw new EmptyStackException();
        }

        final T result = stack.pop();

        if (stack.isEmpty() && current == 0) {
            stacks[current] = null;
        }

        if (stack.isEmpty() && current != 0) {
            stacks[current--] = null;
        }

        return result;
    }

    private StackOfSetOfStacks<T> getLastStack() {
        return stacks[current];
    }

    private StackOfSetOfStacks<T> getStack() {
        checkFullCapacity();
        return stacks[current];
    }

    private void checkFullCapacity() {
        final boolean isStackIsFull = stacks[current].isFull();
        if (isStackIsFull && current == NUMBER_OF_STACKS - 1) {
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
