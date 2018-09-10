package interview.top_n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.LongStream;

class NGeneric<T extends Comparable<T>> {
    private final int n;
    private final TreeSet<T> nStorage;
    private final Comparator<T> comparator = (o1, o2) -> {
        return o2.compareTo(o1);
    };

    NGeneric(int n) {
        this.n = n;
        this.nStorage = new TreeSet<>(comparator);
    }


    void push(T value) {
        if (nStorage.size() == n) {
            if (nStorage.contains(value)) {
                return;
            }

            final T lastElement = nStorage.last();
            if (lastElement.compareTo(value) < 0) {
                nStorage.remove(lastElement);
            } else {
                return;
            }
        }

        nStorage.add(value);
    }

    Collection<T> top() {
        return new ArrayList<>(nStorage);
    }
}

public class TopN_Generic {
    public static void main(String[] args) {
        final NGeneric<Long> n = new NGeneric<>(3);
        LongStream.rangeClosed(1, 100).forEach(n::push);
        n.push(1L);
        n.push(98L);
        n.push(99L);
        n.push(100L);
        LongStream.rangeClosed(1, 100).forEach(n::push);
        n.push(4L);
        n.push(3L);

        System.out.println(n.top());
    }
}


