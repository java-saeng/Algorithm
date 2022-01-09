package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int A[][];
    static int ans;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int dp[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        sb.append(dfs(0, 0));
        System.out.println(sb);
        /*for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    static int dfs(int x, int y) {

        if(x == row - 1 && y == col - 1) {
            return 1;
        }

        if(dp[x][y] > -1){
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!isRangeTrue(X,Y)) continue;
            if(A[X][Y] < A[x][y]){
                dp[x][y] += dfs(X, Y);
            }
        }

        return dp[x][y];
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        A = new int[row][col];
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                A[i][j] = atoi(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }
}
