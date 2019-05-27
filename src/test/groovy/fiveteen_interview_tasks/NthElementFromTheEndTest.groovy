package fiveteen_interview_tasks

import spock.lang.Specification
import spock.lang.Unroll

class NthElementFromTheEndTest extends Specification {

    NthElementFromTheEnd list

    def setup() {
        list = new NthElementFromTheEnd()
        for (num in 1..10) {
            list.addToTail(num)
        }
    }

    @Unroll
    def "#idx element from the end is #result"() {
        expect:
        list.getNthFromEnd(idx) == result

        where:
        idx | result
        0   | 10
        1   | 9
        2   | 8
        3   | 7
        4   | 6
        5   | 5
        6   | 4
        7   | 3
        8   | 2
        9   | 1
        10  | null
    }
}
