package kth;

import java.io.*;
import java.util.Arrays;

public class A4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalCount = 10001;
        boolean[] check = new boolean[totalCount];
        Arrays.fill(check, true);

        for (int i = 1; i < totalCount; i++) {
            int result = d(i);
            if (result >= totalCount) {
                continue;
            }
            check[result] = false;
        }
        for(int i = 1; i < totalCount; i++) {
            if (check[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static int d(int n) {
        char[] chars = ("" + n).toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += ((int) aChar - 48);
        }
        return n + sum;
    }
}
