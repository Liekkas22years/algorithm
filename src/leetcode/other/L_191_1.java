package leetcode.other;

public class L_191_1 {
    public static int hammingWeight(int n) {
        String result = Integer.toBinaryString(n);

        char[] c = result.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(01011));
    }
}
