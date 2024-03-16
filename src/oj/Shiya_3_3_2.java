package oj;

import java.math.BigInteger;
import java.util.Scanner;

public class Shiya_3_3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a= null;
        BigInteger n= null;
        BigInteger m= null;
        a= scanner.nextBigInteger();
        n= scanner.nextBigInteger();
        m= scanner.nextBigInteger();
        long c = (long) Math.pow(a.doubleValue()%m.doubleValue(),n.doubleValue());
        long t = (long) (c % m.doubleValue());
        System.out.println(t);
        //System.out.println((long)(Math.pow(a.doubleValue(),n.doubleValue())%m.doubleValue()));
    }

}
