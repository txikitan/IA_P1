public class State {
    private final int pos_X;
    private final int pos_Y;

    public State(int pos_X, int pos_Y) {
        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
    }


    public int getPos_X() {
        return pos_X;
    }


    public int getPos_Y() {
        return pos_Y;
    }

    /* Operations */
    public State up(int[][] map){
        return null;
    }

    public State down(int[][] map){
        return null;
    }

    public State left(int[][] map){
        return null;
    }

    public State right(int[][] map){
        return null;
    }
}
