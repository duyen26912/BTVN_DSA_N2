package Tuan4;
import java.util.LinkedList;
import java.util.Scanner;
public class b3 {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList <Integer> list = new LinkedList<Integer>();

        for(int i=0;i<n;i++){
            list.addFirst(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            System.out.println(list.get(i));
        }

    }

}

