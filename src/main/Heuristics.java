import java.io.IOException;

public class Heuristics {
    private final int num;

    public Heuristics(int num) throws IOException {
        if(num<1 || num>3) throw new IOException();
        else this.num=num;
    }
    public float Apply(State s1, State sFinal,int[][]map){
        if(this.num==1) return h1(s1,sFinal,map);
        if(this.num==2) return h2(s1,sFinal,map);
        return h3(s1,sFinal,map);
    }
    private float h1(State s1, State sFinal,int[][]map){
        return 0;
    }
    private float h2(State s1, State sFinal,int[][]map){
        return 0;
    }
    private float h3(State s1, State sFinal,int[][]map){
        return 0;
    }
}
