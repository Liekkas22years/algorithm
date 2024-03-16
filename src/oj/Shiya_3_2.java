package oj;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Shiya_3_2 {
    /**
     * Karatsuba乘法
     */
    public static long karatsuba(long num1, long num2){
        //递归终止条件
        if(num1 < 10 || num2 < 10) return num1 * num2;

        // 计算拆分长度
        int size1 = String.valueOf(num1).length();
        int size2 = String.valueOf(num2).length();
        int halfN = Math.max(size1, size2) / 2;

        /* 拆分为a, b, c, d */
        long a = Long.valueOf(String.valueOf(num1).substring(0, size1 - halfN));
        long b = Long.valueOf(String.valueOf(num1).substring(size1 - halfN));
        long c = Long.valueOf(String.valueOf(num2).substring(0, size2 - halfN));
        long d = Long.valueOf(String.valueOf(num2).substring(size2 - halfN));

        // 计算z2, z0, z1, 此处的乘法使用递归
        long z2 = karatsuba(a, c);
        long z0 = karatsuba(b, d);
        long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

        return (long)(z2 * Math.pow(10, (2*halfN)) + z1 * Math.pow(10, halfN) + z0);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();


        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        Arrays.sort(arr);
        long a = karatsuba(arr[(int) (n-1)],arr[(int) (n-2)]);

        System.out.println(karatsuba(a,arr[(int) (n-3)]));
    }
}
