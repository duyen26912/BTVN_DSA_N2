package Tuan3;

import java.util.Scanner;

public class b2 {
    private static int binary_search(int[] a, int number) {
        int low = 0;
        int hight = a.length - 1;
        while (low <= hight) {
            int mid = (hight - low) / 2 + low;
            if (a[mid] == number) {
                return mid;
            } else if (a[mid] < number) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[]a= new int[n];
        for(int i=0;i<n;i++){
            a[i]= sc.nextInt();
        }
        int number = sc.nextInt();
        int result = binary_search(a,number);
        System.out.println(result);
    }
}

