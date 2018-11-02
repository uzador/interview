package trees_and_graphs.simple_graph;

import java.util.Arrays;

class GraphNode {
    String name;
    boolean marked;
    GraphNode[] adjacent;

    GraphNode(String name) {
        this.name = name;
        this.adjacent = new GraphNode[0];
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", marked=" + marked +
                ", adjacent=" + Arrays.toString(adjacent) +
                '}';
    }
}
