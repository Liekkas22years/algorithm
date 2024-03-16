package oj;

import java.util.LinkedList;
import java.util.List;

public class First {
    public static List<Integer> bigNumberMultiply2(int[] num1, int[] num2){
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        LinkedList<Integer>result = new LinkedList<>();
        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++){
            for (int j = 0; j < num2.length; j++){
                if(result.size()-1<i+j)
                    result.add(0);
                result.set( i+j, result.get(i+j)+(num1[i] * num2[j])%10);
                // 需要进位
                if((num1[i] * num2[j])/10>0) {
                    if(result.size()-1<i+j+1)
                        result.add(0);
                    result.set(i + j + 1, result.get(i + j + 1) + (num1[i] * num2[j]) / 10);
                }
            }
        }
        return result;
    }
    public static void main(String[]args){
        List<Integer>res = bigNumberMultiply2(new int[]{3,2},new int[]{3});
        for(int i:res)
            System.out.print(i);
    }
}
