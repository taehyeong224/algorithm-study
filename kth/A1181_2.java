package kth;

import java.io.*;
import java.util.*;

public class A1181_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordCount = Integer.parseInt(br.readLine());
        TreeSet<String> words = new TreeSet<>(new MyComp());

        for (int i = 0; i < wordCount; i++) {
            words.add(br.readLine());
        }
        Iterator<String> itr = words.iterator();
        while (itr.hasNext()) {
            bw.write(itr.next() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class MyComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        }

        if (o1.length() < o2.length()) {
            return -1;
        }
        // same
        int order = o1.compareToIgnoreCase(o2);
        return order;
    }
}