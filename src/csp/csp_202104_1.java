package csp;

import java.util.Scanner;

//灰度直方图
public class csp_202104_1 {
    public static void fff() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        int[][] a = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                a[i][j]=scanner.nextInt();
            }
        }
        int[] t=new int[l];
        for(int i=0;i<l;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<m;k++) {
                    if(a[j][k]==i) {
                        t[i]++;
                    }
                }
            }
        }
        for(int i=0;i<t.length;i++) {
            System.out.print(t[i]+ " ");
        }
    }

    public static void main(String[] args) {
        fff();
    }
}
