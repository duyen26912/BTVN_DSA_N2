package Tuan13;

import java.io.*;
import java.util.*;

public class b2 {


    static int[][] matrix;
    static Set<Integer> visited;
    static boolean[] vis;
    static int minEdge;
    static int min = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodesCount = scanner.nextInt();
        matrix = new int[nodesCount + 1][nodesCount + 1];
        int edgesCount = scanner.nextInt();
        visited = new HashSet<>();
        vis = new boolean[nodesCount + 1];
        for (int i = 0; i < edgesCount; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int weight = scanner.nextInt();
            matrix[source][target] = weight == 0 ? -1 : weight;
            matrix[target][source] = weight == 0 ? -1 : weight;
        }
        int start = scanner.nextInt();
        visited.add(start);
        vis[start] = true;
        long sum = 0;
        while (visited.size() != nodesCount) {
            minEdge = 0;
            min = Integer.MAX_VALUE;

            for (Integer in : visited) {

                getNeighbours(in);
            }

            if (min == -1) {
                min = 0;
            }
            sum += min;

            visited.add(minEdge);
            vis[minEdge] = true;

        }
        System.out.println(sum);
    }

    static void getNeighbours(int node) {
        for (int in = 0; in < matrix[node].length; in++) {
            if (in != 0 && in != node) {
                if (!vis[in] && matrix[node][in] != 0) {
                    if (min > matrix[node][in]) {
                        minEdge = in;
                        min = matrix[node][in];
                        if (matrix[node][in] == -1) {
                            break;
                        }
                    }
                }
            }
        }
    }
}




