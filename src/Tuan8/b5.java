package Tuan8;

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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        ArrayList<Double> list = new ArrayList<>();
        PriorityQueue<Integer> pqmin = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqmax= new PriorityQueue<>();
        for(int i=0;i<a.size();i++)
        {
            int num=a.get(i);
            if(pqmin.size()==0)
            {
                pqmin.add(num);
            }
            else if(pqmin.peek()<num)
            {
                pqmax.add(num);
            }
            else
            {
                pqmin.add(num);
            }
            if(pqmax.size()>pqmin.size())
            {
                int res =pqmax.poll();
                pqmin.add(res);
            }
            while(pqmin.size()-pqmax.size()>1)
            {
                int res=pqmin.poll();
                pqmax.add(res);
            }
            if(pqmin.size()==pqmax.size())
            {
                list.add((pqmin.peek()+pqmax.peek())/(2.0));
            }
            else
            {
                list.add(1.0*pqmin.peek());
            }
        }
        return list;


    }

}

public class b5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
