package boj.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, ans = Integer.MIN_VALUE;
    static int A[];
    static char op[];
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        dfs(A[0], 0);

        System.out.println(ans);
    }

    static void dfs(int val, int idx) {
        if(idx >= op.length){
            ans = boj.Math.max(ans, val);
            return;
        }

        //괄호 없을 때 앞에서부터 계산
        int rel1 = calcul(val, A[idx+1], op[idx]);
        dfs(rel1, idx + 1);

        //괄호 있다고 생각
        if (idx + 1 < op.length) {
            int rel2 = calcul(A[idx + 1], A[idx + 2], op[idx + 1]);

            dfs(calcul(val, rel2, op[idx]), idx + 2);
        }
    }

    static int calcul(int num1, int num2, char op) {
        if(op == '+') return num1 + num2;
        else if(op == '-') return num1 - num2;
        return num1 * num2;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new int[N / 2 + 1];
        op = new char[N / 2];

        String str = br.readLine();
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < N; i++) {
            char ch = str.charAt(i);

            if(i % 2 == 0) A[idx1++] = ch - '0';
            else op[idx2++] = ch;
        }
    }
}