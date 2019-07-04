package kth;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * 문제
 *
 * RGB 거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다.
 *
 * 집 i의 이웃은 집 i-1과 집 i+1이다.
 *
 * 각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때,
 *
 * 모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다.
 *
 * 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.
 *
 * 비용은 1,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.
 */
public class A1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int countOfHouse = Integer.parseInt(br.readLine());
        int[][] houses = new int[countOfHouse][3];
        int[][] price = new int[countOfHouse][3];
        for (int i = 0; i < countOfHouse; i++) {
            String[] inputPrice = br.readLine().split(" ");

            houses[i][0] = Integer.parseInt(inputPrice[0]);
            houses[i][1] = Integer.parseInt(inputPrice[1]);
            houses[i][2] = Integer.parseInt(inputPrice[2]);
        }
        // 초기값을 첫 번 째 값들로 지정
        price[0][0] = houses[0][0];
        price[0][1] = houses[0][1];
        price[0][2] = houses[0][2];
        // price[i] = price[i -1] + 현재 최소값
        for (int i = 1; i < countOfHouse; i++) {
            price[i][0] = getMin(price[i-1][1], price[i-1][2]) + houses[i][0];
            price[i][1] = getMin(price[i-1][0], price[i-1][2]) + houses[i][1];
            price[i][2] = getMin(price[i-1][0], price[i-1][1]) + houses[i][2];
        }
        bw.write(getMin(getMin(price[countOfHouse - 1][0], price[countOfHouse - 1][1]), price[countOfHouse - 1][2]) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMin(int a, int b) {
        return a < b ? a : b;
    }
}
