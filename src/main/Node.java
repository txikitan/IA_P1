public class Node {
    private final State state;
    private final String path;
    private final float heuristicVal;

    public Node(State state, String path, float heuristicVal) {
        this.state = state;
        this.path = path;
        this.heuristicVal = heuristicVal;
    }
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
