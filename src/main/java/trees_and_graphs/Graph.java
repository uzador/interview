package trees_and_graphs;

import static trees_and_graphs.State.Unvisited;

class Graph<T> {
    private final GraphNode<T> root;

    public Graph(GraphNode<T> root) {
        this.root = root;
    }

    public void setUnvisited() {
        DFS(root);
    }

    private void DFS(final GraphNode<T> node) {
        if (node == null) return;

        node.state = Unvisited;

        for(final GraphNode<T> n : node.adjacent) {
            if (n.state != Unvisited) {
                DFS(n);
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "root=" + root +
                '}';
    }
}
