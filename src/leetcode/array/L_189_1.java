package leetcode.array;
//轮转数组
/*
执行用时：3 ms, 在所有 Java 提交中击败了13.08%的用户
内存消耗：55.2 MB, 在所有 Java 提交中击败了66.56%的用户
 */
public class L_189_1 {
    public static void rotate(int[] nums, int k) {
        if(nums.length<k){
            k=k%nums.length;
        }
        int i=0;
        int t;
        while (i<nums.length/2){
            t=nums[i];
            nums[i]=nums[nums.length-i-1];
            nums[nums.length-i-1]=t;
            i++;
        }
        int j=0;
        while (j<k/2){
            t=nums[j];
            nums[j]=nums[k-1-j];
            nums[k-1-j]=t;
            j++;
        }
        for(i=k;i<(nums.length+k)/2;i++){
            t=nums[i];
            nums[i]=nums[nums.length+k-1-i];
            nums[nums.length+k-1-i]=t;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};
        int k=3;
        rotate(a,3);
    }
}
