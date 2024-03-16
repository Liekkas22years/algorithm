package oj;

import java.util.Scanner;

public class Shiya_5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int i;
        int distance = 0;
        int len = 1;

        for(i=1;i<=t;i++){
            if(m >= 10){  //能量的使用
                distance += 60;
                m -=10;
            }else{
                m +=4;
            }
            if(len + 17 > distance){  //如果用1秒能追上
                len += 17;
            }else{
                len = distance;
            }
            if(len >= s){
                System.out.println("Yes");
                System.out.println(i);
                break;
            }
        }

        if(distance<s && i==t){
            System.out.println("No");
            System.out.println(len);
        }

    }
}
