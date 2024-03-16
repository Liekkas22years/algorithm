package leetcode;

import java.util.Arrays;
//Boats to Save People
//在L_881_2的基础上作优化，在第二层for循环里加了一个判断，
// 如果people[i]+people[j]>limit && a[j]==0 直接将a[j]=1,但性能却降低了
/*执行结果：
        通过
        显示详情
        添加备注

        执行用时：22 ms, 在所有 Java 提交中击败了6.19%的用户
        内存消耗：47.3 MB, 在所有 Java 提交中击败了73.30%的用户
        通过测试用例：78 / 78

 */
public class L_881_3 {
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
                    if(people[i]+people[j]>limit && a[j]==0){
                        a[j]=1;
                        k++;
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
        int[] a ={3,2,2,1};
        L_881_3.numRescueBoats(a,3);
    }
}
