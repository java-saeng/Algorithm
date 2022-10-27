package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1726 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int A[][];
    static boolean visit[][][];
    static Info start = null, end = null;
    static int dx[] = {0, 0, 0, 1, -1};
    static int dy[] = {0, 1, -1, 0, 0};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        bfs();

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Info> q = new ArrayDeque<>();
        q.offer(start);
        visit[start.x][start.y][start.status] = true;

        while (!q.isEmpty()) {
            Info info = q.poll();

            if (info.x == end.x && info.y == end.y && info.status == end.status) {
                ans = boj.Math.min(ans, info.cnt);
                continue;
            }

            //현재 바라보는 방향으로 1, 2, 3만큼 이동
            for (int i = 1; i <= 3; i++) {
                int dX = info.x + i * dx[info.status];
                int dY = info.y + i * dy[info.status];

                if(!isRangeTrue(dX,dY)) continue;
                if(visit[dX][dY][info.status]) continue;
                if(A[dX][dY] == 1) break;

                q.offer(new Info(dX, dY, info.status, info.cnt + 1));
                visit[dX][dY][info.status] = true;
            }

            //방향만 움직이기
            for (int i = 1; i <= 4; i++) {
                if(!visit[info.x][info.y][i] && i != info.status)
                if(i + info.status == 3 || i + info.status == 7){
                    q.offer(new Info(info.x, info.y, i, info.cnt + 2));
                    visit[info.x][info.y][i] = true;
                }
                else{
                    q.offer(new Info(info.x, info.y, i, info.cnt + 1));
                    visit[info.x][info.y][i] = true;
                }
            }
        }
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
        visit = new boolean[row][col][5];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Info(atoi(st.nextToken()) - 1, atoi(st.nextToken()) - 1, atoi(st.nextToken()),0);
        st = new StringTokenizer(br.readLine());
        end = new Info(atoi(st.nextToken()) - 1, atoi(st.nextToken()) - 1, atoi(st.nextToken()),0);
    }


    static class Info{
        int x, y, status, cnt;

        public Info(int x, int y, int status, int cnt) {
            this.x = x;
            this.y = y;
            this.status = status;
            this.cnt = cnt;
        }
    }
}
