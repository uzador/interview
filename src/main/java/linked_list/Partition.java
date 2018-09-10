package linked_list;

public class Partition<T extends Comparable<T>> extends SingleLinkedList<T> {
    public Partition() {}

    public Partition(T element) {
        super(element);
    }

    public void partition(final T element) {
        Node<T> f = null;
        Node<T> fStart = null;
        Node<T> s = null;
        Node<T> sStart = null;
        Node<T> n = head;
        while (n != null) {
            T listElement = n.element;
            Node<T> nodeToAdd = new Node<>(listElement);

            if (listElement.compareTo(element) < 0) {
                if (f == null) {
                    f = nodeToAdd;
                    fStart = nodeToAdd;
                } else {
                    f.next = nodeToAdd;
                    f = f.next;
                }
            } else {
                if (s == null) {
                    s = nodeToAdd;
                    sStart = nodeToAdd;
                } else {
                    s.next = nodeToAdd;
                    s = s.next;
                }
            }

            n = n.next;
        }

        if (fStart == null) {
            head = sStart;
        } else {
            f.next = sStart;
            head = fStart;
        }
    }

    public void partition2(final T element) {
        Node<T> h = head;
        Node<T> tail = head;
        while (head != null) {
            Node<T> next = head.next;

            if (head.element.compareTo(element) < 0) {
                head.next = h;
                h = head;
            } else {
                tail.next = head;
                tail = head;
            }

            head = next;
        }

        tail.next  = null;
        head = h;
    }

    public static void main(String[] args) {
        Partition<Integer> list = new Partition<>();
        list.addToTail(3).addToTail(5).addToTail(8).addToTail(5).addToTail(10).addToTail(2).addToTail(1).addToTail(15).addToTail(3).addToTail(4);
        list.print();
        list.partition(5);
        list.print();

        Partition<Integer> list1 = new Partition<>();
        list1.addToTail(1).addToTail(2).addToTail(3).addToTail(4).addToTail(3).addToTail(2).addToTail(1).addToTail(2).addToTail(3).addToTail(4);
        list1.print();
        list1.partition(5);
        list1.print();

        Partition<Integer> list2 = new Partition<>();
        list2.addToTail(10).addToTail(20).addToTail(30).addToTail(40).addToTail(30).addToTail(20).addToTail(10).addToTail(20).addToTail(30).addToTail(40);
        list2.print();
        list2.partition(5);
        list2.print();

        System.out.println("-------------------------");

        Partition<Integer> list3 = new Partition<>();
        list3.addToTail(3).addToTail(5).addToTail(8).addToTail(5).addToTail(10).addToTail(2).addToTail(1).addToTail(15).addToTail(3).addToTail(4);
        list3.print();
        list3.partition2(5);
        list3.print();

        Partition<Integer> list4 = new Partition<>();
        list4.addToTail(1).addToTail(2).addToTail(3).addToTail(4).addToTail(3).addToTail(2).addToTail(1).addToTail(2).addToTail(3).addToTail(4);
        list4.print();
        list4.partition2(5);
        list4.print();

        Partition<Integer> list5 = new Partition<>();
        list5.addToTail(10).addToTail(20).addToTail(30).addToTail(40).addToTail(30).addToTail(20).addToTail(10).addToTail(20).addToTail(30).addToTail(40);
        list5.print();
        list5.partition2(5);
        list5.print();
    }
}
