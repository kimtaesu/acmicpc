package acmicpc.dynamic;

import org.junit.Test;

import java.util.Scanner;

public class B9095 {
    @Test
    public void test() {
        System.out.println(solution(6));
    }

    public int solution(int n) {
        int[] answer = new int[n];
        for (int k = 0; k < n; k++) {
            int[] dp = new int[100001];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            if (n <= 3) {
                answer[k] = dp[n];
            } else {
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
                answer[k] = dp[n];
            }
        }
        return answer[n - 1];
    }
}
