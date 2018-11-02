package trees_and_graphs;

import java.lang.reflect.Array;
import java.util.Arrays;

import static trees_and_graphs.State.Unvisited;

public class GraphNode<T> {
    public final T value;
    public GraphNode<T>[] adjacent;
    public State state;


    public GraphNode(T value) {
        this.value = value;
        this.adjacent = (GraphNode<T>[]) Array.newInstance(GraphNode.class, 0);
        this.state = Unvisited;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                ", value=" + value +
                ", state=" + state +
                ", adjacent=" + Arrays.toString(adjacent) +
//                ", adjacent=" + adjacent +
                '}';
    }
}
