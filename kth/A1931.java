package kth;

import java.io.*;
import java.util.*;

/**
 * 문제
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
 * <p>
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * <p>
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * <p>
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * <p>
 * 입력
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데
 * <p>
 * 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
 * <p>
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 */
public class A1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] meet = new int[n][2];
        int last = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            meet[i][0] = start;
            meet[i][1] = end;
        }
        Arrays.sort(meet, (start, end) -> {
            if (start[1] == end[1]) {
                return Integer.compare(start[0], end[0]);
            }
            return Integer.compare(start[1], end[1]);
        });

        for (int i = 0; i < n; i++) {
            if (meet[i][0] >= last) {
                last = meet[i][1];
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
