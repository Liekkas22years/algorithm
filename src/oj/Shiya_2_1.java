package oj;

import java.util.Arrays;
import java.util.Scanner;

//你算老几啊？
public class Shiya_2_1 {
    public static int query(int[] a,int x) {
        int n=a.length;
        if(x>a[n-1])
            return n+1;
        int l=0,r=n-1;
        while(l<r) {
            int mid=(l+r)/2;
            if(a[mid]>=x)
                r=mid;
            else
                l=mid+1;
        }
        return l+1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;++i)
            a[i]=scanner.nextInt();
        Arrays.sort(a);
        for(int t=0;t<k;++t)
            System.out.println(query(a,scanner.nextInt()));
    }
}
