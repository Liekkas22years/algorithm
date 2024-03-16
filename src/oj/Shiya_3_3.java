package oj;

import java.util.Scanner;

public class Shiya_3_3 {
    public static long work(long a, long b, long mod)
    {
        long ans = 0;
        while(b > 0) {
            if((b&1) == 1) {
                ans += a;
                ans %= mod;
            }
            a *= 2;
            a %= mod;
            b /= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long n = scanner.nextInt();
        long m = scanner.nextInt();


        System.out.println((int)work(a,n,m));
    }

}
