package kth;

import java.io.*;

public class A2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 4;
        int people = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int in = Integer.parseInt(inputs[1]);
            int out = Integer.parseInt(inputs[0]);
            people -= out;
            people += in;
            max = max > people ? max : people;
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
