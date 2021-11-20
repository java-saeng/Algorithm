package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, row, col;
    static int ans;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        z(row, col, (int) Math.pow(2, N));

        System.out.println(ans);
    }

    static void z(int row, int col, int len) {
        if(len == 1) return;

        if(row < len / 2 && col < len / 2){
            z(row, col, len / 2);
        }
        else if (row < len / 2 && col >= len / 2) {
            ans += (len * len / 4);
            z(row, col - len / 2, len / 2);
        }
        else if(row >= len / 2 && col < len / 2){
            ans += (len * len / 4) * 2;
            z(row - len / 2, col, len / 2);
        }
        else{
            ans += (len * len / 4) * 3;
            z(row - len / 2, col - len / 2, len / 2);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        row = atoi(st.nextToken());
        col = atoi(st.nextToken());
    }
}