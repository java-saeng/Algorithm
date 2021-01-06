package BFS;

//BOJ 7576 토마토

/*
토마토 3차원을 풀고 나니 이 문제는 쉽게 느껴졌다.
하지만 처음에는 큐를 static으로 선언하지 않고, bfs 메소드 안에 선언했다. 그러더니 한 케이스의 답이 나오질 않았다.
그래서 보니, 나는 for문을 이용하여 순차적으로 bfs를 대입하고 있던 것이다.
그래서 예제3을 돌려보면 정답이 9가 나온다. 왜냐하면 나는 처음 1만 넣고 bfs를 돌리고, 또, 마지막 1에 bfs를 돌렸기 때문이다.
하지만 처음 1과 마지막 1이 같이 bfs가 돌아야한다. 그래서 큐를 static 선언하여, ad배열에 숫자를 집어넣을 때, 1인 index를 바로 큐에 poll하였다.
그래서 다양한 문제가 있는 것을 깨닫고, 어디에는 큐를 static으로 선언해서 한 번에 하는지, 아니면 순차적으로 돌려도 되는지 유형별로 생각할 필요가 있는 것 같다.
 */

import java.io.*;
import java.util.*;

public class BOJ7576 {
    static int M,N;
    static int ad[][];
    static boolean visit[][];
    static int count = 0;
    static Queue<Po> q = new LinkedList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ad = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                ad[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(ad[i][j] == 1 && !visit[i][j]){
                    q.offer(new Po(i,j,0));
                    visit[i][j] = true;
                }
            }
        }

        bfs();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(ad[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        while(!q.isEmpty()){
            Po p1 = q.poll();
            count = Math.max(count, p1.depth);
            for(int i = 0; i < 4; i++){
                int rex = p1.x + dx[i];
                int rey = p1.y + dy[i];
                if(isRangeTrue(rex,rey) && ad[rex][rey] == 0 && !visit[rex][rey]){
                    q.offer(new Po(rex,rey,p1.depth+1));
                    visit[rex][rey] = true;
                    ad[rex][rey] = 1;
                }
            }
        }
    }

    static boolean isRangeTrue(int x, int y){
        return x > 0 && x <= N && y > 0 && y <= M;
    }
}

class Po{
    int x, y, depth;

    public Po(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
