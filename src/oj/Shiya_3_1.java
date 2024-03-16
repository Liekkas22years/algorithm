package oj;

import java.util.Arrays;
import java.util.Scanner;

public class Shiya_3_1 {
    public static void quickSort(int[] arr,int l,int r,int k) {
        if(l>=r) {
            return;
        }
        int left = l;
        int right = r;
        int temp = arr[left];

        while (left != right) {
            while (right > left && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (right > left && arr[left] < temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = temp;
        if (k<right)
            quickSort(arr, l, left - 1, k);
        else if(k>right)
            quickSort(arr, right + 1, r, k);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr,0,n-1,n-k);
        System.out.println(arr[n-k]);
        //Integer.MAX_VALUE;
    }
}
