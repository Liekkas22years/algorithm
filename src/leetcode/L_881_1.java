package leetcode;

import java.util.Arrays;
//Boats to Save People
//暴力法
/*执行结果：
        通过
        显示详情
        添加备注

        执行用时：2170 ms, 在所有 Java 提交中击败了5.02%的用户
        内存消耗：47 MB, 在所有 Java 提交中击败了92.10%的用户
        通过测试用例：78 / 78

 */
public class L_881_1 {
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

        int i,j;
        for (i = 0; i < people.length; i++) {
            if ((people[i]>Math.ceil(limit/2.0)) && a[i]==0) {
                k++;
                a[i]=1;
            }
            else if(a[i]==1){
                continue;
            }
            else{
                for(j =people.length-1;j>i;j--){
                    if(people[i]+people[j]<=limit && a[j]==0){
                        k++;
                        a[i]=1;
                        a[j]=1;
                        break;
                    }
                }
                if(i==j){
                    k++;
                    a[i]=1;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] a ={68,88,50,92,33,50,50,68,21,61,22,35,97,90,82,4,15,26,79,85,59,72,81,7,9,87,4,23,5,2,85,34,17,15,66,97,51,91,51,58,68,81,76,100,75,91,21,54,60,83};
        L_881_1.numRescueBoats(a,100);
    }
}
