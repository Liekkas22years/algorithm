package oj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//创建二叉排序树
public class Shiya_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet();
        for(int i=0;i<n;i++){
            set.add(scanner.nextInt());
        }
        int j=0;
        int[] array = new int[set.size()];
        for(Integer i:set){
            array[j]=i;
            j++;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
