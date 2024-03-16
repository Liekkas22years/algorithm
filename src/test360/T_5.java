package test360;

import java.util.Scanner;

public class T_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int R = scanner.nextInt();
        int[][] arr = new int[n][m];
        int xt =0;
        int yt =0;
        int[] arr1 = new int[m];
        for (int i = 0; i < n; i++) {
            int t=scanner.nextInt();
            arr1[0] = t/10000;
            arr1[1] = (t/1000)%10;
            arr1[2] = (t/100)%10;
            arr1[3] = (t/10)%10;
            arr1[4] = t%10;
            for (int j = 0; j < m; j++) {
                arr[i][j] = arr1[j];
                if(arr[i][j]==2){
                    xt =i;yt=j;
                }
            }
        }
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0 && (Math.abs(i-xt)+Math.abs(j-yt))<=R){
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if(arr[k][l]==1 && (Math.abs(i-k)+Math.abs(j-l))<=R ){
                                flag=false;
                            }
                        }
                    }
                    if (flag){
                        count++;
                    }
                    flag = true;
                }
            }
        }
        System.out.print(count);
    }
}

//4 5 2
//        0 1 0 0 0
//        0 0 0 1 0
//        0 0 2 0 0
//        0 0 0 0 1