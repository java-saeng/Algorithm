package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ18404 {
    static int N, M;
    static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int arr[][];
    static boolean visit[][];
    static int cnt[][];
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = atoi(st.nextToken());
        M = atoi(st.nextToken()); //적의 개수

        st = new StringTokenizer(br.readLine());

        int start = atoi(st.nextToken());
        int end = atoi(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        cnt = new int[N + 1][N + 1];

        bfs(start, end);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            sb.append(cnt[s1][s2] + " ");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 8; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];
                if(!isRangeTrue(dX,dY)) continue;
                if(visit[dX][dY]) continue;
                q.offer(dX);
                q.offer(dY);
                visit[dX][dY] = true;
                cnt[dX][dY] = cnt[X][Y] + 1;
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N;
    }
}
