package boj.bfs_dfs;

//BOJ 2606 바이러스

/*
dfs를 공부하고 처음으로 풀어본 문제이다. dfs개념 문제를 많이 풀어보고 난 뒤에 도전한 문제였다. 이 문제는 dfs 개념을 이해하는데 아주 적합한 문제였다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int nV; //정점 수
    static int nE; //간선 수
    static int[][] arr;
    static boolean[] visit;
    static int cnt = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nE = Integer.parseInt(st.nextToken());

        arr = new int[nV+1][nV+1];
        visit = new boolean[nV+1];

        for(int i = 0; i < nE; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            arr[s1][s2] = arr[s2][s1] = 1;
        }
        System.out.print(dfs(1));
    }
    public static int dfs(int i){
        visit[i] = true;
        cnt++;

        for(int j = 1; j < nV+1; j++){
            if(arr[i][j] == 1 && visit[j] == false)
                dfs(j);
        }
        return cnt;
    }
}
