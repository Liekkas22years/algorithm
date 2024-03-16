package leetcode.Hashtable;

import java.util.HashMap;
import java.util.Map;

//两数之和
//哈希表
/*执行用时：1 ms, 在所有 Java 提交中击败了99.46%的用户
内存消耗：41.3 MB, 在所有 Java 提交中击败了40.02%的用户
通过测试用例：57 / 57*/
public class L_1_3 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int t =10;
        twoSum(nums,t);
    }
}
