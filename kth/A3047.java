package kth;

import java.io.*;
import java.util.Arrays;

public class A3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ABC = br.readLine().split(" ");
        char[] ABCOrder = br.readLine().toCharArray();

        int[] numbers = Arrays.stream(ABC).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ABCOrder.length; i++) {
            switch (ABCOrder[i]) {
                case 'A':
                    result.append(i != 0 ? " " + numbers[0] : numbers[0]);
                    break;
                case 'B':
                    result.append(i != 0 ? " " + numbers[1] : numbers[1]);
                    break;
                case 'C':
                    result.append(i != 0 ? " " + numbers[2] : numbers[2]);
                    break;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
