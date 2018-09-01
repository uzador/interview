package linked_list

import spock.lang.Shared
import spock.lang.Specification

class IntersectionTest extends Specification {
    @Shared def first, second, node1, node2, node3, node4, node5, node6, node7

    def setup() {
        first = new Intersection<>()
        second = new Intersection<>()

        node1 = new Node(1)
        node2 = new Node(2)
        node3 = new Node(3)
        node4 = new Node(4)
        node5 = new Node(5)
        node6 = new Node(6)
        node7 = new Node(7)
    }

    def "intersect: true"() {
        when:
        first.addToTail(node1).addToTail(node2).addToTail(node6)
        second.addToTail(node3).addToTail(node4).addToTail(node5).addToTail(node6)

        then:
        first.isIntersect(second)
    }

    def "intersect: false"() {
        when:
        first.addToTail(node1).addToTail(node2).addToTail(node3)
        second.addToTail(node4).addToTail(node5).addToTail(node6).addToTail(node7)

        then:
        !first.isIntersect(second)
    }

    def "intersect: true => getNode"() {
        when:
        first.addToTail(node1).addToTail(node2).addToTail(node6)
        second.addToTail(node3).addToTail(node4).addToTail(node5).addToTail(node6)
        def node = first.getIntersectionBegin(second);

        then:
        node6 == node;
    }

    def "intersect: false => getNode"() {
        when:
        first.addToTail(node1).addToTail(node2).addToTail(node3)
        second.addToTail(node4).addToTail(node5).addToTail(node6).addToTail(node7)
        def node = first.getIntersectionBegin(second);

        then:
        null == node;
    }
}
