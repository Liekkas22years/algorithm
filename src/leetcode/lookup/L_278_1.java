package leetcode.lookup;

import leetcode.bath.VersionControl;

//第一个错误的版本
/*
执行用时：28 ms, 在所有 Java 提交中击败了5.40%的用户
内存消耗：35.2 MB, 在所有 Java 提交中击败了37.21%的用户
 */
public class L_278_1 extends VersionControl {
    public int firstBadVersion(int n) {
        if(n<=10){
            int i=0;
            while(i<n){
                if(isBadVersion(i)==true){
                    return i;
                }
                i++;
            }
            return i;
        }
        else{
            long low =1;
            long high =n;
            long mid = (low+high)/2;

            while(true){
                if(isBadVersion((int)mid)==false&&isBadVersion((int)mid+1)==true){
                    break;
                }
                if(isBadVersion((int)mid)==true){
                    high=mid;
                    mid = (low+high)/2;
                }
                if(isBadVersion((int)mid)==false){
                    low=mid;
                    mid = (low+high)/2;
                }

            }
            return (int)mid+1;
        }
    }
}
