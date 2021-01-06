package DFS;

//BOJ 1012 유기농 배추

/*
이 문제도 전 문제들과 매우 유사한 문제여서 쉽게 풀었다.
나도 처음에는 dx[], dy[] 이것을 왜 쓰는지 몰랐다. 물론 이 문제는 이 방법을 쓰지 않아도 풀 수 있다.
하지만 다음 단계 문제를 보게 되면 상하좌우뿐만 아니라, 대각선까지 탐색해야 하는 문제가 나오게 된다.
그럴 때도 재귀 함수를 이용해 푼다면 STACKOVERFLOW가 나서 오류가 생기게 된다. 그래서 이 방법을 이해하고 나서, 이 방법만 사용한다.
나도 처음에 볼 땐 이해가 가질 않았다.
dx 배열 : -1 1 0 0
dy 배열 : 0 0 -1 1
이렇게 보고 세로로 보면 (-1,0) (1,0) (0,-1) (0,1)임을 알 수 있다. 이 의미는 그래프상에 보면 순서대로  좌 우 하 상을 나타낸다.
그래서 재귀 함수를 여러 번 돌릴 필요 없이 for문을 이용해서 x, y좌표를 옮겨서 풀면 된다.
 */

import java.util.*;
import java.io.*;
public class BOJ1012 {
    static boolean[][] visit;
    static int[][] ad;
    static int N,M,K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test_case = Integer.parseInt(st.nextToken());
        for(int i = 0; i < test_case; i++){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로길이
            N = Integer.parseInt(st.nextToken()); //세로길이
            K = Integer.parseInt(st.nextToken()); //배추개수
            visit = new boolean[M][N];
            ad = new int[M][N];
            for(int locate = 0; locate < K; locate++){
                st = new StringTokenizer(br.readLine());
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());
                ad[t1][t2] = 1;
            }
            for(int op1 = 0; op1 < M; op1++){
                for(int op2 = 0; op2 < N; op2++){
                    if(!visit[op1][op2] && ad[op1][op2] == 1) {
                        dfs(op1, op2);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        int []dx = {-1,1,0,0};
        int []dy = {0,0,-1,1};
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(isRangeTrue(row,col) && !visit[row][col] && ad[row][col] == 1) {
                dfs(row, col);
            }
        }

    }

    static boolean isRangeTrue(int x, int y){
        return (x >= 0 && x < M && y >=0 && y < N );
    }
}
