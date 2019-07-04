package kth;

import java.io.*;

/**
 * 문제
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 *
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * 10
 *
 * if n = 1 then nothing
 * if n = 2 then -1
 * if n / 2 = 1 then / 2
 * if n / 3 = 1 then / 3
 *
 * 4
 * 2 1 -> 2
 * 3 1 -> 2
 *
 * 5
 * 4 2 1 -> 3
 *
 * 6
 * 3 1 > 2
 *
 * 7
 * 6 3 1 -> 3
 *
 * 8
 * 4 2 1 -> 3
 *
 * 9
 * 3 1 -> 2
 *
 * 10
 * 9 3 1 -> 3
 *
 * 11
 * 10 9 3 1 -> 4
 *
 * 12
 * 4 2 1 -> 3
 * 6 2 1 -> 3
 *
 * 13
 * 12 -> 4
 *
 * 14
 * 13 -> 5
 * 7 -> 4
 *
 * 27
 * 9 3 1 -> 3
 *
 * 28
 * 14 7 6 3 1 -> 5
 * 27 9 3 1 -> 4
 *
 *
 * 29
 * 28 27 9 3 1 -> 5
 *
 * 30
 * 29 28 27 9 3 1 -> 6
 * 10 9 3 1 -> 4
 * 10 5 4 2 1 -> 5
 * 15 5 4 2 1 -> 5
 *
 * 31
 * 30 10 9 3 1 -> 5
 *
 * 32
 * 16 8 4 2 1 -> 5
 *
 * 33
 * 11 10 5 4 2 1 -> 6
 *
 * 32 15 8 4 2 1 -> 6
 *
 */
public class A1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] mins = new int[N + 1];

        // init
        mins[0] = 0;
        mins[1] = 0;

        for (int i = 2; i <= N; i++) {
            boolean is2x = i % 2 == 0;
            boolean is3x = i % 3 == 0;

            if (is2x && !is3x) {
                // 2의 배수이고 3의 배수는 아닌 경우
                mins[i] = getMin(mins[i - 1] + 1, mins[i / 2] + 1);
            } else if (!is2x && is3x) {
                // 2의 배수는 아니고 3의 배수인 경우
                mins[i] = getMin(mins[i - 1] + 1, mins[i / 3] + 1);
            } else if (is2x && is3x) {
                // 2의 배수는 이면서 3의 배수인 경우
                mins[i] = getMin(getMin(mins[i - 1] + 1, mins[i / 3] + 1), mins[i / 2] + 1);
            } else {
                // 둘 다 아닌 경우
                mins[i] = mins[i - 1] + 1;
            }
        }
        bw.write(mins[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMin(int a, int b) {
        return a < b ? a : b;
    }
}
