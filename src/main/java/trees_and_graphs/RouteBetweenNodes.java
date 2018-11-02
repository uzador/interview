package trees_and_graphs;

import java.util.LinkedList;

import static trees_and_graphs.State.Unvisited;
import static trees_and_graphs.State.Visited;
import static trees_and_graphs.State.Visiting;

public class RouteBetweenNodes {
    boolean search(final Graph<String> g, final GraphNode<String> start, final GraphNode<String> end) {
        if (start == end) {
            return true;
        }

        final LinkedList<GraphNode<String>> q = new LinkedList<>();
        g.setUnvisited();
        start.state = Visiting;
        q.add(start);

        GraphNode<String> u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (GraphNode<String> v : u.adjacent) {
                    if (v.state == Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = Visited;
            }
        }

        return false;
    }
}
