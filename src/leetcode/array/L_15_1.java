package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
//三指针，暴力法，结果超时
public class L_15_1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums==null || nums.length<=2){
            List list = new ArrayList();
            return list;
        }
        List list1 = new ArrayList(){};
        int l=0,m=1,n=2;
        while (l<nums.length){
            if(nums[l]+nums[m]+nums[n]==0){
                List<Integer> list2= Arrays.asList(nums[l],nums[m],nums[n]);
                if(!list1.contains(list2)){
                    list1.add(list2);
                }
                n++;
                if(n>=nums.length){
                    m++;
                    n=m+1;
                    if(m==nums.length-1){
                        l++;
                        m=l+1;
                        n=m+1;
                        if(l==nums.length-2){
                            break;
                        }
                    }
                }
            }
            else{
                n++;
                if(n>=nums.length){
                    m++;
                    n=m+1;
                    if(m==nums.length-1){
                        l++;
                        m=l+1;
                        n=m+1;
                        if(l==nums.length-2){
                            break;
                        }
                    }
                }
            }
        }

        return list1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{0,0,0,0};
        System.out.println(threeSum(a));
    }
}
