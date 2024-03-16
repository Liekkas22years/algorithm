package oj;

import java.util.Scanner;

public class Shiya_5_2 {
    public static long getCount(int n,int m,long[][] arr,int[][] index) {
        if(arr[n][m] == 1) {
            return arr[n][m];
        }
        if(index[n][m] == -1) {
            return 0;
        }
        if (n==0 | m==0) {
            return 1;
        }
        arr[n-1][m]=getCount(n-1,m,arr,index);
        arr[n][m-1]=getCount(n,m-1,arr,index);
        return arr[n-1][m]+arr[n][m-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] index = new int[21][21];
        long[][] arr = new long[21][21];
        for (int i = 0; i < k; i++) {
            int x,y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            index[x][y] = -1;
            arr[x][y] = 0;
        }
        if(index[0][0] == -1) {
            System.out.println(0);
        } else {
            System.out.println(getCount(n,m,arr,index));
        }
    }
}
