package trees_and_graphs

import spock.lang.Shared
import spock.lang.Specification

class RouteBetweenNodesTest extends Specification {
    def n, n1, n2, n3, n31, n32, n21, n22, n23, n311, n312, n3121
    def g, r

    def setup() {
        n = new GraphNode<>("1")
        n1 = new GraphNode<>("2")
        n2 = new GraphNode<>("3")
        n3 = new GraphNode<>("4")

        n31 = new GraphNode<>("5")
        n32 = new GraphNode<>("6")

        n21 = new GraphNode<>("7")
        n22 = new GraphNode<>("8")
        n23 = new GraphNode<>("9")

        n311 = new GraphNode<>("11")
        n312 = new GraphNode<>("12")

        n3121 = new GraphNode<>("13")

        r = new RouteBetweenNodes()
    }

    def "path between nodes exists"() {
        when:
        n.adjacent = [n1, n2, n3]
        n2.adjacent = [n21, n22, n23]
        n3.adjacent = [n31, n32]
        n31.adjacent = [n311, n312]
        n32.adjacent = [n3121]
        n3121.adjacent = [n]

        g = new Graph<String>(n)

        then:
        r.search(g, n, n3121)

    }

    def "path between nodes doesn't exists"() {
        when:
        n.adjacent = [n1, n2, n3]
        n2.adjacent = [n21, n22, n23]
        n3.adjacent = [n31, n32]
        n31.adjacent = [n311, n312]
        n32.adjacent = [n3121]

        g = new Graph<String>(n)

        then:
        !r.search(g, n1, n3121)

    }
}
