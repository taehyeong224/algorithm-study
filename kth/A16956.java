package kth;


import java.io.*;

/**
 * 문제
 * 크기가 R×C인 목장이 있고, 목장은 1×1 크기의 칸으로 나누어져 있다. 각각의 칸에는 비어있거나,
 *
 * 양 또는 늑대가 있다. 양은 이동하지 않고 위치를 지키고 있고, 늑대는 인접한 칸을 자유롭게 이동할 수 있다.
 *
 * 두 칸이 인접하다는 것은 두 칸이 변을 공유하는 경우이다.
 *
 * 목장에 울타리를 설치해 늑대가 양이 있는 칸으로 갈 수 없게 하려고 한다.
 *
 * 늑대는 울타리가 있는 칸으로는 이동할 수 없다. 울타리를 설치해보자.
 *
 * 입력
 * 첫째 줄에 목장의 크기 R, C가 주어진다.
 *
 * 둘째 줄부터 R개의 줄에 목장의 상태가 주어진다. '.'는 빈 칸, 'S'는 양, 'W'는 늑대이다.
 *
 * 출력
 * 늑대가 양이 있는 칸으로 갈 수 없게 할 수 있다면 첫째 줄에 1을 출력하고, 둘째 줄부터 R개의 줄에 목장의 상태를 출력한다.
 *
 * 울타리는 'D'로 출력한다. 울타리를 어떻게 설치해도 늑대가 양이 있는 칸으로 갈 수 있다면 첫째 줄에 0을 출력한다.
 *
 */
public class A16956 {
    static int R;
    static int C;
    static char[][] map;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        map = new char[C][R];
        int sCount = 0;
        int wCount = 0;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[i][j] == 'S') {
                    sCount++;
                }

                if (map[i][j] == 'W') {
                    wCount++;
                }
            }
        }

        if (wCount == 0 || sCount == 0) {
            bw.write(1 + "\n");
            printMap();
        } else {
            if (checkNearWolf()) {
                bw.write(0 + "\n");
            } else {
                bw.write(1 + "\n");
                fillD();
                printMap();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkNearWolf() {
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[i][j] == 'S') {
                    if (i - 1 >= 0 && map[i - 1][j] == 'W') {
                        return true;
                    }

                    if (j - 1 >= 0 && map[i][j - 1] == 'W') {
                        return true;
                    }

                    if (j + i < R && map[i][j + 1] == 'W') {
                        return true;
                    }

                    if (i + 1 < C && map[i + 1][j] == 'W') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void printMap() throws IOException {
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
    }

    private static void fillD() {
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'D';
                }
            }
        }
    }
}
