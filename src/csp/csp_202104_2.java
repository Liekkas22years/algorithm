package csp;

import java.util.Scanner;

//邻域均值
//超时 70分

public class csp_202104_2 {
    public static void fff() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        int r = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                a[i][j]=scanner.nextInt();
            }
        }

        int count=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int tVal=0;
                int tCount=0;
                for(int k=0;k<n;k++) {
                    for(int m=0;m<n;m++) {
                        if(Math.abs(k-i)<=r&&Math.abs(m-j)<=r) {
                            tVal+=a[k][m];
                            tCount++;
                        }
                    }
                }
                if(tVal*1.0/tCount<=t) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        fff();
    }
}
