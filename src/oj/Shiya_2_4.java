package oj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//二叉排序树插入删除操作
public class Shiya_2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet();
        for(int i=0;i<n;i++){
            int x = scanner.nextInt();
            if(1==x) {
                set.add(scanner.nextInt());
            }else if(2==x){
                set.remove(scanner.nextInt());
            }else{
                int j=0;
                int[] array = new int[set.size()];
                for(Integer t:set){
                    array[j]=t;
                    j++;
                }
                Arrays.sort(array);
                for (int k = 0; k < array.length; k++) {
                    System.out.print(array[k]+" ");
                }
            }

        }

    }
}
