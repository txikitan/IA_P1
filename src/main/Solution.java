public class Solution {
    private final String path;
    private final int numNodes;
    private final boolean correct;

    public Solution(String path, int numNodes, boolean correct) {
        this.path = path;
        this.numNodes = numNodes;
        this.correct = correct;
    }

    public String getPath() {
        return path;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public boolean isCorrect() {
        return correct;
    }
}
