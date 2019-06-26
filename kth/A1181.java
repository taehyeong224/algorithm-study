package kth;

import java.io.*;
import java.util.*;

public class A1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int wordCount = Integer.parseInt(br.readLine());
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = br.readLine();
        }

        Set<String> mySet = new HashSet<>(Arrays.asList(words));
        String[] newArray = mySet.toArray(new String[mySet.size()]);


        Arrays.sort(newArray, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            }

            if (o1.length() < o2.length()) {
                return -1;
            }
            // same
            int order = o1.compareToIgnoreCase(o2);
            return order;
        });

        for (int i = 0; i < newArray.length; i++) {
            bw.write(newArray[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
