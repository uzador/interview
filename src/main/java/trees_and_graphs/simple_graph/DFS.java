package trees_and_graphs.simple_graph;

class DFS {
    static void search(final GraphNode node) {
        if (node == null) return;

        if (visit(node)) {
            System.out.println("Node founded: " + node);
            return;
        }
        node.marked = true;

        for(final GraphNode n : node.adjacent) {
            if (!n.marked) {
                search(n);
            }
        }
    }

    private static boolean visit(final GraphNode node) {
        return node.name.equals("12");

    }
}
