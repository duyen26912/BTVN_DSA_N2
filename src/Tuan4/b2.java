package Tuan4;

import java.util.LinkedList;
import java.util.Scanner;
public class b2 {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        LinkedList <Integer> list = new LinkedList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        for(int x: list){
            System.out.println(x);
        }

    }

}
