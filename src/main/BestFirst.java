import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirst {

    static class NoDuplicatesPriorityQueue<Node> extends PriorityQueue<Node> {
        public NoDuplicatesPriorityQueue(Comparator<? super Node> comparator) {
            super(comparator);
        }
        public boolean add(Node e) {
            boolean isAdded = false;
            if (!super.contains(e)) {
                isAdded = super.add(e);
            }
            return isAdded;
        }
    }
    public static Solution BestFirsSearch(int[][] map, int xIni,int yIni, int xEnd,int yEnd, int hNum) throws IOException {
        NoDuplicatesPriorityQueue<Node> pending = new NoDuplicatesPriorityQueue<>(new StateComparator());
        ArrayList<Node> handled = new ArrayList<>();
        boolean found = false;
        pending.add(new Node(new State(xIni,yIni,0,map[xIni][yIni]),"",0));
        State finalState = new State(xEnd,yEnd,0,map[xEnd][yEnd]);
        int nodeCount = 0;
        Solution sol = null;
        while(!found && pending.size()!=0){
            nodeCount++;
            Node actualNode = pending.peek();
            pending.remove();
            if(actualNode.getState().equals(finalState)){
                found=true;
                sol = new Solution(actualNode.getPath(), nodeCount,
                        actualNode.getState().getTime());
            }
            else {
                ArrayList <State> successors = new ArrayList<>();
                State leftState = actualNode.getState().left(map);
                if(leftState!=null)successors.add(leftState);
                State rightState = actualNode.getState().right(map);
                if(rightState!=null)successors.add(rightState);
                State upState = actualNode.getState().up(map);
                if(upState!=null)successors.add(upState);
                State downState = actualNode.getState().down(map);
                if(downState!=null)successors.add(downState);
                for(State i : successors){
                    String newPath = actualNode.getPath();
                    if(i.equals(leftState))newPath+="left,";
                    else if(i.equals(rightState))newPath+="right,";
                    else if(i.equals(upState))newPath+="up,";
                    else if(i.equals(downState))newPath+="down,";
                    Heuristics hX = new Heuristics(hNum);
                    float heuristicVal = hX.Apply(i,finalState,map);
                    Node newNode = new Node(i,newPath,heuristicVal);
                    if(!handled.contains(newNode)&& !pending.contains(newNode)){
                        pending.add(newNode);
                    }
                }
                handled.add(actualNode);
            }
        }
        return sol; // will be null if not found
    }
}
