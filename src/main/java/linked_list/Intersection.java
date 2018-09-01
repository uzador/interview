package linked_list;

public class Intersection<T> {
    Node<T> head;

    public Node<T> getIntersectionBegin(final Intersection<T> list) {
        // 1. getLastNode and list length
        final ResultWrapper<T> first = getLengthAndLastNode(this);
        final ResultWrapper<T> second = getLengthAndLastNode(list);

        //2. check intersection and proceed if success
        if (first.node != second.node) {
            return null;
        }

        Node<T> firstHead = this.head;
        Node<T> secondHead = list.head;
        int lengthDiff = first.length - second.length;

        if (lengthDiff > 0) {
            firstHead = movePointerToLenDiff(this, lengthDiff);
        } else if (lengthDiff < 0) {
            secondHead = movePointerToLenDiff(list, -lengthDiff);
        }

        return getIntersectionNode(firstHead, secondHead);
    }

    private Node<T> getIntersectionNode(Node<T> firstHead, Node<T> secondHead) {
        while(firstHead != null && secondHead != null) {
            if (firstHead == secondHead) {
                return firstHead;
            }

            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return null;
    }

    private Node<T> movePointerToLenDiff(final Intersection<T> list, final int lengthDiff) {
        Node<T> n = list.head;
        for (int i = 0; i < lengthDiff; i++) {
            n = n.next;
        }

        return n;
    }

    private ResultWrapper<T> getLengthAndLastNode(final Intersection<T> list) {
        Node<T> n = list.head;
        int len = 0;
        while (n.next != null) {
            len++;
            n = n.next;
        }

        return new ResultWrapper<>(len, n);
    }

    public boolean isIntersect(final Intersection<T> list) {
        return getLastNode() == list.getLastNode();
    }

    public Intersection<T> addToTail(final Node<T> node) {
        if (isEmpty()) {
            head = node;
        } else {
            getLastNode().next = node;
        }

        return this;
    }

    private Node<T> getLastNode() {
        Node<T> n = head;

        while (n.next != null) {
            n = n.next;
        }

        return n;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private class ResultWrapper<T> {
        int length;
        Node<T> node;

        ResultWrapper(int length, Node<T> node) {
            this.length = length;
            this.node = node;
        }
    }
}
