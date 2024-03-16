package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
//优化暴力法
public class L_15_2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums==null || nums.length<=2){
            List list = new ArrayList();
            return list;
        }
        List list1 = new ArrayList(){};
        int l=0,m=1,n=2;
        while (l<nums.length){
            if(nums[l]>0){
                break;
            }
            int sum = nums[l]+nums[m]+nums[n];
            if(sum==0){
                List<Integer> list2= Arrays.asList(nums[l],nums[m],nums[n]);
                if(!list1.contains(list2)){
                    list1.add(list2);
                }
                //成功之后，直接让m++,因为是递增序列，后面不会再有
                m++;
                n=m+1;
                if( m==nums.length-1){
                    l++;
                    m=l+1;
                    n=m+1;
                    if(l==nums.length-2){
                        break;
                    }
                }
            }
            else{
                n++;
                if(sum>0 || n>=nums.length){
                    m++;
                    n=m+1;
                    //sum=nums[l]+nums[m]+nums[n];
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
        int a[] = new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        System.out.println(threeSum(a));
    }
}
