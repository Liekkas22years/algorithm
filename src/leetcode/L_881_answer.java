package leetcode;

import java.util.Arrays;
//Boats to Save People
//官方答案 双指针
/*
    时间复杂度：O(nlogn)，其中n是数组people的长度。算法的时间开销主要在排序上。

    空间复杂度：O(logn)，排序所需额外的空间复杂度为O(logn)。
*/

/*执行结果：
        通过
        显示详情
        添加备注

        执行用时：16 ms, 在所有 Java 提交中击败了94.86%的用户
        内存消耗：46.8 MB, 在所有 Java 提交中击败了93.44%的用户
        通过测试用例：78 / 78

 */
public class L_881_answer {
    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a ={68,88,50,92,33,50,50,68,21,61,22,35,97,90,82,4,15,26,79,85,59,72,81,7,9,87,4,23,5,2,85,34,17,15,66,97,51,91,51,58,68,81,76,100,75,91,21,54,60,83};
        L_881_answer.numRescueBoats(a,100);
    }
}
