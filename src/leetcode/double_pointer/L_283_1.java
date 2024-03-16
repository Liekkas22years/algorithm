package leetcode.double_pointer;
//移动零
//双指针
/*
执行用时：107 ms, 在所有 Java 提交中击败了5.02%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了15.46%的用户
 */
public class L_283_1 {
    public static void moveZeroes(int[] nums) {
        if(nums.length==1){
            return;
        }
        int l=0;
        int r=1;
        int t=0;
        while (l!=nums.length-1){
            if(nums[l]!=0){
                l++;
                if(l<nums.length-1){
                    r=l+1;
                }
            }
            if(nums[l]==0&&nums[r]!=0){
                t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
                l++;
                if(l<nums.length-1){
                    r=l+1;
                }
                continue;
            }
            else if(nums[l]==0&&nums[r]==0&&r<nums.length-1){
                r++;
            }
            if(r==nums.length-1&&nums[r]==0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a= {0,1,0,3,12};
        moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
