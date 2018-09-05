package linked_list

import spock.lang.Shared
import spock.lang.Specification

class LoopDetectionTest extends Specification {

    @Shared def listWithLoop, node1, node2, node3, node4, node5, node6, node7

    def setup() {
        listWithLoop = new LoopDetection<>()

        node1 = new Node(1)
        node2 = new Node(2)
        node3 = new Node(3)
        node4 = new Node(4)
        node5 = new Node(5)
        node6 = new Node(6)
        node7 = new Node(7)
    }

    def "loop detection: true"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node1
        listWithLoop.addToTail(node1)

        then:
        listWithLoop.isLoop()
    }

    def "loop detection: false"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        listWithLoop.addToTail(node1)

        then:
        !listWithLoop.isLoop()
    }

    def "get loop start - loop from head: true"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node1
        listWithLoop.addToTail(node1)

        then:
        node1 == listWithLoop.getLoopStartIfExist()
    }

    def "get loop start - loop not from head: true"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node4
        listWithLoop.addToTail(node1)

        then:
        node4 == listWithLoop.getLoopStartIfExist()
    }

    def "get loop start - loop from head: true but wrong node"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node1
        listWithLoop.addToTail(node1)

        then:
        node2 != listWithLoop.getLoopStartIfExist()
    }

    def "get loop start - loop not from head: true but wrong node"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node4
        listWithLoop.addToTail(node1)

        then:
        node3 != listWithLoop.getLoopStartIfExist()
    }

    def "get loop start - loop not from head: false"() {
        when:
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        listWithLoop.addToTail(node1)

        then:
        null == listWithLoop.getLoopStartIfExist()
    }
}
