public class Solution {
    private final String path;
    private final int numNodes;
    private final float time;

    public Solution(String path, int numNodes, float time) {
        this.path = path;
        this.numNodes = numNodes;
        this.time = time;
    }

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
