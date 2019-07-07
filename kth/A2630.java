package kth;

import java.io.*;

public class A2630 {
    static int[] count = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(line[j]);
            }
        }
        count[0] = 0;
        count[1] = 0;
        devide(array);
        bw.write(count[0] + "\n");
        bw.write(count[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void devide(int[][] target) {
        int result = isAllSame(target);
        if (result != -1) {
            count[result]++;
            return;
        }

        int newLength = target.length / 2;
        int[][] newArray0 = new int[newLength][newLength];
        int[][] newArray1 = new int[newLength][newLength];
        int[][] newArray2 = new int[newLength][newLength];
        int[][] newArray3 = new int[newLength][newLength];

        for (int i = 0; i < newLength; i++) {
            for (int j = 0; j < newLength; j++) {
                newArray0[i][j] = target[i][j];
            }
        }

        for (int i = newLength; i < newLength * 2; i++) {
            for (int j = newLength; j < newLength * 2; j++) {
                newArray1[i - newLength][j - newLength] = target[i][j];
            }
        }


        for (int i = newLength; i < newLength * 2; i++) {
            for (int j = 0; j < newLength; j++) {
                newArray2[i - newLength][j] = target[i][j];
            }
        }

        for (int i = 0; i < newLength; i++) {
            for (int j = newLength; j < newLength * 2; j++) {
                newArray3[i][j - newLength] = target[i][j];
            }
        }

        devide(newArray0);
        devide(newArray1);
        devide(newArray2);
        devide(newArray3);
    }

    private static int isAllSame(int[][] target) {
        boolean same = true;
        int pivot = target[0][0];
        for (int[] ints : target) {
            for (int anInt : ints) {
                if (anInt != pivot) {
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
