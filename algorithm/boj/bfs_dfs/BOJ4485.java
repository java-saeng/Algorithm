package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ4485 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int arr[][];
    static int dist[][];
    static final int INF = Integer.MAX_VALUE;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = 1;
        while(true) {
            N = atoi(br.readLine());

            if(N == 0) break;

            arr = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = atoi(st.nextToken());
                }
            }
            bfs(0, 0);

            sb.append("Problem " + test + ": " + dist[N - 1][N - 1]).append("\n");
            test++;
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = INF;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        dist[x][y] = arr[x][y];

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];

                if(!isRangeTrue(dX,dY)) continue;
                if(dist[X][Y] + arr[dX][dY] >= dist[dX][dY]) continue;

                dist[dX][dY] = dist[X][Y] + arr[dX][dY];
                q.offer(dX);
                q.offer(dY);
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}