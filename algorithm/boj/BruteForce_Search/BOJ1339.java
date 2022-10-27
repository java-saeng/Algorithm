package boj.BruteForce_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ1339 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, max = Integer.MIN_VALUE;
    static String A[];
    static boolean visit[] = new boolean[10];
    static int possible[] = new int[26];
    static char arr[];
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();

        System.out.println(max);
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            String s = A[i];
            for (int j = 0; j < s.length(); j++) {
                set.add(s.charAt(j));
            }
        }

        arr = new char[set.size()];

        int idx = 0;

        for (char ch : set) {
            arr[idx++] = ch;
        }

        dfs(0);
    }

    static void dfs(int cnt) {
        if (cnt == set.size()) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += findNum(A[i]);
            }
            max = boj.Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            possible[arr[cnt] - 'A'] = i;
            dfs(cnt + 1);
            visit[i] = false;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new String[N];

        for (int i = 0; i < N; i++) A[i] = br.readLine();
    }

    static int findNum(String s) {
        int num = 0;

        for(int i = 0; i < s.length(); i++){
            num *= 10;
            num += possible[s.charAt(i) - 'A'];
        }

        /*
        이 부분으로 코드를 돌리면 틀리게 됨.
        boj.Math.pow(거듭제곱 해주는 얘)가 없으면 맞음. 있으면 틀림
        //O(8 * 8)
        for (int i = 0; i < s.length(); i++) {
            int idx = possible[s.charAt(i) - 'a'];
            if(idx == 0) idx = 1;
            else num += idx * boj.Math.pow(10, s.length() - i - 1);
        }*/

        return num;
    }
}