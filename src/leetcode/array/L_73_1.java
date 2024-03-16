package leetcode.array;

public class L_73_1 {
    public static void setZeroes(int[][] matrix) {
        int l1=matrix.length;//行数
        int l2=matrix[0].length;//列数
        boolean flag=false;
        boolean flag_inner=false;
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if((long)matrix[i][j]==0){
                    for(int k=0;k<l2;k++){
                        if(matrix[i][k]==(int) Math.pow(2,31)){
                            flag_inner=true;
                        }
                        if(matrix[i][k]!=0){
                            matrix[i][k]= (int) Math.pow(2,31);
                            flag=true;
                        }

                    }
                    for(int t=0;t<l1;t++){
                        if(matrix[t][j]==(int) Math.pow(2,31)){
                            flag_inner=true;
                        }
                        if(matrix[t][j]!=0){
                            matrix[t][j]= (int) Math.pow(2,31);
                            flag=true;
                        }
                    }
                }
            }
        }
        if (flag){
            for(int i=0;i<l1;i++){
                for(int j=0;j<l2;j++){
                    if(matrix[i][j]==(int) Math.pow(2,31)){
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int a[][]={
                {-2147483648}, {2},{3}};
        int b[][]={
                {2147483647}, {2},{3}};
        int c[][]={
                {1,1,1}, {1,0,1},{1,1,1}};
        int d[][]={
                {-4,-2147483648,6,-7,0}, {-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        setZeroes(d);
    }
}
