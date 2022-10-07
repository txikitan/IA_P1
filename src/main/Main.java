import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try(BufferedReader in = new BufferedReader(new FileReader("map.txt"))) {
            int i=0,xIni=0,yIni=0,xEnd=0,yEnd=0;
            String str = in.readLine();
            String[] tokens = str.split(",");
            int[][] map=new int[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
            str = in.readLine();
            tokens = str.split(",");
            xIni = Integer.parseInt(tokens[0]);
            yIni = Integer.parseInt(tokens[1]);
            str = in.readLine();
            tokens = str.split(",");
            xEnd = Integer.parseInt(tokens[0]);
            yEnd = Integer.parseInt(tokens[1]);
            while ((str = in.readLine()) != null) {
                tokens = str.split(",");
                for(int j=0;j<tokens.length;j++){
                        map[i][j] = Integer.parseInt(tokens[j]);
                }
                    i++;
            }

        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
   }
}
