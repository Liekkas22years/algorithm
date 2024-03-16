package leetcode;

public class test {
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
