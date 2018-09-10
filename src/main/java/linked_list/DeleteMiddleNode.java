package linked_list;

public class DeleteMiddleNode<T> extends SingleLinkedList<T> {
    public DeleteMiddleNode() {

    }

    public DeleteMiddleNode(T element) {
        super(element);
    }

    public void deleteMiddle(final Node<T> node) {
        if (node == null || node.next == null) {
            return;
        }

        final Node<T> next = node.next;
        node.element = next.element;
        node.next = next.next;
    }

    public static void main(String[] args) {
        DeleteMiddleNode<Integer> list = new DeleteMiddleNode<>();
        Node<Integer> node189 = new Node<>(189);
        Node<Integer> node22 = new Node<>(22);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node191 = new Node<>(191);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node35 = new Node<>(35);
        Node<Integer> node11 = new Node<>(11);
        list.addToTail(node189).addToTail(node22).addToTail(node3).addToTail(node191).addToTail(node4).addToTail(node35).addToTail(node11);
        list.print();

        list.deleteMiddle(node22);
        list.deleteMiddle(node191);
        list.print();

        list.deleteMiddle(node189);
        list.print();

        list.deleteMiddle(node11);
        list.print();

        list.deleteMiddle(new Node<>(100));
        list.print();
    }
}
