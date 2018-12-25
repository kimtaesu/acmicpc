package acmicpc.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * <p>
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * <p>
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class B1463 {
    @Test
    public void test() {
//        Assert.assertEquals(solution(2), 1);
        Assert.assertEquals(solution(10), 3);

    }

    int solution(int n) {
//        Scanner sc = new Scanner(System.in);

        int X = n;

        int[] min = new int[1000001]; // 10의 6승이 최대값이기 때문에

        min[1] = 0; // 계산하기 쉬우려고 배열은 0번부터 시작하지만 인위적으로 1부터 시작하는 것처럼 만듦.

        for (int i = 2; i < X + 1; i++) {
            min[i] = min[i - 1] + 1; // 3이나 2로 나누어지지 않으면 주어진 숫자의 1 작은 수에 대한 최소 연산횟수 + (-1) 연산을 한 횟수

            if (i % 2 == 0 && min[i / 2] + 1 < min[i]) {
                min[i] = min[i / 2] + 1; // 2로 바로 나누어 지는 경우 최솟값 비교해서 작은 연산 횟수로 대입.
            }
            if (i % 3 == 0 && min[i / 3] + 1 < min[i]) {
                min[i] = min[i / 3] + 1; // 3으로 바로 나누어질 때, 대입된 값에 대한 비교가 이뤄지므로 모든 경우에 대한 비교가 성립.
                // (-1) 연산이 이뤄진 횟수와 2로 바로 나누었을 때에 대한 최종 값이 마지막 min[i]에 들어오기 때문이다.
            }

        }
        System.out.println(min[X]);
        return min[X];
    }
}
