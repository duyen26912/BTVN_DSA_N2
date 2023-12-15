package Tuan7;

import java.util.*;

public class b6 {
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        int temp = arr[j];
        arr[j] = arr[high];
        arr[high] = temp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return j;

    }

    static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }




    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, n - 1);
    }
}
