package kth;

import java.io.*;
import java.util.*;

public class A7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            switch (inputs[1]) {
                case "enter":
                    map.put(inputs[0], true);
                    break;
                case "leave":
                    map.put(inputs[0], false);
                    break;
            }
        }
        for (Map.Entry<String, Boolean> item : map.entrySet()) {
            if (item.getValue()) {
                bw.write(item.getKey() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}