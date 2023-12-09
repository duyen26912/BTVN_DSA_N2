package Tuan6;

import java.io.*;
import java.util.*;

public class b3{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i,j;
        int arr[]=new int[n];
        for(i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int temp=arr[n-1];
        for(i=n-2;i>=0;i--)
        {
            if(arr[i]>temp)
            {
                arr[i+1]=arr[i];
                for(j=0;j<n;j++)
                { System.out.print(arr[j]);
                    if(i!=n-1)
                        System.out.print(" ");
                }
            }
            else
                break;
            System.out.println();
        }
        arr[i+1]=temp;
        for(i=0;i<n;i++)
        {
            System.out.print(+arr[i]);
            if(i!=n-1)
                System.out.print(" ");
        }
    }
}

