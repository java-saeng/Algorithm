package boj.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int A[][] = new int[10][10];
    static int paper[] = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        dfs(0, 0, 0);

        if(ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt) {
        if(x >= 9 && y > 9){
            ans = boj.Math.min(ans, cnt);
            return;
        }

        if(cnt >= ans) return;

        if(y > 9){
            dfs(x + 1, 0, cnt);
            return;
        }

        if(A[x][y] == 1){
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && checkPaper(x, y, i)) {
                    paper[i]--;
                    addPaper(x, y, i, 0);
                    dfs(x, y + 1, cnt + 1);
                    paper[i]++;
                    addPaper(x, y, i, 1);
                }
            }
        }
        else{
            dfs(x, y + 1, cnt);
        }
    }

    private static void addPaper(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                A[i][j] = state;
            }
        }
    }

    private static boolean checkPaper(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(!isRangeTrue(i,j) || A[i][j] == 0) return false;
            }
        }
        return true;
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }
    }
}
