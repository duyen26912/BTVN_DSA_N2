package Tuan5;

import java.io.*;
import java.util.*;

public class b4 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        Stack<String> undoStack= new Stack<>();
        int q= sc.nextInt();
        for(int i=0;i<q;i++){
            int operation = sc.nextInt();
            switch(operation){
                case 1:
                    String appendString= sc.next();
                    undoStack.push(text.toString());
                    text.append(appendString);
                    break;
                case 2:
                    int k= sc.nextInt();
                    undoStack.push(text.toString());
                    text.delete(text.length()-k, text.length());
                    break;
                case 3:
                    int index = sc.nextInt();
                    System.out.println(text.charAt(index-1));
                    break;
                case 4:
                    if(!undoStack.isEmpty()){
                        text = new StringBuilder(undoStack.pop());
                    }
                    break;
            }
        }
        sc.close();
    }
}
