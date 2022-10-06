import java.util.Comparator;

public class StateComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getHeuristicVal()==o2.getHeuristicVal()) return 0;
        return o1.getHeuristicVal() < o2.getHeuristicVal() ? -1 : 1;
    }
}
