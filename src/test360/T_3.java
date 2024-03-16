package test360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set set = new HashSet<>();
        Set set1 = new HashSet<>();
        String str = sc.nextLine();
        char[] c  = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!set.contains(c[i])){
                set.add(c[i]);
            }else {
                set1.add(c[i]);
            }
        }
        Object[] s = set1.toArray();
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }
}
