package kth;

import java.io.*;

public class A4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String inputs = br.readLine();
            String lower = inputs.toLowerCase() + " ";
            String[] good = lower.split("g");
            String[] bad = lower.split("b");

            String msg;
            if (good.length > bad.length) {
                msg = inputs + " is GOOD";
            } else if (good.length < bad.length) {
                msg = inputs + " is A BADDY";
            } else {
                msg = inputs + " is NEUTRAL";
            }
            bw.write(msg + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
