package linked_list;

import java.util.HashSet;
import java.util.Set;

class SingleLinkedListWithRemoveDups<T> extends SingleLinkedList<T> {

    SingleLinkedListWithRemoveDups(T element) {
        super(element);
    }

    SingleLinkedListWithRemoveDups() {
    }

    public void removeDups() {
        Node<T> n = head;
        while (n != null) {
            remove(n.element, n);

            n = n.next;
        }
    }

    private void remove(final T element, final Node<T> start) {
        Node<T> n = start;
        while (n != null) {
            if (n.next != null && n.next.element.equals(element)) {
                n.next = n.next.next;
            }

            n = n.next;
        }
    }

    public void removeDupsWithSet() {
        Node<T> n = head;
        Node<T> prev = head;
        final Set<T> set = new HashSet<>();
        while (n != null) {
            if (set.contains(n.element)) {
                prev.next  = n.next;
            } else {
                set.add(n.element);
            }

            prev = n;
            n = n.next;
        }
    }
}

public class RemoveDups {
    public static void main(String[] args) {
        final SingleLinkedListWithRemoveDups<Integer> list1 = new SingleLinkedListWithRemoveDups<>();
        list1.addToTail(1).addToTail(2).addToTail(3).addToTail(11).addToTail(4).addToTail(5).addToTail(11);
        list1.print();
        list1.remove(1);
        list1.addToTail(6).addToTail(7).addToTail(8).addToTail(17).addToTail(9).addToTail(10).addToTail(17);
        list1.print();
        list1.remove(10);
        list1.remove(2);
        list1.print();
        list1.addToTail(3).addToTail(4);
        list1.print();
        list1.removeDupsWithSet();
        list1.print();
    }
}
