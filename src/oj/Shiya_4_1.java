package oj;

import java.util.Scanner;

public class Shiya_4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        min = sum;
        for (int i = m; i < n; i++) {
            sum = sum - arr[i - m] + arr[i];
            min = sum < min ? sum : min;
        }
        System.out.println(min);
    }
}
