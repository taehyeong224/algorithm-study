package kth;

import java.io.*;
import java.util.Arrays;

/**
 * 문제
 * 어떤 수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 제곱ㄴㄴ수라고 한다.
 * <p>
 * 제곱수는 정수의 제곱이다. min과 max가 주어지면, min과 max를 포함한 사이에 제곱ㄴㄴ수가 몇 개 있는지 출력한다.
 * <p>
 * 입력
 * 첫째 줄에 min과 max가 주어진다. min은 1보다 크거나 같고, 1,000,000,000,000보다 작거나 같은 자연수이고,
 * <p>
 * max는 min보다 크거나 같고, min+1,000,000 보다 작거나 같은 자연수이다.
 * <p>
 * <p>
 * 1, 10 => 7
 * <p>
 * 1, 2, 3, 5, 6, 7, 10
 */
public class A1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");
        long min = Long.parseLong(inputs[0]);
        long max = Long.parseLong(inputs[1]);
        boolean[] check = new boolean[1000001];
        Arrays.fill(check, false);
        int end = (int) Math.sqrt(max);
        for (long i = 2; i <= end; i++) {
            long square = i * i; // 제곱을 구함
            long start = ((min - 1) / square + 1) * square; // 최초 배수 시작 점 구함
            for (long a = start; a <= max; a += square) { // 최초부터 제곱의 배수를 간격으로 true 로 변경
                check[(int) (a - min)] = true; // 3, 7, 9,
            }
        }

        int count = 0;
        for (int i = 0; i < (max - min + 1); i++) {
            count += check[i] ? 1 : 0;
        }
        bw.write(max - min + 1 - count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
