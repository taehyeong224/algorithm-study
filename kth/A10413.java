package kth;

import java.io.*;


/**
 * str :: 문자열이 들어갈 배열
 * t :: 단어의 위치를 보는 변수
 * n :: str 의 길이
 * g :: 그룹
 * tg :: 팀 그룹
 * SA :: Suffix Array
 */

public class A10413 {
    static int t;
    static int n;
    static int[] g;
    static int[] tg;
    static int[] sa;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            getSA(input);
            bw.write("\n");
        }
        bw.close();
        bw.flush();
        br.close();
    }

    private static void getSA(String str) {
        t = 1;
        n = str.length();
        char[] chs = str.toCharArray();

        //첫 글자에 의한 그룹을 정해주는 전처리
        for (int i = 0; i < n; i++) {
            sa[i] = i;
            g[i] = chs[i] - 'a';
        }

        //1,2,4,8... 씩 단어의 길이보다 작은 경우를 탐색
        while (t <= n)
        {
            g[n] = -1;
            sort(SA, SA + n, cmp);    //그룹에 의한 정렬
            tg[sa[0]] = 0;    //다음 그룹을 할당하기 위하여 tempgroup 의 첫번째 번호 배정

            //다음 그룹 배정
            for (int i = 1; i < n; i++)
            {
                //그룹이 다를 경우 다음 그룹 번호 할당
                if (cmp(sa[i - 1], sa[i]))
                    tg[sa[i]] = tg[sa[i - 1]] + 1;

                    //그룹이 같을 경우 같은 그룹 번호 할당
                else
                    tg[sa[i]] = tg[sa[i - 1]];
            }

            //새로운 그룹 할당
            for (int i = 0; i < n; i++)
                g[i] = tg[i];

            t <<= 1; // t *= 2;
        }
    }

    private static boolean cmp(int x, int y) {
        // 그룹 번호가 같으면
        if (g[x] == g[y])
            return g[x + t] < g[y + t];

        // 그룹 번호가 다르면
        return g[x] < g[y];
    }
}
