package Tuan4;

import java.util.LinkedList;
import java.util.Scanner;
public class b1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> num = new LinkedList<>();
        for(int i =0;i<n;i++){
            num.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            System.out.print(num.get(i));
        }

    }
}

