package Tuan3;

import java.util.Scanner;
import java.util.Arrays;

public class b6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 1) {
            return;
        } else {
            int k = sc.nextInt();
            int[] a = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] - a[i] == k)
                        count++;
                    if (a[j] - a[i] > k)
                        break;
                }
            }
            System.out.println(count);
        }
    }
}
