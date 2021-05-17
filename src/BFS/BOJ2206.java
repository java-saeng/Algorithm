package BFS;

//BOJ 2206 벽 부수고 이동하기

import java.util.*;
import java.io.*;

public class BOJ2206{
    static int N, M;
    static int arr[][];
    static boolean visit[][][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M][2];
        // 세 번째 index가 0 이면 벽을 부수지 않고 온 상태
        // 세 번째 index가 1 이면 벽을 부수고 온 상태

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);


    }
    static void bfs(int x, int y){
        Queue<WallPoint> q = new ArrayDeque<>();
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        q.offer(new WallPoint(x, y, 1, 0));
        visit[x][y][0] = true;
        visit[x][y][1] = true;

        while(!q.isEmpty()){
            WallPoint wp = q.poll();

            if(wp.x == N - 1 && wp.y == M - 1){
                System.out.println(wp.count);
                //최단경로니까 도착하면 바로 끝내기
                return;
            }

            for(int i = 0; i < 4; i++){
                int X = wp.x + dx[i];
                int Y = wp.y + dy[i];
                /*
                1. 벽을 만날 경우 -> 이미 벽을 한 번 부수고 온 경우
                --> 이 경우는 큐에 넣지 않음
                2. 벽을 만날 경우 -> 벽을 아직 부수지 않았을 경우
                --> 이 경우는 현재 벽을 부수고, 방문 표시
                3. 벽이 없을 경우 -> 벽을 한 번 부수고 왔을 경우
                --> 방문했는지만 확인.
                4. 벽이 없을 경우 -> 벽을 안 부수고 왔을 경우
                --> 방문했는지만 확인.

                visit 3번쨰 index가 0이랑 1은 다르게 생각해야함.

                 */
                if(!isRangeTrue(X,Y)) continue; //범위를 넘어서면 넘겨

                if(arr[X][Y] == 1){ //벽이 있는 곳에 도착
                    if(wp.breakwall == 0 && !visit[X][Y][1]){
                        //벽을 부순 횟수가 0 이고, 이곳이 벽을 부순 상태에서 방문을 하지 않았는지
                        visit[X][Y][1] = true;
                        q.offer(new WallPoint(X, Y, wp.count + 1, 1));
                    }
                }
                else{   //벽이 없는 곳에 도착.
                    if(!visit[X][Y][wp.breakwall]){
                        //벽을 부순 상태인지 아닌지 몰라. 근데 방문하려는 곳이 벽이 없으니까 상관없어서 방문했는지 여부 판단.
                        q.offer(new WallPoint(X, Y, wp.count + 1, wp.breakwall));
                        visit[X][Y][wp.breakwall] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class WallPoint{
    int x, y, count, breakwall;

    WallPoint(int x, int y, int count, int breakwall){
        this.x = x;
        this.y = y;
        this.count = count; //이동 횟수
        this.breakwall = breakwall; //부순 벽의 갯수
    }
}