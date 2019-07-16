package kth;

import java.io.*;

public class A1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int peopleCount = Integer.parseInt(br.readLine());
            int[] rank = new int[peopleCount];
            int total = 1;
            for (int j = 0; j < peopleCount; j++) {
                String[] inputs = br.readLine().split(" ");
                int one = Integer.parseInt(inputs[0]);
                int two = Integer.parseInt(inputs[1]);
                rank[one - 1] = two;
            }
            int min = rank[0];
            for (int j = 1; j < peopleCount; j++) {
                if (rank[j] < min) {
                    min = rank[j];
                    total++;
                }
            }
            bw.write(total + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
