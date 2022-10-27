package boj.BruteForce_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int A[][];
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = boj.Math.max(ans, getLen(i, j));
            }
        }

        System.out.println((int) boj.Math.pow(ans, 2));
    }

    private static int getLen(int x, int y) {
        int len = boj.Math.min(row, col);
        int rel = 0;

        for (int i = 0; i < len; i++) {
            if (x + i < row && y + i < col) {
                if(A[x][y] == A[x+i][y] && A[x][y+i] == A[x+i][y+i]
                && A[x][y] == A[x+i][y+i]){
                    rel = boj.Math.max(rel, i + 1);
                }
            }
        }
        return rel;
    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        A = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }
    }
}
