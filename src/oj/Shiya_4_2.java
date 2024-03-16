package oj;

public class Shiya_4_2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "baacaabbacabb";
        int[] tail = tail(str);
        int[] head = head(str);
        for (int num : tail) {
            System.out.print(num + ", ");
        }
        System.out.println();
        for (int num : head) {
            System.out.print(num + ", ");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tail.length; i++) {
            max = max < (tail[i] + head[i]) ? tail[i] + head[i] : max;
        }
        System.out.println();
        System.out.println(max);
    }
    public static int[] tail(String str) {
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int left = 0;
            int start = left;
            int end = i;
            int len = 0;
            while (start < end) {
                if (str.charAt(start) == str.charAt(end)) {
                    len+=2;
                    start++;
                    end--;
                }  else {
                    len = 0;
                    end = i;
                    start = ++left;
                }
            }
            nums[i] = len;
        }
        return nums;
    }
    public static int[] head(String str) {
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int start = i;
            int end = str.length() - 1;
            int len = 1;
            while (start < end) {
                if (str.charAt(start) == str.charAt(end)) {
                    len+=2;
                    start++;
                    end--;
                }  else {
                    len = 0;
                    break;
                }
            }
            nums[i] = len;
        }
        return nums;
    }
}
