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
        stacks.push(2)
        stacks.push(3)
        def result3 = stacks.pop()
        def result2 = stacks.pop()
        def result1 = stacks.pop()

        then:
        3 == result3
        2 == result2
        1 == result1
    }


}
