package Tuan12;

import java.util.Scanner;

public class b1 {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j));

                }

            }
        }
        System.out.println(max);


    }

    public static int xx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int yy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int dfs(int x, int y) {
        visit[x][y] = 1;
        int res=1;
        for (int i = 0; i < 8; i++) {
            int u = x + xx[i];
            int v = y + yy[i];

            if (u >= 0 && v >= 0 && u < n && v < m && grid[u][v]==1&& visit[u][v]==0){
                res+=dfs(u,v);


            }

        }
        return res;


    }
}
