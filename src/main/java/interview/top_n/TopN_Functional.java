package interview.top_n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

class NFunctional implements Consumer<Integer>, Supplier<Collection<Integer>> {
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

    NFunctional(int n) {
        this.n = n;
        this.nStorage = new TreeSet<>(comparator);
    }

    @Override
    public void accept(Integer value) {
        push(value);
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

    @Override
    public Collection<Integer> get() {
        return top();
    }

    Collection<Integer> top() {
        return new ArrayList<>(nStorage);
    }
}

public class TopN_Functional {
    public static void main(String[] args) {
        final NFunctional n = new NFunctional(3);

        IntStream.rangeClosed(1, 100).forEach(n::accept);
        n.accept(1);
        n.accept(98);
        n.accept(99);
        n.accept(100);
        IntStream.rangeClosed(1, 100).forEach(n::accept);

        System.out.println(n.get());
    }
}


