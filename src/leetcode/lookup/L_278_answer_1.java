package leetcode.lookup;

import leetcode.bath.VersionControl;

//第一个错误的版本
/*
执行用时：11 ms, 在所有 Java 提交中击败了99.97%的用户
内存消耗：35.1 MB, 在所有 Java 提交中击败了57.37%的用户
 */
public class L_278_answer_1 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;                
    }
}
