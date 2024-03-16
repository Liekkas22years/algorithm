package test360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class T_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = reader.readLine();
            Long n = Long.valueOf(name);
            Long sum = Long.valueOf(0);
            if (n <1 || n>10){
                System.out.print("Error");
                return;
            }else {
                for (Long i = Long.valueOf(1); i <= n; i++) {
                    sum+=fff(i);
                }
            }
            System.out.print(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static Long fff(Long n){
        if (n == 1) {
            return Long.valueOf(1);
        }
        Long sum = Long.valueOf(1);
        for (int i = 1; i <=n; i++) {
            sum*=i;
        }
        return sum;
    }
}
