package interview.top_n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.IntStream;

class N {
    private final int n;
    private final TreeSet<Integer> nStorage;
    private final Comparator<Integer> comparator = (o1, o2) -> {
        if (o2 > o1) {
            return 1;
        } else if (o2.intValue() == o1.intValue()) {
            return 0;
        } else {
            return -1;
        }
    };

    N(int n) {
        this.n = n;
        this.nStorage = new TreeSet<>(comparator);
    }

    void push(int value) {
        if (nStorage.size() == n) {
            if (nStorage.contains(value)) {
                return;
            }

            final Integer lastElement = nStorage.last();
            if (lastElement < value) {
                nStorage.remove(lastElement);
            } else {
                return;
            }
        }

        nStorage.add(value);
    }

    Collection<Integer> top() {
        return new ArrayList<>(nStorage);
    }
}

public class TopN {
    public static void main(String[] args) {
        final N n = new N(3);
        IntStream.rangeClosed(1, 100).forEach(n::push);
        n.push(1);
        n.push(98);
        n.push(99);
        n.push(100);
        IntStream.rangeClosed(1, 100).forEach(n::push);

        System.out.println(n.top());
    }
}


