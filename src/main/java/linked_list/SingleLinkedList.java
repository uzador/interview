package linked_list;

public class SingleLinkedList<T> {
    Node<T> head;

    SingleLinkedList() {
    }

    SingleLinkedList(T element) {
        head = new Node<>(element);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.print();
        list.remove(2);
        list.print();
        list.addToTail(10);
        list.print();
        list.remove(1);
        list.print();
        list.remove(10);
        list.print();
    }

    public SingleLinkedList<T> addToTail(final T element) {
        Node<T> end = new Node<>(element);
        if (isEmpty()) {
            head = end;
        } else {
            Node<T> last = getLast();
            last.next = end;
        }

        return this;
    }

    public SingleLinkedList<T> addToTail(final Node<T> node) {
        if (isEmpty()) {
            head = node;
        } else {
            final Node<T> last = getLast();
            last.next = node;
        }

        return this;
    }

    boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        if (head.element.equals(element)) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }

            return true;
        }

        Node<T> n = head;
        while (n.next != null) {
            if (n.next.element.equals(element)) {
                n.next = n.next.next;

                return true;
            }

            n = n.next;
        }

        return false;
    }

    private Node<T> getLast() {
        if (isEmpty()) {
            return null;
        }

        Node<T> n = head;
        while (n.next != null) {
            n = n.next;
        }

        return n;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node<T> n = head;
        while (n != null) {
            System.out.print(n + " ");
            n = n.next;
        }
        System.out.println();
    }
}
