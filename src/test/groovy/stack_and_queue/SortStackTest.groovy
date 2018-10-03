package stack_and_queue

import spock.lang.Specification

class SortStackTest extends Specification {
    def stack

    def setup() {
        stack = new SortStack<>()
    }

    def "pop when empty"() {
        when:
        stack.pop()

        then:
        thrown EmptyStackException.class
        stack.isEmpty()
    }

    def "pop when non empty"() {
        when:
        stack.push(50)
        stack.push(100)
        stack.push(40)
        stack.push(200)
        stack.push(3)

        then:
        3 == stack.pop()
        40 == stack.pop()
        50 == stack.pop()
        100 == stack.pop()
        200 == stack.pop()
    }
}
