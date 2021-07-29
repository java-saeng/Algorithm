package DFS;

import java.util.*;
import java.io.*;

//1번째 풀이
public class BOJ11403 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int rel[][];
    static int arr[][];
    static boolean visit[];
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        rel = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = atoi(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            //start시점마다 visit배열을 초기화
            visit = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                if(arr[i][j] == 1 && !visit[j])
                    dfs(i, j);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(rel[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int x, int y) {
        visit[y] = true;
        rel[x][y] = 1;

        for (int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            if(arr[y][i] == 0) continue;

            dfs(x, i);
        }
    }
}

//2번째 풀이
public class Main {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static int rel[][];
    static int arr[][];
    static boolean visit[];
    static boolean recur[];
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        rel = new int[N+1][N+1];
        arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = atoi(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            //start시점마다 visit배열을 초기화
            visit = new boolean[N + 1];
            recur = new boolean[N + 1];
            dfs(i);
            for (int j = 1; j <= N; j++) {
                if(visit[j]){ //recur 대신에 visit
                    rel[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(rel[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int start){
        for (int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            if(arr[start][i] == 0) continue;
            visit[i] = true;
            dfs(i);
        }
    }
}