package leetcode;

//柠檬水找零Lemonade Change
//删除了1中开头的判断
/*
执行用时：2 ms, 在所有 Java 提交中击败了90.19%的用户
内存消耗：48.9 MB, 在所有 Java 提交中击败了34.16%的用户
通过测试用例：59 / 59
 */
public class L_860_2 {
    public static boolean lemonadeChange(int[] bills) {
        int count_5=0;
        int count_10=0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                count_5++;
                continue;
            }
            if(bills[i]==10 && count_5>0){
                count_5--;
                count_10++;
                continue;
            }
            if(bills[i]==10 && count_5<=0){
                return false;
            }
            if(bills[i]==20 && count_10>0 && count_5>0){
                count_5--;
                count_10--;
                continue;
            }
            else if(bills[i]==20 && count_5>=3){
                count_5-=3;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {5,5,10,10,20};
        L_860_2.lemonadeChange(a);
    }
}
