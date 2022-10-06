import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestFirst {
    public static Solution BestFirstSearch(int[][] map, int xIni,int yIni, int xEnd,int yEnd) {
        PriorityQueue<Node> pending = new PriorityQueue<>(new StateComparator());
        ArrayList<Node> handled = new ArrayList<>();
        boolean found = false;
        pending.add(new Node(new State(xIni,yIni,0,map[xIni][yIni]),"",0));
        State finalState = new State(xEnd,yEnd,0,map[xEnd][yEnd]);
        while(!found && pending.size()!=0){

        }

        return null;
    }
}
