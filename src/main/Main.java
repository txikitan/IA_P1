/**------------------------------------------
| IA Exercise 1. Informed Search
| Main class
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        // Read input config file, first line will be dimension,
        // second line will be xini and yini
        // third line will be xfin and yfin
        // fourth+ lines correspond to the map by itself
        try(BufferedReader in = new BufferedReader(new FileReader("map.txt"))) {
            String str = in.readLine();
            String[] tokens = str.split(",");
            int[][] map=new int[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
            str = in.readLine();
            tokens = str.split(",");
            int xIni = Integer.parseInt(tokens[0]);
            int yIni = Integer.parseInt(tokens[1]);
            str = in.readLine();
            tokens = str.split(",");
            int xEnd = Integer.parseInt(tokens[0]);
            int yEnd = Integer.parseInt(tokens[1]);
            int i = 0;
            while ((str = in.readLine()) != null) {
                tokens = str.split(",");
                for(int j=0;j<tokens.length;j++){
                        map[i][j] = Integer.parseInt(tokens[j]);
                }
                    i++;
            }
            // call the best first search algorithm
            Solution sol = BestFirst.BestFirsSearch(map,xIni,yIni,xEnd,yEnd,1);
            System.out.println("Finished!");
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
   }
}
