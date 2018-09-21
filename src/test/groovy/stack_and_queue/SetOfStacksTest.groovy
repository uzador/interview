package stack_and_queue

import spock.lang.Specification

class SetOfStacksTest extends Specification {
    def stacks

    def setup() {
        stacks = new SetOfStacks<>(2)
    }

    def "isEmpty"() {
        when:
        stacks.pop()

        then:
        thrown(EmptyStackException)
    }

    def "isFull"() {
        when:
        21.times {
            stacks.push(1)
        }

        then:
        thrown(FullStackException)
    }

    def "push and pop"() {
        when:
        stacks.push(1)
        def result = stacks.pop()

        then:
        result == 1
    }


}
