package interview.top_n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

final class NThreadSafe {
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

    NThreadSafe(int n) {
        this.n = n;
        this.nStorage = new TreeSet<>(comparator);
    }

    synchronized void push(int value) {
        if (nStorage.contains(value)) {
            return;
        }

        if (nStorage.size() < n) {
            nStorage.add(value);
            return;
        }

        if (nStorage.size() == n) {
            final Integer lastElement = nStorage.last();

            if (lastElement > value) {
                return;
            }

            nStorage.remove(lastElement);
        }

        nStorage.add(value);
        notifyAll();
    }

    synchronized Collection<Integer> top() {
        while (nStorage.size() < n) {
            System.out.println("n = " + nStorage.size() + ", wait for a while");

            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("top throws exception: " + e);
                Thread.currentThread().interrupt();
            }
        }

        return new ArrayList<>(nStorage);
    }
}

class Updater implements Runnable {
    private final NThreadSafe n;
    private final String threadName = Thread.currentThread().getName();

    Updater(final NThreadSafe n) {
        this.n = n;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (Thread.interrupted()) {
                break;
            }

            n.push(++i);
            System.out.println("Thread " + threadName + " added " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Exception in " + threadName + " happened: " + e);
            }
        }
    }
}

public class TopN_ThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        final NThreadSafe n = new NThreadSafe(15);

        Thread t1 = new Thread(new Updater(n));
        Thread t2 = new Thread(new Updater(n));
        Thread t3 = new Thread(new Updater(n));

        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("1: " + n.top());

//        t1.interrupt();
//        t2.interrupt();
//        t3.interrupt();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("2: " + n.top());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("3: " + n.top());
    }
}


