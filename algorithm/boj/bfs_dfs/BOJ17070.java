package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ17070 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int A[][];
    static int ans;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        dfs(new Pipe(1, 0, 1));

        System.out.println(ans);
    }

    static void dfs(Pipe p) {
        if(p == null) return;
        //status 1이면 가로 0이면 세로 -1이면 대각선
        if(p.x == N - 1 && p.y == N - 1){
            ans++;
            return;
        }

        if(p.status == 1){
            dfs(goRight(p));
            dfs(goDiag(p));
        }
        else if(p.status == 0){
            dfs(goDiag(p));
            dfs(goDown(p));
        }
        else if(p.status == -1){
            dfs(goRight(p));
            dfs(goDown(p));
            dfs(goDiag(p));
        }
    }

    static Pipe goRight(Pipe p) {
        if(isRangeTrue(p.x, p.y+1) && A[p.x][p.y+1] != 1)
            return new Pipe(1, p.x, p.y + 1);
        return null;
    }

    static Pipe goDown(Pipe p){
        if(isRangeTrue(p.x+1, p.y) && A[p.x+1][p.y] != 1)
            return new Pipe(0, p.x+1, p.y);
        return null;
    }

    static Pipe goDiag(Pipe p){
        if(isRangeTrue(p.x+1, p.y+1) && A[p.x+1][p.y+1] != 1 && A[p.x+1][p.y] != 1 && A[p.x][p.y+1] != 1)
            return new Pipe(-1, p.x + 1, p.y + 1);
        return null;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }
    }

    static class Pipe{
        int status, x, y;

        public Pipe(int status, int x, int y) {
            this.status = status;
            this.x = x;
            this.y = y;
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

