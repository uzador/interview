package stack_and_queue

import spock.lang.Specification

class MyQueueTest extends Specification {

    def "remove when empty"() {
        given:
        def queue = new MyQueue<>()

        when:
        queue.remove()

        then:
        thrown(EmptyQueueException)
        queue.isEmpty()
    }

    def "add and remove when non empty"() {
        given:
        def queue = new MyQueue<>()

        when:
        queue.add(1)
        queue.add(2)
        queue.add(3)
        def result1 = queue.remove()
        def result2 = queue.remove()
        def result3 = queue.remove()

        then:
        result1 == 1
        result2 == 2
        result3 == 3
    }

    def "peek"() {
        given:
        def queue = new MyQueue<>()

        when:
        queue.add(3)
        queue.add(2)
        queue.add(1)
        def result1 = queue.peek()
        def result2 = queue.peek()
        def result3 = queue.peek()

        then:
        result3 == 3
        result2 == 3
        result1 == 3
    }

    def "isEmpty true"() {
        given:
        def queue = new MyQueue<>()

        expect:
        queue.isEmpty()
    }

    def "isEmpty false"() {
        given:
        def queue = new MyQueue<>()

        when:
        queue.add(1)

        then:
        !queue.isEmpty()
    }
}
