package linked_list;

public class ReturnKthElement<T> extends SingleLinkedList<T> {
    private class ResultWrapper<T> {
        int index;

        void setIndex(final int index) {
            this.index = index;
        }

        int getIndex() {
            return index;
        }
    }

    public  ReturnKthElement(T element) {
        super(element);
    }

    public ReturnKthElement() {}

    public T returnKthElement(final int index) {
        int len = getListLength();

        int resultIndex = len - index;
        if (resultIndex < 0) {
            throw new IndexOutOfBoundsException("No index " + resultIndex);
        }

        return getNodeByIndex(resultIndex).element;
    }

    public T returnKthElementRecursive(final int index) {
        ResultWrapper<T> indexWrapper = new ResultWrapper<>();
        Node<T> result = returnKthElementRecursive(head, index, indexWrapper);

        return result == null ? null : result.element;
    }

    public T returnKthElementIterative(final int index) {
        Node<T> n = head;
        Node<T> n1 = head;
        int localIndex = 0;
        while (n1 != null) {
            localIndex++;
            if (localIndex > index) {
                n = n.next;
            }

            n1 = n1.next;
        }

        if (localIndex < index) {
            throw new IndexOutOfBoundsException("No index " + index);
        }

        return n.element;
    }

    public T returnKthElementIterative2(final int index) {
        Node<T> n = head;
        Node<T> r = head;

        for (int i = 0; i < index; i++) {
            if (n == null) {
                return null;
            }

            n = n.next;
        }

        while (n != null) {
            r = r.next;
            n = n.next;
        }

        return r.element;
    }

    private Node<T> returnKthElementRecursive(Node<T> head, final int index, final ResultWrapper<T> indexWrapper) {
        if (head == null) {
            return null;
        }

        Node<T> result = returnKthElementRecursive(head.next, index, indexWrapper);
        indexWrapper.setIndex(indexWrapper.getIndex() + 1);
        if (indexWrapper.getIndex() == index) {
            return head;
        }

        return result;
    }

    private int getListLength() {
        Node<T> n = head;
        int len = 0;
        while (n != null) {
            len++;
            n = n.next;
        }

        return len;
    }

    private Node<T> getNodeByIndex(final int index) {
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n;
    }
}
