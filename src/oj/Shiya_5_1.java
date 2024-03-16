package oj;

import java.util.Scanner;

public class Shiya_5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int start = 0, l=0;
        int end = 0;
        int pre = arr[0], maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (pre + arr[i] >= arr[i]) {
                pre = pre + arr[i];
            } else {
                pre = arr[i];
                l=i;
            }
            if (maxSum < pre) {
                maxSum = pre;
                start = l;
                end = i;
            }
            //pre = Math.max(pre + arr[i], arr[i]);
            //maxAns = Math.max(maxAns, pre);
        }
        System.out.println(maxSum);
        System.out.println(start+1);
        System.out.println(end+1);
    }
}
