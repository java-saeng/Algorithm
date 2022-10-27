package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16973 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col, hei, wid;
    static int A[][];
    static Info start = null, end = null;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static boolean visit[][];
    static int ans = -1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        bfs();

        if(sb.length() == 0) sb.append(-1);

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Info> q = new ArrayDeque<>();
        q.offer(start);
        visit[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Info info = q.poll();

            if(info.x == end.x && info.y == end.y){
                sb.append(info.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int X = info.x + dx[i];
                int Y = info.y + dy[i];

                if(X < 1 || X > row || Y < 1 || Y > col) continue;

                if(!visit[X][Y] && A[X][Y] == 0){
                    if(!isRangeTrue(X, Y)) continue;

                    q.offer(new Info(X, Y, info.cnt + 1));
                    visit[X][Y] = true;
                }
            }
        }
    }



    static boolean isRangeTrue(int x, int y) {
        int X = x + hei - 1;
        int Y = y + wid - 1;
        if(X > row || Y > col) return false;

        for (int i = x; i <= X; i++) {
            for (int j = y; j <= Y; j++) {
                if(A[i][j] == 1) return false;
            }
        }

        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        A = new int[row + 1][col + 1];
        visit = new boolean[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        hei = atoi(st.nextToken());
        wid = atoi(st.nextToken());
        start = new Info(atoi(st.nextToken()), atoi(st.nextToken()), 0);
        end = new Info(atoi(st.nextToken()), atoi(st.nextToken()), 0);
    }

    static class Info{
        int x, y, cnt;

        public Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}