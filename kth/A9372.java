package kth;

import java.io.*;

public class A9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TestCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < TestCase; i++) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            for (int j = 0; j < M; j++) {
                String[] ab = br.readLine().split(" ");
            }
            bw.write(N - 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
