package stack_and_queue

import spock.lang.Specification

class QueueViaStacksTest extends Specification {
    def queue

    def setup() {
        queue = new QueueViaStacks<>()
    }


    def "empty queue"() {
        when:
        queue.remove()

        then:
        thrown(EmptyStackException.class)
        queue.isEmpty()
    }

    def "add elements"() {
        when:
        queue.add(1)
        queue.add(2)

        def res1 = queue.remove()
        def res2 = queue.remove()

        then:
        1 == res1
        2 == res2
        queue.isEmpty()
    }
}
