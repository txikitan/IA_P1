/**------------------------------------------
| IA Exercise 1. Informed Search
| BestFirst Algorithm implemented
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
import java.io.IOException;
import java.util.*;

public class BestFirst {

    /*Method that checks partially if a list has a node with same position and height */
    private static boolean checkDuplicates (Queue<Node> list,Node n) {
        for(Node i : list) {
            if (i.getState().partialEquals(n.getState())) {
                return true;
            }
        }
        return false;
    }

    // The main search method
    public static Solution BestFirsSearch(int[][] map, int xIni,int yIni, int xEnd,int yEnd, int hNum) throws IOException {
        // Declare the pending sorted queue(accepts duplicates) and the handled list
        Queue<Node> pending = new PriorityQueue<>(new StateComparator());
        Queue<Node> handled = new LinkedList<>();
        boolean found = false;// Final state found
        // Create and add the initial state to the pending queue and just create the final state
        pending.add(new Node(new State(xIni,yIni,0,map[xIni][yIni]),"",0));
        State finalState = new State(xEnd,yEnd,0,map[xEnd][yEnd]);
        int nodeCount = 0;// Counter for the number of iterations (provided in the solution)
        Solution sol = null;
        while(!found && pending.size()!=0){
            nodeCount++;
            Node actualNode = pending.peek();// Get first node of the sorted queue
            pending.remove(); // Remove first node of the sorted queue
            if(actualNode.getState().partialEquals(finalState)){ // if it's equal to the final state we're done
                found=true;
                sol = new Solution(actualNode.getPath(), nodeCount,
                        actualNode.getState().getTime()); // path, number of nodes counted and time are the sol
            }
            else { // if we haven't reached solution yet
                // Apply all operations to the current state
                ArrayList <State> successors = new ArrayList<>();
                State leftState = actualNode.getState().left(map);
                if(leftState!=null)successors.add(leftState);// if its not null (was able to apply op) we add to successors list
                State rightState = actualNode.getState().right(map);
                if(rightState!=null)successors.add(rightState);
                State upState = actualNode.getState().up(map);
                if(upState!=null)successors.add(upState);
                State downState = actualNode.getState().down(map);
                if(downState!=null)successors.add(downState);
                for(State i : successors){// apply the heuristic to all the successor states and create the corresponding node
                    String newPath = actualNode.getPath();
                    if(i.equals(leftState))newPath+="left,";
                    else if(i.equals(rightState))newPath+="right,";
                    else if(i.equals(upState))newPath+="up,";
                    else if(i.equals(downState))newPath+="down,";
                    Heuristics hX = new Heuristics(hNum);
                    float heuristicVal = hX.Apply(i,finalState,map);
                    Node newNode = new Node(i,newPath,heuristicVal);
                    // Check for duplicates before adding (bestFirst does NOT accept duplicates)
                    if(!checkDuplicates(pending, newNode) && !checkDuplicates(handled, newNode)){
                        pending.add(newNode); // add it to the pending list
                    }
                }
                handled.add(actualNode); // the actual node is now handled
            }
        }
        return sol; // will be null if not found
    }
}
