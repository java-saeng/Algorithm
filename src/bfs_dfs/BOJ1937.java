package bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ1937 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int n;
    static int A[][];
    static int dist[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        int rel = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rel = Math.max(rel, dfs(i, j));
            }
        }

        System.out.println(rel);
    }

    static int dfs(int x, int y) {
        if(dist[x][y] != 0){
            return dist[x][y];
        }

        dist[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!isRangeTrue(X,Y)) continue;
            if(A[X][Y] <= A[x][y]) continue;

            dist[x][y] = Math.max(dist[x][y], dfs(X,Y)+1);
        }

        return dist[x][y];
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = atoi(br.readLine());

        dist = new int[n][n];
        A = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
