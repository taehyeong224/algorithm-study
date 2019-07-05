package kth;

import java.io.*;

public class A4963 {
    static boolean[][] visit;
    static int[][] map;
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String inputs = br.readLine();
            if (inputs.equals("0 0")) {
                break;
            }
            String[] wh = inputs.split(" ");
            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);
            visit = new boolean[h][w];
            map = new int[h][w];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    visit[j][i] = false;
                }
            }
            for (int i = 0; i < h; i++) {
                String[] edges = br.readLine().split(" ");
                for (int j = 0; j < edges.length; j++) {
                    map[i][j] = Integer.parseInt(edges[j]);
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        count++;
                        dfs(j, i);
                    }
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int w1, int h1) {
        visit[h1][w1] = true;
        if (w1 + 1 < w && h1 + 1 < h && !visit[h1 + 1][w1 + 1] && map[h1 + 1][w1 + 1] == 1) {
            dfs(w1 + 1, h1 + 1);
        }

        if (w1 + 1 < w && h1 -1 >= 0 && !visit[h1 - 1][w1 + 1] && map[h1 - 1][w1 + 1] == 1) {
            dfs(w1 + 1, h1 - 1);
        }

        if (w1 -1 >= 0 && h1 - 1 >= 0 && !visit[h1 - 1][w1 - 1] && map[h1 - 1][w1 - 1] == 1) {
            dfs(w1 - 1, h1 - 1);
        }

        if (w1 -1 >= 0 && h1 + 1 < h && !visit[h1 + 1][w1 - 1] && map[h1 + 1][w1 - 1] == 1) {
            dfs(w1 - 1, h1 + 1);
        }

        if (w1 + 1 < w && !visit[h1][w1 + 1] && map[h1][w1 + 1] == 1) {
            dfs(w1 + 1, h1);
        }

        if (w1 -1 >= 0 && !visit[h1][w1 - 1]&& map[h1][w1 - 1] == 1) {
            dfs(w1 - 1, h1);
        }

        if (h1 + 1 < h && !visit[h1 + 1][w1] && map[h1 + 1][w1] == 1) {
            dfs(w1, h1 + 1);
        }

        if (h1 -1 >= 0 && !visit[h1 - 1][w1] && map[h1 - 1][w1] == 1) {
            dfs(w1, h1 - 1);
        }
    }
}