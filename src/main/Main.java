/**------------------------------------------
| IA Exercise 1. Informed Search
| Main class
| Gabriel Garcia Rodriguez
|-------------------------------------------*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean fi = false;
        // Read input config file, first line will be dimension,
        // second line will be xini and yini
        // third line will be xfin and yfin
        // fourth+ lines correspond to the map by itself

        while (!fi) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Mapa 1 o 2?");
            int nMap = sc.nextInt();
            while (nMap != 1 && nMap != 2) {
                System.out.println("Error, introdueix de nou:");
                nMap = sc.nextInt();
            }
            try (BufferedReader in = new BufferedReader(new FileReader("map" + nMap + ".txt"))) {
                String str = in.readLine();
                String[] tokens = str.split(",");
                int[][] map = new int[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
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
                    for (int j = 0; j < tokens.length; j++) {
                        map[i][j] = Integer.parseInt(tokens[j]);
                    }
                    i++;
                }
                // call the desired algorithm
                System.out.println("BFS o A* (1 or 2)?");
                int nAlgorithm = sc.nextInt();
                while (nAlgorithm != 1 && nAlgorithm != 2) {
                    System.out.println("Error, introdueix de nou:");
                    nAlgorithm = sc.nextInt();
                }
                System.out.println("Heuristica 1, 2 or 3?");
                int nHeur = sc.nextInt();
                while (nHeur != 1 && nHeur != 2 && nHeur != 3) {
                    System.out.println("Error, introdueix de nou:");
                    nHeur = sc.nextInt();
                }
                Solution sol;
                if (nAlgorithm == 1) {
                    sol = BestFirst.BestFirsSearch(map, xIni, yIni, xEnd, yEnd, nHeur);
                    System.out.println("BFS:\n Cami: " + sol.getPath() + "\n Num. Nodes: " + sol.getNumNodes() + "\n Temps: " + sol.getTime() +
                            "\n Heuristica: "+nHeur+"\n Mapa: "+nMap);
                }
                if (nAlgorithm == 2) {
                    sol = Astar.AStarSearch(map, xIni, yIni, xEnd, yEnd, nHeur);
                    System.out.println("A*:\n Cami: " + sol.getPath() + "\n Num. Nodes: " + sol.getNumNodes() + "\n Temps: " + sol.getTime() +
                            "\n Heuristica: "+nHeur+"\n Mapa: "+nMap);
                }

                System.out.println("Vols tornar a repetir amb altra configuracio? (1-Si 2-No)");
                int end = sc.nextInt();
                while (end != 1 && end != 2) {
                    System.out.println("Error, introdueix de nou:");
                    end = sc.nextInt();
                }
                if(end == 2) fi = true;
            } catch (IOException e) {
                System.out.println("File Read Error");
            }

        }
        System.out.println("Finished!");
    }
}
