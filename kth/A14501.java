package kth;

import java.io.*;

public class A14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int [n + 2];

        t[0] = 0;
        p[0] = 0;
        dp[0] = 0;
        dp[n + 1] = 0;
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
            dp[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int doJob = i + t[i];
            int donotJob = i + 1;
            if (doJob <= n + 1) {
                dp[doJob] = max(dp[doJob], dp[i] + p[i]);
            }
            if (donotJob <= n + 1) {
                dp[donotJob] = max(dp[donotJob], dp[i]);
            }
        }

        bw.write(dp[n + 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int max(int a, int b) {
        return a < b ? b : a;
    }
}
