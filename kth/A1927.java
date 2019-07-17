package kth;

import java.io.*;
import java.util.PriorityQueue;

public class A1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (q.isEmpty())
                    bw.write(0 + "\n");
                else
                    bw.write(q.poll() + "\n");
            } else
                q.offer(input);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
