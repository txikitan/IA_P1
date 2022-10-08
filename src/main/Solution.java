/**------------------------------------------
| IA Exercise 1. Informed Search
| Class that defines the solution datatype
| that each search algorithm will return
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
public class Solution {
    private final String path; // path to reach final state
    private final int numNodes;  // number of iterations
    private final float time; // time to reach final state

    // constructor
    public Solution(String path, int numNodes, float time) {
        this.path = path;
        this.numNodes = numNodes;
        this.time = time;
    }

    // getters
    public String getPath() {
        return path;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public float getTime() {
        return time;
    }
}
