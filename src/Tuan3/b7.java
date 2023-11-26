package Tuan3;

import java.util.Arrays;
import java.util.Scanner;

public class b7 {
    public static void threeSum(int[] a) {
        int n = a.length;
        Arrays.sort(a);

        for (int i = 0; i < n - 2; i++) {

            if (i == 0 || a[i] != a[i - 1]) {
                int number = -a[i];
                int l= i + 1;
                int r = n - 1;

                while (l< r) {
                    int sum = a[l] + a[r];

                    if (sum == number) {
                        System.out.println(a[i] + " " + a[l] + " " + a[r]);


                        while (l < r&& a[l] == a[l + 1]) {
                            l++;
                        }
                        while (l < r && a[r] == a[r - 1]) {
                            r--;
                        }

                        l++;
                        r--;
                    } else if (sum < number) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        threeSum(a);
    }
}

