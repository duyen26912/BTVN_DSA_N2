package Tuan3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class b5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ar.add(sc.nextInt());
        }

        Collections.sort(ar);

        if (ar.size() <= 1) {
            return;
        } else {
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> b = new ArrayList<>();

            for (int i = 1; i < ar.size(); i++) {
                int signal = ar.get(i) - ar.get(i - 1);

                if (signal < min) {
                    min= signal;
                    b.clear();
                    b.add(ar.get(i - 1));
                    b.add(ar.get(i));
                } else if (signal == min) {
                    b.add(ar.get(i - 1));
                    b.add(ar.get(i));
                }
            }

            for (int i : b) {
                System.out.print(i + " ");
            }
        }

    }
}

