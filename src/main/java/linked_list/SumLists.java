package linked_list;

public class SumLists {
    static SingleLinkedList<Integer> sum(final SingleLinkedList<Integer> a, final SingleLinkedList<Integer> b) {
        int first = getNumberFromList(a);
        int second = getNumberFromList(b);

        System.out.println("first: " + first);
        System.out.println("second: " + second);

        int result = first + second;

        return getListFromNumber(result);
    }

    private static SingleLinkedList<Integer> getListFromNumber(int number) {
        final SingleLinkedList<Integer> result = new SingleLinkedList<>();
        final int len = getLengthOfNumber(number);

        System.out.println("len:" + len);
        System.out.println("number:" + number);

        while (number > 0) {
            result.addToTail(number % 10);
            number /= 10;
        }

        return result;
    }

    private static int getLengthOfNumber(int number) {
        int len = 0;
        while (number > 0) {
            number /= 10;
            len++;
        }

        return len;
    }

    private static int getNumberFromList(final SingleLinkedList<Integer> a) {
        int first = 0;
        int step = 0;
        while (a.head != null) {
            first += a.head.element * Math.pow(10, step++);

            a.head = a.head.next;
        }

        return first;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> aList = new SingleLinkedList<>();
        aList.addToTail(7).addToTail(1).addToTail(6).addToTail(1);

        SingleLinkedList<Integer> bList = new SingleLinkedList<>();
        bList.addToTail(5).addToTail(9).addToTail(2);

        SumLists.sum(aList, bList).print();
    }
}
