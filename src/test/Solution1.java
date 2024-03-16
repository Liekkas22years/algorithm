package test;

public class Solution1 {
    public static  int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int k=1;
        int l=nums.length;
        for (int i = 0; i < l-1; i++) {
            if(nums[i]-nums[i+1]==0){
            }
            else{
                nums[k-1]=nums[i];
                k++;
            }
        }
        if(nums[l-2]!=nums[l-1]){
            nums[k-1]=nums[l-1];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2};
        int[] a2 = {-3,-1,-1,0,0,0,0,2,2};
        int[] a3 = {-3,-1,0,2};
        System.out.println(removeDuplicates(a));
    }
}
