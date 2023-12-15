package Tuan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class b3
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in=new FastReader();//creating the object
        int t1=in.nextInt();//taking input of the number of testcases to be solved
        for(int gj=0;gj<t1;gj++){//taking input of hte odes ad edges
            int n=in.nextInt();
            int m=in.nextInt();
            long w[][]=new long [n+1][n+1];
            for (long[] row: w)
                Arrays.fill(row, 1000000l);
            IntStream.range (0, m).forEach (i -> {
                int x = in.nextInt (), y = in.nextInt ();
                long cmp = in.nextLong ();
                if (w[x][y] > cmp) {
                    w[x][y] = cmp;
                    w[y][x] = cmp;
                }
            });
            Stack <Integer> t=new Stack<Integer>();
            int src=in.nextInt();
            for(int i=1;i<=n;i++){
                if(i!=src){t.push(i);}}
            Stack <Integer> p=new Stack<Integer>();
            p.push(src);
            w[src][src]=0;
            if (!t.isEmpty ()) {
                do {
                    int min = 989997979, loc = -1;
                    for (int i = 0; i < t.size (); i++) {
                        w[src][t.elementAt (i)] = Math.min (w[src][t.elementAt (i)], w[src][p.peek ()] + w[p.peek ()][t.elementAt (i)]);
                        if (w[src][t.elementAt (i)] <= min) {
                            min = (int) w[src][t.elementAt (i)];
                            loc = i;
                        }
                    }
                    p.push (t.elementAt (loc));
                    t.removeElementAt (loc);
                } while (!t.isEmpty ());
            }
            int i=1;
            while (i<=n) {
                if(i!=src && w[src][i]!=1000000l){System.out.print(w[src][i]+" ");}
                else if(i!=src){System.out.print("-1"+" ");}
                i++;
            }
            System.out.println();
        }
    }}