/**------------------------------------------
| IA Exercise 1. Informed Search
| Class to define and apply heuristics
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
import java.io.IOException;

public class Heuristics {
    private final int num; // number of the heuristic that wants to be applied

    public Heuristics(int num) throws IOException { // constructor to check if number is in the correct range
        if(num<1 || num>3) throw new IOException();
        else this.num=num;
    }
    // Method to apply the corresponding num heuristic
    public float Apply(State s1, State sFinal){
        if(this.num==1) return h1(s1,sFinal);
        if(this.num==2) return h2(s1,sFinal);
        return h3(s1,sFinal);
    }

    // 1st heuristic: Classic euclidean distance
    private float h1(State s1, State sFinal){
        float x1 = s1.getPos_X();
        float x2 = sFinal.getPos_X();
        float y1 = s1.getPos_Y();
        float y2 = sFinal.getPos_Y();
        return (float)(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
    }

    // 2nd heuristic: Minimum distance difference in one axis
    private float h2(State s1, State sFinal){
        float x1 = s1.getPos_X();
        float x2 = sFinal.getPos_X();
        float y1 = s1.getPos_Y();
        float y2 = sFinal.getPos_Y();
        return Math.min((x1-x2),(y1-y2));
    }

    // 3rd heuristic: Angle
    private float h3(State s1, State sFinal){
        int xIni = s1.getPos_X();
        int xEnd = sFinal.getPos_X();
        int yIni = s1.getPos_Y();
        int yEnd = sFinal.getPos_Y();
        float angle = (float) Math.toDegrees(Math.atan2(yEnd - yIni, xEnd - xIni));
        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
}
