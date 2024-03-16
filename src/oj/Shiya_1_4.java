package oj;

import java.util.Scanner;
//无向图的最短路径
//求的是任意两点之间的最短路径，所以用floyd算法
public class Shiya_1_4 {
    public static int MaxValue = 100000;

    public static void floyd(int[][] e) {
        for(int i = 0; i < e.length; i++) {
            for(int j = 0; j < e.length; j++) {
                for(int k = 0; k <e.length; k++) {
                    if( e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//节点数
        int m = scanner.nextInt();//边数
        int k = scanner.nextInt();//查询次数
        int[][] matrix = new int[n][n];

        //初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = MaxValue;
            }
        }

        for(int i =0;i<m;i++){
            int t1 =scanner.nextInt();
            int t2 =scanner.nextInt();
            matrix[t1-1][t2-1]=1;
            matrix[t2-1][t1-1]=1;
        }
        floyd(matrix);
        for(int i =0 ;i<k;i++){
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            System.out.println(matrix[source-1][target-1]==MaxValue?"infinity":matrix[source-1][target-1]);
        }
    }
}
