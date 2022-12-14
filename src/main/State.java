/**------------------------------------------
| IA Exercise 1. Informed Search
| State and operators class
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
public class State {
    private final int pos_X;
    private final int pos_Y;
    private final int height;
    private final float time;  // Time to reach from the initial State

    public State(int pos_X, int pos_Y, float time, int height) {
        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        this.time = time;
        this.height = height;
    }


    public int getPos_X() {
        return pos_X;
    }

    public int getPos_Y() {
        return pos_Y;
    }

    public int getHeight() {
        return height;
    }

    public float getTime() {
        return time;
    }

    /* Operations */
    public State left(int[][] map){
        if( this.pos_Y-1 < 0 ||map[this.pos_X][this.pos_Y-1]==-1)return null; // check if we are moving outside the map
        int diferencia = map[this.pos_X][this.pos_Y-1]-this.height; // compute height difference
        float time=0;
        if(diferencia>=0) time+=1+diferencia;
        else time+=0.5;
        return new State(this.pos_X, this.pos_Y-1,this.time+time,map[this.pos_X][this.pos_Y-1]);
    }

    public State right(int[][] map){
        if(this.pos_Y+1>=map[0].length || map[this.pos_X][this.pos_Y+1]==-1) return null;
        int diferencia = map[this.pos_X][this.pos_Y+1]-this.height;
        float time=0;
        if(diferencia>=0) time+=1+diferencia;
        else time+=0.5;
        return new State(this.pos_X, this.pos_Y+1,this.time+time,map[this.pos_X][this.pos_Y+1]);
    }

    public State up(int[][] map){
        if(this.pos_X-1<0 || map[this.pos_X-1][this.pos_Y]==-1) return null;
        int diferencia = map[this.pos_X-1][this.pos_Y]-this.height;
        float time=0;
        if(diferencia>=0) time+=1+diferencia;
        else time+=0.5;
        return new State(this.pos_X-1, this.pos_Y,this.time+time,map[this.pos_X-1][this.pos_Y]);
    }

    public State down(int[][] map){
        if(this.pos_X+1>=map.length || map[this.pos_X+1][this.pos_Y]==-1) return null;
        int diferencia = map[this.pos_X+1][this.pos_Y]-this.height;
        float time=0;
        if(diferencia>=0) time+=1+diferencia;
        else time+=0.5;
        return new State(this.pos_X+1, this.pos_Y,this.time+time,map[this.pos_X+1][this.pos_Y]);
    }


    // To check if a state is equal except for the time (pending list management)
    public boolean partialEquals(State s2){
        if(s2==null)return false;
        return this.pos_X == s2.getPos_X() && this.pos_Y == s2.getPos_Y() && this.height == s2.getHeight();
    }

    // checks if two states are fully equal
    public boolean equals(State s2){
        if(s2==null)return false;
        return this.pos_X == s2.getPos_X() && this.pos_Y == s2.getPos_Y() && this.height == s2.getHeight() && this.time == s2.getTime();
    }


}
