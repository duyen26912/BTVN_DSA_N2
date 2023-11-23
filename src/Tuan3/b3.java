package Tuan3;

import java.util.Scanner;

public class b3 {
    static String balancedSums(int[] arr) {
        int x = arr.length;
        int arrSum = 0;
        for (int i = 0; i < x; i++) {
            arrSum += arr[i];
        }
        int rightSum = 0;
        int leftSum = 0;

        for (int i = 0; i < x; i++) {
            rightSum = arrSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return "YES";
            }

            leftSum += arr[i];
        }


        return"NO";

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[100000];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(balancedSums(arr));
        }


    }
}
