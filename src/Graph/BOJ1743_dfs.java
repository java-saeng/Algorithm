package Graph;

//BOJ 1743 음식물 피하기

/*
이 문제는 섬의 개수 문제를 풀었다면 쉽게 풀 수 있는 문제였다. 섬의 개수 문제는 대각선까지 포함시키지만, 이 문제는 가로, 세로만 경우를 두기 때문에 더욱 쉬운 문제였다.
단지 다른 점은 cnt가 1부터 시작한다는 점인 것 같다.
 */

import java.util.*;
import java.io.*;
public class BOJ1743_dfs {
    static boolean[][] visit;
    static int[][] ad;
    static int N; //행의 개수
    static int M; //열의 개수
    static int K; //간선의 개수
    static int dx[] = {0,0,1,-1};
    static int dy[] = {-1,1,0,0};
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max_size = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1][M+1];
        ad = new int[N+1][M+1];

        //입력
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            ad[t1][t2] = 1;
        }

        //dfs시작
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cnt = 1;
                if(!visit[i][j] && ad[i][j] == 1)
                    if(dfs(i,j) > max_size)
                        max_size = dfs(i,j);
            }
        }
        System.out.println(max_size);
    }

    static int dfs(int x, int y){
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(isRangeTrue(row,col) && !visit[row][col] && ad[row][col] == 1){
                dfs(row,col);
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isRangeTrue(int x, int y){
        return x > 0 && x <= N && y > 0 && y <= M;
    }
}