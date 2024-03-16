package leetcode;

import java.util.Arrays;
//Boats to Save People
//在暴力法的基础上做了优化，减少二次循环的次数，但还是远远低于平均水平，因为O(n)=n*n
/*执行结果：
        通过
        显示详情
        添加备注

        执行用时：22 ms, 在所有 Java 提交中击败了6.19%的用户
        内存消耗：46.9 MB, 在所有 Java 提交中击败了92.50%的用户
        通过测试用例：78 / 78

 */
public class L_881_2 {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int k=0;
        if(people.length==1){
            return 1;
        }
        if(people.length==2) {
            if (limit - people[0] >= people[1]) {
                return 1;
            }
            else{
                return 2;
            }
        }
        int a[] =new int[people.length];

        int i,j,t=0;
        /*一开始j的值设为数组的长度减一，当进入循环之后，
        j的值可以设置为从上一次退出循环的值
         */
        int flag=0;//用flag判断是否进入过循环
        for (i = 0; i < people.length; i++) {
            if ((people[i]>Math.ceil(limit/2.0)) && a[i]==0) {
                k++;
                a[i]=1;
            }
            else if(a[i]==1){
                continue;
            }
            else{
                if(flag==0){
                    t=people.length-1;
                }

                for(j =t;j>i;j--){
                    if(people[i]+people[j]<=limit && a[j]==0){
                        k++;
                        a[i]=1;
                        a[j]=1;
                        t=j;//进入过循环，j下次取值就为上次退出的值
                        flag=1;
                        break;
                    }
                }
                if(i==j){
                    k++;
                    a[i]=1;
                }
            }
        }
        System.out.println(k);
        return k;
    }

    public static void main(String[] args) {
        int[] a ={68,88,50,92,33,50,50,68,21,61,22,35,97,90,82,4,15,26,79,85,59,72,81,7,9,87,4,23,5,2,85,34,17,15,66,97,51,91,51,58,68,81,76,100,75,91,21,54,60,83};
        L_881_2.numRescueBoats(a,100);
    }
}
