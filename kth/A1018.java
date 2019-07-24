package kth;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A1018 {
    static char[][] map;
    static List<Integer> count = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        map = new char[M][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i + 7 < N; i++) {
            for (int j = 0; j + 7 < M; j++) {
                blackCount(i, j);
                whiteCount(i, j);
            }
        }
        count.sort(Comparator.comparingInt(o -> o));
        bw.write(count.get(0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void blackCount(int startY, int startX) {
        int cnt = 0;
        for (int i = startY; i < startY + 8; i++) {
            for (int j = startX; j < startX + 8; j++) {
                if (map[i][j] != black[i - startY][j - startX]) {
                    cnt++;
                }
            }
        }
        count.add(cnt);
    }

    static void whiteCount(int startX, int startY) {
        int cnt = 0;
        for (int i = startY; i < startY + 8; i++) {
            for (int j = startX; j < startX + 8; j++) {
                if (map[i][j] != white[i - startY][j - startX]) {
                    cnt++;
                }
            }
        }
        count.add(cnt);
    }

    static char[][] black = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    static char[][] white = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}

    };
}
