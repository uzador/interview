package trees_and_graphs.simple_graph;

public class GraphApp {
    public static void main(String[] args) {
        final GraphNode n = new GraphNode("1");

        final GraphNode n1 = new GraphNode("2");
        final GraphNode n2 = new GraphNode("3");
        final GraphNode n3 = new GraphNode("4");

        final GraphNode n31 = new GraphNode("5");
        final GraphNode n32 = new GraphNode("6");

        final GraphNode n21 = new GraphNode("7");
        final GraphNode n22 = new GraphNode("8");
        final GraphNode n23 = new GraphNode("9");

        final GraphNode n311 = new GraphNode("11");
        final GraphNode n312 = new GraphNode("12");

        n.adjacent = new GraphNode[]{n1, n2, n3};
        n2.adjacent = new GraphNode[]{n21, n22, n23};
        n3.adjacent = new GraphNode[]{n31, n32};
        n31.adjacent = new GraphNode[]{n311, n312};

        BFS.search(n);
    }
}
