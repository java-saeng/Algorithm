package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ1261 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int A[][];
    static int dist[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        bfs();
        System.out.println(dist[row - 1][col - 1]);
    }

    static void bfs() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        q.offer(0);
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int dX = x + dx[i];
                int dY = y + dy[i];

                if(!isRangeTrue(dX, dY)) continue;
                if(dist[x][y] + A[dX][dY] >= dist[dX][dY]) continue;

                dist[dX][dY] = dist[x][y] + A[dX][dY];
                q.offer(dX);
                q.offer(dY);
            }
        }
/*        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = atoi(st.nextToken());
        row = atoi(st.nextToken());

        dist = new int[row][col];
        A = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }
    }
}