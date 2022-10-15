/**-------------------------------------------
| IA Exercise 1. Informed Search
| Node class, each node will represent a slot
| of the pending queue in the search algorithms
| Gabriel Garcia Rodriguez
|--------------------------------------------*/
import java.util.Queue;
public class Node {
    private final State state;
    private final String path; // path to reach current state since initial state
    private final float heuristicVal; // value of the heuristic function applied to the state

    // Constructor
    public Node(State state, String path, float heuristicVal) {
        this.state = state;
        this.path = path;
        this.heuristicVal = heuristicVal;
    }

    /*Method that checks partially if a list of nodes has a node with same position and height */
    public static boolean checkDuplicates (Queue<Node> list, Node n) {
        for(Node i : list) {
            if (i.getState().partialEquals(n.getState())) {
                return true;
            }
        }
        return false;
    }
    // getters
    public State getState() {
        return state;
    }

    public String getPath() {
        return path;
    }

    public float getHeuristicVal() {
        return heuristicVal;
    }
}
