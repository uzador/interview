package trees_and_graphs.simple_graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
    static void search(final GraphNode node) {
        final Queue<GraphNode> queue = new ArrayBlockingQueue<>(100);
        node.marked = true;
        queue.offer(node);

        while(!queue.isEmpty()) {
            final GraphNode n = queue.poll();
            if (visit(n)) {
                System.out.println("Node founded: " + n);
                return;
            }

            for(final GraphNode gn : n.adjacent) {
                if (!gn.marked) {
                    gn.marked = true;
                    queue.offer(gn);
                }
            }
        }
    }

    private static boolean visit(final GraphNode node) {
        return node.name.equals("12");
    }
}
