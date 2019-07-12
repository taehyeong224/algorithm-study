package kth;

import java.io.*;

/**
 * 문제
 * 각 노드가 자식을 최대 K개 가질 수 있는 트리를 K진 트리라고 한다. 총 N개의 노드로 이루어져 있는 K진 트리가 주어진다.
 * <p>
 * 트리는 "적은 에너지" 방법을 이용해서 만든다. "적은 에너지" 방법이란, 이전 깊이를 모두 채운 경우에만, 새로운 깊이를 만드는 것이고,
 * <p>
 * 이 새로운 깊이의 노드는 가장 왼쪽부터 차례대로 추가 한다.
 * <p>
 * 노드의 개수 N과 K가 주어졌을 때, 두 노드 x와 y 사이의 거리를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N (1 ≤ N ≤ 1015)과 K (1 ≤ K ≤ 1 000), 그리고 거리를 구해야 하는 노드 쌍의 개수 Q (1 ≤ Q ≤ 100 000)가 주어진다.
 * <p>
 * 다음 Q개 줄에는 거리를 구해야 하는 두 노드 x와 y가 주어진다. (1 ≤ x, y ≤ N, x ≠ y)
 * <p>
 * 출력
 * 총 Q개의 줄을 출력한다. 각 줄에는 입력으로 주어진 두 노드 사이의 거리를 출력한다.
 * <p>
 * 예1
 * 7 2 3
 * 1 2
 * 2 1
 * 4 7
 * <p>
 * 출력
 * 1
 * 1
 * 4
 */
public class A11812_2 {
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        long nodeCount = Long.parseLong(inputs[0]);
        max = Integer.parseInt(inputs[1]);
        long count = Long.parseLong(inputs[2]);

        for (int i = 0; i < count; i++) {
            String[] targets = br.readLine().split(" ");
            long x = Long.parseLong(targets[0]);
            long y = Long.parseLong(targets[1]);
            long weight = 0;
            if (max == 1) {
                weight = x < y ? y - x : x - y;
            } else {
                while (x != y) {
                    while (x > y) {
                        x = getParent(x);
                        weight++;
                    }

                    while (x < y) {
                        y = getParent(y);
                        weight++;
                    }

                }
            }
            bw.write(weight + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static long getParent(Long a) {
        return (a + max - 2) / max;
    }
}


