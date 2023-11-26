

import java.util.Arrays;
import java.util.Scanner;

public class b4 {
    public static void threeSum(int a[], int n) {
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            for (int k = n - 1; k > i + 1; k--){
                while(j<k){
                    if(a[i]+a[j]+a[k]==0){
                        System.out.println(a[i] + " " +a[j] + " "+ a[k]);
                        break;

                    }
                    else if(a[i]+a[j]+a[k]<0){
                        j++;
                    }else{
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int [n];
        for(int i=0;i<n;i++){
            a[i]= sc.nextInt();
        }
        Arrays.sort(a);
        threeSum(a,n);

    }
}
