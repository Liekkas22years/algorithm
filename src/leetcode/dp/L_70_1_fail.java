package leetcode.dp;
//爬楼梯
/*
未通过，n=45时失败
 */
public class L_70_1_fail {
    public static int climbStairs(int n) {
        int c = n/2;
        long t=1;
        for(int i=0;i<c;i++){
            t= (int) (t+pailie(n-1,i+1));
            n=n-1;
        }
        return (int) t;
    }

    public static long pailie(int n,int m){
        if(m>n/2){
            m=n-m;
        }
        long t=1;
        long w=1;

        for(int j=1;j<=m;j++){

            w=w*j;
        }

        int flag=0;
        for(int i=n;i>=n-m+1;i--){
            t=t*i;
            if(t%w==0&&flag==0){
                t=t/w;
                flag=1;
            }
        }

        return t;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
