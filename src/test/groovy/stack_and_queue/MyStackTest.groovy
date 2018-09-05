package stack_and_queue

import spock.lang.Specification

class MyStackTest extends Specification {

    def "pop when empty"() {
        given:
        def stack = new MyStack<>()

        when:
        stack.pop()

        then:
        thrown(StackEmptyException)
        stack.isEmpty()
    }

    def "push and pop when non empty"() {
        given:
        def stack = new MyStack<>()

        when:
        stack.push(3)
        stack.push(2)
        stack.push(1)
        def result1 = stack.pop()
        def result2 = stack.pop()
        def result3 = stack.pop()

        then:
        result3 == 3
        result2 == 2
        result1 == 1
    }

    def "peek"() {
        given:
        def stack = new MyStack<>()

        when:
        stack.push(3)
        stack.push(2)
        stack.push(1)
        def result1 = stack.peek()
        def result2 = stack.peek()
        def result3 = stack.peek()

        then:
        result3 == 1
        result2 == 1
        result1 == 1
    }

    def "isEmpty true"() {
        given:
        def stack = new MyStack<>()

        expect:
        stack.isEmpty()
    }

    def "isEmpty false"() {
        given:
        def stack = new MyStack<>()

        when:
        stack.push(1)

        then:
        !stack.isEmpty()
    }
}
