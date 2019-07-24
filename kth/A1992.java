package kth;

import java.io.*;
import java.util.Arrays;

public class A1992 {
    static String str = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] V = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            V[i] = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        }
        devide(V, 0, 0, N);
        bw.write(str + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void devide(int[][] v, int startX, int startY, int n) {
        int result = isAllSame(v, startX, startY, n);
        if (result != -1) {
            str += result;
            return;
        }
        str += "(";
        int dividedN = n / 2;
        devide(v, startX, startY, dividedN);
        devide(v, startX + dividedN, startY, dividedN);
        devide(v, startX, startY + dividedN, dividedN);
        devide(v, startX + dividedN, startY + dividedN, dividedN);
        str += ")";
    }

    private static int isAllSame(int[][] target, int startX, int startY, int n) {
        boolean same = true;
        int pivot = target[startY][startX];
        for (int i = startY; i < startY + n; i++) {
            for (int j = startX; j < startX + n; j++) {
                if (target[i][j] != pivot) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }
        return same ? pivot : -1;
    }
}
