package bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ17836 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M, T;
    static int A[][];
    static boolean visit[][][]; //0이면 그람없이 1이면 그람있이
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        bfs();

        if(ans == Integer.MAX_VALUE) System.out.println("Fail");
        else System.out.println(ans);
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if(p.x == N - 1 && p.y == M - 1){
                if(p.cnt <= T) ans = Math.min(ans, p.cnt);
                return;
            }

            if(A[p.x][p.y] == 2) p.gram = 1;

            for (int i = 0; i < 4; i++) {
                int X = p.x + dx[i];
                int Y = p.y + dy[i];

                if(!isRangeTrue(X,Y)) continue;

                if(p.gram == 0){
                    if(visit[X][Y][0]) continue;
                    if(A[X][Y] == 1) continue;

                    q.offer(new Point(X, Y, p.cnt + 1, p.gram));
                    visit[X][Y][0] = true;
                }
                else{
                    if(visit[X][Y][1]) continue;

                    q.offer(new Point(X, Y, p.cnt + 1, p.gram));
                    visit[X][Y][1] = true;
                }
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        T = atoi(st.nextToken());

        A = new int[N][M];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Point{
        int x, y, cnt, gram;

        public Point(int x, int y, int cnt, int gram) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.gram = gram;
        }
    }
}


