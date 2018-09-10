package strings

import spock.lang.Specification
import spock.lang.Unroll

class StringRotationSpec extends Specification {

    def "isSubstring matrix"(String sub, String str, boolean result) {
        expect:
        StringRotation.isSubstring(sub, str) == result

        where:
        sub|str|result
        "def"|"abcdefghijk"|true
        "def1"|"abcdefghijk"|false
    }

    @Unroll
    def "isRotation matrix #str and #sub is #result"() {
        expect:
        StringRotation.isRotation(str, sub) == result

//        where:
//        str|sub|result
//        "erbottlewat"|"waterbottle"||true
//        "waterbottle"|"waterbottle"||true
//        "waterbottle"|"ewaterbottl"||true
//        "waterbottle"|"ewaterbottla"||false
//        "waterbottle"|"ewaterbott"||false
        where:
        str << ["erbottlewat", "waterbottle", "waterbottle", "waterbottle", "waterbottle"]
        sub << ["waterbottle", "waterbottle", "ewaterbottl", "ewaterbottla", "ewaterbott"]
        result << [true, true, true, false, false]
    }
}
