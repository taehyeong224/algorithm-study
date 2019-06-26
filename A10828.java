import java.io.*;
import java.util.Stack;

public class A10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }

            if (command.equals("top")) {
                try {
                    int last = stack.pop();
                    bw.write(last + "\n");
                    stack.push(last);
                } catch (Exception e) {
                    bw.write(-1 + "\n");
                }
            }

            if (command.equals("size")) {
                bw.write(stack.size() + "\n");
            }

            if (command.equals("empty")) {
                int empty = stack.empty() ? 1 : 0;
                bw.write( empty + "\n");
            }

            if (command.equals("pop")) {
                try {
                    int last = stack.pop();
                    bw.write(last + "\n");
                } catch (Exception e) {
                    bw.write(-1 + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
