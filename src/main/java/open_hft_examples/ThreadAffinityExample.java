package open_hft_examples;

import net.openhft.affinity.Affinity;
import net.openhft.affinity.AffinityLock;

public class ThreadAffinityExample {
    private static final long COUNT = 200_000;

    public static void main(String[] args) {
        System.err.println("Number of available processors: "
                + Runtime.getRuntime().availableProcessors());

        try (final AffinityLock al = AffinityLock.acquireCore()) {
            final int threadId = Affinity.getThreadId();
            final int cpuId =  Affinity.getCpu();

            int i = 0;
            while (i < COUNT) {
                System.out.println(i + " CPU: " + cpuId + " and thread: " + threadId);
                i++;
            }

            System.out.println("Done!");
        }
    }
}
