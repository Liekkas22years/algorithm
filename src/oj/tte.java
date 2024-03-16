package oj;

public class tte {
    public static int work(int a, int b, int mod)
    {
        int ans = 0;
        while(b > 0) {
            if((b&1) ==1) {
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
        System.out.println(work(2,2,5));
    }
}
