package csp;

import java.util.Scanner;

public class csp_202109_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
            b[i]=a[i];
        }
        int max=a[0];
        int max_count=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]>max){
                max=a[i];
            }
        }
        for(int p=2;p<max;p++){
            for (int i = 0; i < b.length; i++) {
                a[i]=b[i];
            }
            for (int i=0;i<a.length;i++){
                if (a[i]<p){
                    a[i]=0;
                }
            }
            int count=0;
            int l=0;
            int r=0;
            while (l<n){
                if(a[l]!=0&&a[r]!=0){
                    r++;
                    if(r==n){
                        count++;
                        break;
                    }
                }
                else if(a[l]!=0&&a[r]==0){
                    count++;
                    l=r;
                }
                else if(a[l]==0){
                    l++;
                    r=l;
                }
            }
            if(count>max_count){
                max_count=count;
            }
        }


        System.out.println(max_count);
    }
}
