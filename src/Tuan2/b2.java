package Tuan2;

import java.util.Scanner;

public class b2{
    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }


        int count = 0;


        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();


            if (!connected(p, q)) {
                union(p, q);
                count++;
            }


            if (allConnected(N)) {
                System.out.println(count);
                return;
            }
        }


        System.out.println("FAILED");
    }


    private static boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    private static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);


        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }


    private static int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }


    private static boolean allConnected(int N) {
        int root = find(0);
        for (int i = 1; i < N; i++) {
            if (find(i) != root) {
                return false;
            }
        }
        return true;
    }
}