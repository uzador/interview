package stack_and_queue

import spock.lang.Shared
import spock.lang.Specification

class StackMinTest extends Specification {

    @Shared def stack

    def setup() {
        stack  = new StackMin2<>()
    }

    def "empty"() {
        expect:
        stack.isEmpty()
    }

    def "not empty"() {
        when:
        stack.push(10)

        then:
        !stack.isEmpty()
    }

    def "pop when empty"() {
        when:
        stack.pop()

        then:
        thrown(EmptyStackException.class)
        stack.isEmpty()
    }

    def "peek when empty"() {
        when:
        stack.pop()

        then:
        thrown(EmptyStackException.class)
        stack.isEmpty()
    }

    def "push and pop min"() {
        when:
        stack.push(10)
        stack.push(5)
        stack.push(20)
        stack.push(3)
        stack.push(5)

        then:
        3 == stack.pop()
        3 == stack.pop()
        5 == stack.pop()
        5 == stack.pop()
        10 == stack.pop()
    }

    def "push and peek min"() {
        when:
        stack.push(10)
        stack.push(5)
        stack.push(20)
        stack.push(3)
        stack.push(5)

        then:
        3 == stack.peek()
        3 == stack.peek()
        3 == stack.peek()
        3 == stack.peek()
        3 == stack.peek()
    }
}
