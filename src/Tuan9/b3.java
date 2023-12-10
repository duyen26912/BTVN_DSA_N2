package Tuan9;

import java.io.*;
import java.util.*;

public class b3{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner (System.in);
        Set<String> set = new HashSet<>();
        int T = sc.nextInt();
        sc.nextLine();

        while(T-->0){
            String first = sc.next();
            String second = sc.next();
            String connect = first + " " + second;
            set.add(connect);
            System.out.println(set.size());
        }

    }
}
