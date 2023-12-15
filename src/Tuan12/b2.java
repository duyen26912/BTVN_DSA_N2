package Tuan12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> dist = new ArrayList<>();
        IntStream.range(0,n+1).forEach(x -> dist.add(-1));
        int graph[][]= new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            graph[a][b]=6;
            graph[b][a]=6;
        }
        boolean vs[]= new boolean[n+1];
        vs[0]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vs[s]=true;
        while (!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<n+1;i++){
                if (!vs[i] && graph[node][i]!=0){
                    q.add(i);
                    vs[i]=true;
                    if (dist.get(node)==-1){
                        dist.set(i,graph[node][i]);
                    } else{
                        dist.set(i,dist.get(node)+graph[node][i]);
                    }
                }
            }
        }
        dist.remove(s);
        dist.remove(0);
        return dist;

    }

}

public class b2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
