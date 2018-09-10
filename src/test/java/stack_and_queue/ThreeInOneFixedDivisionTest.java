package stack_and_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeInOneFixedDivisionTest {

    private ThreeInOneFixedDivision<Integer> stack;

    @BeforeEach
    void createNewStack() {
        stack = new ThreeInOneFixedDivision<>(3);
    }

    @Test
    @DisplayName("is empty")
    void isEmpty() {
        IntStream.range(0, 3).forEach(num ->
                assertTrue(stack.isEmpty(num)));
    }

    @DisplayName("Throw EmptyStackException exception when pop from empty stack")
    @ParameterizedTest(name = "{index} stack")
    @ValueSource(ints = {0, 1, 2})
    void throwsExceptionWhenPopped(final int arg) {
        assertThrows(EmptyStackException.class, () -> stack.pop(arg));
    }

    @DisplayName("push stakc fully and get FullStackException on push")
    @Test
    void pushAndGetException() throws FullStackException {
        stack.push(1, 1);
        stack.push(2, 1);
        stack.push(3, 1);
        assertThrows(FullStackException.class, () -> stack.push(4, 1));
    }
}