package test;

public class Dp {
    public static void main(String[] args) {
        System.out.println("最终结果是：" + packageProblem1());
    }
    public static int packageProblem1() {
        int packageContainWeight = 4;//包最大可装重量
        int[] weight = {1, 4, 3};//3个物品的重量
        int[] value = {150, 300, 200};//3个物品的价值
        int[][] dp = new int[weight.length + 1][packageContainWeight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= packageContainWeight; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                    } else {
                    dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        return dp[weight.length][packageContainWeight];
        }

    public static int packageProblem2() {
        int packageContainWeight = 4;
        int[] weight = {1, 4, 3};
        int[] value = {150, 300, 200};
        int[] dp = new int[packageContainWeight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = packageContainWeight; j >= 1; j--) {
                if (j - weight[i - 1] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
                }
            System.out.println();
            }
        return dp[packageContainWeight];
        }
}
