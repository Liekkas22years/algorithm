import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "123";
        try {
            int b = Integer.valueOf(str).intValue();
            System.out.println(b);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
