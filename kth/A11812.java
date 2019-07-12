package kth;

import java.io.*;
import java.util.ArrayList;

/**
 * 문제
 * 각 노드가 자식을 최대 K개 가질 수 있는 트리를 K진 트리라고 한다. 총 N개의 노드로 이루어져 있는 K진 트리가 주어진다.
 *
 * 트리는 "적은 에너지" 방법을 이용해서 만든다. "적은 에너지" 방법이란, 이전 깊이를 모두 채운 경우에만, 새로운 깊이를 만드는 것이고,
 *
 * 이 새로운 깊이의 노드는 가장 왼쪽부터 차례대로 추가 한다.
 *
 * 노드의 개수 N과 K가 주어졌을 때, 두 노드 x와 y 사이의 거리를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N (1 ≤ N ≤ 1015)과 K (1 ≤ K ≤ 1 000), 그리고 거리를 구해야 하는 노드 쌍의 개수 Q (1 ≤ Q ≤ 100 000)가 주어진다.
 *
 * 다음 Q개 줄에는 거리를 구해야 하는 두 노드 x와 y가 주어진다. (1 ≤ x, y ≤ N, x ≠ y)
 *
 * 출력
 * 총 Q개의 줄을 출력한다. 각 줄에는 입력으로 주어진 두 노드 사이의 거리를 출력한다.
 *
 * 예1
 * 7 2 3
 * 1 2
 * 2 1
 * 4 7
 *
 * 출력
 * 1
 * 1
 * 4

 */
public class A11812 {
    private static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        long nodeCount = Long.parseLong(inputs[0]);
        max = Long.parseLong(inputs[1]);
        long count = Long.parseLong(inputs[2]);

        TreeNode root = new TreeNode(1);
        for (int i = 1; i < nodeCount; i++) {
            root.addChildren(new TreeNode(i + 1));
        }
        for (int i = 0; i < count; i++) {
            String[] twoNode = br.readLine().split(" ");
            TreeNode n1 =  root.findByData(Integer.parseInt(twoNode[0]));
            TreeNode n2 =  root.findByData(Integer.parseInt(twoNode[1]));
            if (n1 == null || n2 == null) {
                break;
            }
            int weight = 0;
            // 높이를 같게
            while (n1.height != n2.height) {
                if (n1.height > n2.height) {
                    n1 = n1.parent;
                    weight++;
                }
                if (n1.height < n2.height) {
                    n2 = n2.parent;
                    weight++;
                }
            }
            // 같은 parent 를 가질 때 까지 증가.
            while (n1.data != n2.data) {
                n1 = n1.parent;
                weight++;
                n2 = n2.parent;
                weight++;
            }

            bw.write(weight + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class TreeNode{
        TreeNode parent;
        long data;
        long height;
        ArrayList<TreeNode> children = new ArrayList<>();

        TreeNode(int data) {
            this.data = data;
            this.height = 1;
        }

        void addChildren(TreeNode node) {
            if (this.children.size() == max) {
                // 형제 노드에 insert
                boolean success = false;
                if (this.parent != null) {
                    for(TreeNode n : this.parent.children) {
                        if (n.children.size() != max) {
                            node.parent = n;
                            node.height = n.height + 1;
                            n.children.add(node);
                            success = true;
                            break;
                        }
                    }
                }
                if (!success) {
                    TreeNode firstNode = children.get(0);
                    node.parent = firstNode;
                    node.height = firstNode.height + 1;
                    firstNode.addChildren(node);
                }
            } else {
                node.parent = this;
                node.height = this.height + 1;
                children.add(node);
            }
        }

        TreeNode findByData(long data) {
            if (this.data == data) {
                return this;
            }
            for (TreeNode child : children) {
                TreeNode result = child.findByData(data);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }
    }
}


