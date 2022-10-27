package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ1600 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int K, row, col;
    static int A[][];
    static boolean visit[][][];
    static int dx[] = {-1, 1, 0, 0, 1, 1, -1, -1, 2, 2, -2, -2};
    static int dy[] = {0, 0, 1, -1, 2, -2, 2, -2, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if(p.x == row - 1 && p.y == col - 1){
                System.out.println(p.cnt);
                return;
            }

            for (int i = 0; i < 12; i++) {
                int X = p.x + dx[i];
                int Y = p.y + dy[i];

                if(!isRangeTrue(X,Y)) continue;
                if(A[X][Y] == 1) continue;

                if (i >= 4) {
                    if (p.k < K && !visit[X][Y][p.k + 1]) {
                        q.offer(new Point(X, Y, p.cnt + 1, p.k + 1));
                        visit[X][Y][p.k + 1] = true;
                    } else continue;
                }
                else{
                    if (!visit[X][Y][p.k]) {
                        q.offer(new Point(X, Y, p.cnt+1, p.k));
                        visit[X][Y][p.k] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = atoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        col = atoi(st.nextToken());
        row = atoi(st.nextToken());

        A = new int[row][col];
        visit = new boolean[row][col][K + 1];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    static class Point{
        int x, y, cnt, k;

        public Point(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }
}

