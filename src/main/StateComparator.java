/**------------------------------------------
| IA Exercise 1. Informed Search
| Comparator for the priority queue sorting
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
import java.util.Comparator;

public class StateComparator implements Comparator<Node>{
    @Override
    // compare two nodes by its heuristic value, priority queue pending list management
    public int compare(Node o1, Node o2) {
        if(o1.getHeuristicVal()==o2.getHeuristicVal()) return 0;
        return o1.getHeuristicVal() < o2.getHeuristicVal() ? -1 : 1;
    }
}
