package linked_list

import spock.lang.Shared
import spock.lang.Specification

class ReturnKthElementSpec extends Specification {
    @Shared
    def returnKthElementList = new ReturnKthElement<>()

    def setupSpec() {
        returnKthElementList.addToTail(189).addToTail(22).addToTail(3).addToTail(191).addToTail(4).addToTail(35).addToTail(11)
    }

    def "returnKthElement: return Kth element"() {
        expect:
        returnKthElementList.returnKthElement(a) == b

        where:
        a | b
        1 | 11
        4 | 191
        7 | 189

    }

    def "returnKthElementRecursive: return Kth element"() {
        expect:
        returnKthElementList.returnKthElementRecursive(a) == b

        where:
        a | b
        1 | 11
        4 | 191
        7 | 189
        100|null

    }

    def "returnKthElementIterative: return Kth element"() {
        expect:
        returnKthElementList.returnKthElementIterative(a) == b

        where:
        a | b
        1 | 11
        4 | 191
        7 | 189

    }

    def "returnKthElementIterative2: return Kth element"() {
        expect:
        returnKthElementList.returnKthElementIterative2(a) == b

        where:
        a | b
        1 | 11
        4 | 191
        7 | 189
        100|null

    }

    def "returnKthElement: throw exception when no index element"() {
        when:
        returnKthElementList.returnKthElement(100)

        then:
        thrown(IndexOutOfBoundsException)

    }

    def "returnKthElementIterative: throw exception when no index element"() {
        when:
        returnKthElementList.returnKthElementIterative(100)

        then:
        thrown(IndexOutOfBoundsException)

    }

    def cleanupSpec() {
        returnKthElementList = null
    }
}
