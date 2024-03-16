package leetcode.array;
//旋转图像
//先转置，再交换
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38, 在所有 Java 提交中击败了23.83%的用户
 */
public class L_48_1 {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int t;
        //数组转置
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    t=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=t;
                }
            }
        }
        //交换列
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                t=matrix[j][i];
                matrix[j][i]=matrix[j][n-i-1];
                matrix[j][n-i-1]=t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
    }
}
