package bfs_dfs;

//BOJ 3184 양

/*
이 문제는 다른 문제와 비슷한 방법으로 bfs을 이용하였다.
다른 점이 한 가지 있다면, 배열의 값이 int가 아니라 char을 이용한 것이다.
그리고 변수 설정을 총 양, 총 늑대 수, 한 area당 양 수, 늑대 수로 하였다.
그리고 bfs 실행할 때마다 늑대 수, 양 수를 0으로 초기화시켜주는 것이 포인트라고 생각한다.
 */

import java.io.*;
import java.util.*;

public class BOJ3184 {
    static int row,col;
    static char ad[][];
    static boolean visit[][];
    static int cntO = 0;
    static int cntV = 0;
    static int total_cntO = 0;
    static int total_cntV = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        ad = new char[row][col];
        visit = new boolean[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < col; j++){
                ad[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(ad[i][j] != '#' && !visit[i][j]) {
                    cntO = 0;
                    cntV = 0;
                    bfs(i, j);
                }
            }
        }

        System.out.print(total_cntO + " " + total_cntV);
        //1. bfs를 #이 아닌 곳으로 탐색
        //2. 그래서 탐색하는 중에 양을 만나면 cntO을 증가, 늑대를 만나면 cntV를 증가
        //3. 그래서 total_cntO 와 total_cntV 변수 할당해서 많은걸 +시켜줌.
        //4. 그리고 갓던곳에서 bfs가 끝나면 cntO와 cntV를 0으로 초기화해줌

    }

    static void bfs(int start, int end){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        q.offer(end);
        visit[start][end] = true;
        while(!q.isEmpty()){
            start = q.poll();
            end = q.poll();
            if(ad[start][end] == 'o')
                cntO++;
            else if(ad[start][end] == 'v')
                cntV++;
            for(int i = 0; i < 4; i++){
                int X = start + dx[i];
                int Y = end + dy[i];
                if(isRangeTrue(X,Y) && ad[X][Y] != '#' && !visit[X][Y]){
                    q.offer(X);
                    q.offer(Y);
                    visit[X][Y] = true;
                }
            }
        }
        if(cntV >= cntO)
            total_cntV += cntV;
        else
            total_cntO += cntO;
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < row && y >= 0 && y <col;
    }
}
