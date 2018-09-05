package linked_list;

public class LoopDetection<T> {
    Node<T> head;

    public Node<T> getLoopStartIfExist() {
        if (isEmpty()) {
            return null;
        }

        Node<T> collide = getCollideNode();
        if (collide != null) {
            return getLoopStart(collide);
        }

        return null;
    }

    private Node<T> getLoopStart(final Node<T> collide) {
        Node<T> h = head;
        Node<T> c = collide;
        while(h != null) {
            if (h == c) {
                return h;
            }

            h = h.next;
            c = c.next;
        }

        return null;
    }

    private Node<T> getCollideNode() {
        Node<T> fast = head;
        Node<T> slow = head;

        boolean notFirstIteration = false;
        while (fast.next != null && fast.next.next != null) {
            if (fast == slow && notFirstIteration) {
                return fast;
            }

            notFirstIteration = true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }

    public boolean isLoop() {
        if (isEmpty()) {
            return false;
        }

        Node<T> fast = head;
        Node<T> slow = head;

        boolean notFirstIteration = false;
        while (fast.next != null && fast.next.next != null) {
            if (fast == slow && notFirstIteration) {
                return true;
            }

            notFirstIteration = true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public LoopDetection<T> addToTail(final Node<T> node) {
        if (isEmpty()) {
            head = node;
        } else {
            head.next = node;
        }

        return this;
    }

    private boolean isEmpty() {
        return head == null;
    }
}
