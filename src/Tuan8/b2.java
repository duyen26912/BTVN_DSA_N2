package Tuan8;

import java.io.*;
import java.util.*;

public class b2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int i =0;
        while(i<A.length()-i){
            if(A.charAt(i) != A.charAt(A.length()-i-1)){
                System.out.println("No");
                return;
            }
            i++;
        }

        System.out.println("Yes");
    }
}




