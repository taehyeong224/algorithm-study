package kth;

import java.io.*;
import java.util.*;

public class A1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<String, Queue<String>> stringQueueMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            String key = "";
            if (name.length() == 0) {
                key = name;
            } else {
                key = name.substring(0, 1);
            }
            Queue<String> queue = stringQueueMap.get(key);
            if (queue == null) {
                queue = new LinkedList<>();
            }
            queue.add(name);
            stringQueueMap.put(key, queue);
        }
        String result = "";
        for (String key : stringQueueMap.keySet()) {
            if (stringQueueMap.get(key).size() >= 5) {
                result += key;
            }
        }

        if (result.equals("")) {
            result = "PREDAJA";
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
