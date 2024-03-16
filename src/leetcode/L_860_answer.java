package leetcode;

//柠檬水找零Lemonade Change
//官方的答案
/*
执行用时：2 ms, 在所有 Java 提交中击败了90.19%的用户
内存消耗：48.8 MB, 在所有 Java 提交中击败了68.50%的用户
通过测试用例：59 / 59
 */
public class L_860_answer {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {5,5,10,10,20};
        L_860_answer.lemonadeChange(a);
    }
}
