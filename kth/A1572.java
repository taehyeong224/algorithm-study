package kth;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 문제
 * 중앙값이란, 수열을 정렬했고, 그 크기가 N일 때, 1부터 시작해서 (N+1)/2번째 있는 원소가 그 수열의 중앙값이다.
 *
 * 예를 들어, {1, 2, 6, 5, 4, 3}에서는 3이고, {11, 13, 12, 15, 14}에서는 13이다.
 *
 * 오세준은 1초에 온도를 하나씩 재는 온도계를 만들었다. 이 온도계에는 작은 디스플레이 창이 하나 있는데,
 *
 * 이 창에는 지금부터 최근 K초 까지 온도의 중앙값을 표시해 준다. (온도를 재기시작한지 K초부터 표시한다. 그 전에는 아무것도 출력되지 않는다.)
 *
 * 오세준은 온도를 N 초동안 쟀다. 그 시간 동안 온도계의 디스플레이 창에 뜨는 숫자의 합을 구하는 프로그램을 작성하시오.
 *
 * 다른 말로 하면, 길이가 N인 수열이 주어진다. 이 수열은 N-K+1 개의 길이가 K인 연속된 부분 수열이 존재한다.
 *
 * 이 부분 수열의 중앙값의 합을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. N은 250,000보다 작거나 같은 자연수이고, K는 5,000보다 작거나 같은 자연수이다. N은 항상 K보다 크거나 같다.
 *
 * 둘째 줄부터 N개의 수가 한 줄에 하나씩 주어진다. 입력으로 주어지는 수는 65536보다 작거나 같은 자연수 또는 0이다.
 *
 * 출력
 * 둘째 줄에 정답을 출력한다. 정답은 int64범위다.
 */
public class A1572 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.comparingInt(o -> o));
        int center = (K + 1) / 2;
        int sum = 0;
        for (int i = center - 1; i <= N - center; i++) {
            sum += list.get(i);
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
