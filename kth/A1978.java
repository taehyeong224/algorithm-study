package kth;

import java.io.*;

/**
 * 문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 */
public class A1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int total = 0;
        String[] inputs = br.readLine().split(" ");
        for (String input : inputs) {
            boolean prime = true;
            int num = Integer.parseInt(input);
            if (num == 1) {
                continue;
            }
            for (int k = 2; k < num; k++) {
                if (num % k == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                total++;
            }
        }
        bw.write(total + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
