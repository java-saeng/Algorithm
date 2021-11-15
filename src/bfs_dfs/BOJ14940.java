package bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ14940 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int n, m;
    static int A[][];
    static int count[][];
    static boolean visit[][];
    static Queue<Integer> q = new ArrayDeque<>();
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        pro();
        print();
    }

    static void pro() {

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if(!isRangeTrue(X,Y)) continue;
                if(visit[X][Y]) continue;
                if(A[X][Y] == 0) continue;

                q.offer(X);
                q.offer(Y);
                visit[X][Y] = true;
                count[X][Y] = count[x][y] + 1;
            }
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(A[i][j] != 0 && !visit[i][j]) sb.append(-1).append(" ");
                else sb.append(count[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = atoi(st.nextToken());
        m = atoi(st.nextToken());

        A = new int[n][m];
        count = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = atoi(st.nextToken());
                if(A[i][j] == 2) {
                    q.offer(i);
                    q.offer(j);
                    visit[i][j] = true;
                }
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 & x < n && y >= 0 && y < m;
    }
}
