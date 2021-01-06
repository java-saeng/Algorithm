package BFS;

// BOJ 7569 숨바꼭질

/*
이 문제는 내가 직접 풀다가 못 풀어서 도움을 받아 푼 문제이다.
처음에는 런타임 에러가 뜨고, 수정하고 나선 메모리 초과가 났다. 메모리 초과가 왜 나는지에 대해 풀지 못해 이 문제를 해결하지 못한 것 같다.
생각해보면 3차원 사용, 6가지 방향까진 생각이 났는데 나머지 부분이 생각나지 않았다. 보면 ad 차원 배열에 수를 대입하면서 1인 수를 전역 큐에 offer하고, visit true를 해준다.
그리고 bfs를 parameter 없이 그냥 돌린다. bfs에는 Point형 변수를 선언하여 큐에서 poll하고, count 변수는 며칠이 걸리는지, point.depth와 count 중 최댓값을 비교한 것이다.
왜냐하면 만약 depth가 그대로 0이면 처음부터 익을 토마토가 없다는 뜻이다.
그리고 depth는 날짜를 의미하고 점점 갈수록 1씩 늘어나는 것이, Point형 자료가 한 개씩 늘어날 때마다 1일씩 늘어나기 때문이다.
 */

import java.util.*;

public class BOJ7569 {
    static int row,col,myeon;
    static int ad[][][];
    static boolean visit[][][];
    static Queue<Point> q = new LinkedList<>();
    static int count = 0;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        col = s.nextInt();
        row = s.nextInt();
        myeon = s.nextInt();

        ad = new int[myeon+1][row+1][col+1];
        visit = new boolean[myeon+1][row+1][col+1];

        for(int i = 1; i <= myeon; i++){
            for(int j = 1; j <= row; j++){
                for(int k = 1; k <= col; k++){
                    ad[i][j][k] = s.nextInt();
                    if(ad[i][j][k] == 1) {
                        q.offer(new Point(i, j, k, 0));
                        visit[i][j][k] = true;
                    }
                }
            }
        }

        bfs();

        for(int i = 1; i <= myeon; i++){
            for(int j = 1; j <= row; j++){
                for(int k = 1; k <= col; k++){
                    if(ad[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(count);

    }
    static void bfs(){
        int dx[] = {-1,1,0,0,0,0};
        int dy[] = {0,0,-1,1,0,0};
        int dz[] = {0,0,0,0,1,-1};
        while(!q.isEmpty()){
            Point point = q.poll();
            count = Math.max(count, point.depth);
            for(int i = 0; i < 6; i++){
                int rex = point.x + dx[i];
                int rey = point.y + dy[i];
                int rez = point.z + dz[i];
                if(isRangeTrue(rex,rey,rez) && ad[rex][rey][rez] == 0){
                    q.offer(new Point(rex,rey,rez,point.depth+1));
                    ad[rex][rey][rez] = 1;
                    visit[rex][rey][rez] = true;
                }
            }
        }
    }

    static boolean isRangeTrue(int x, int y, int z){
        return x > 0 && x <= myeon && y > 0 && y <= row && z > 0 && z <= col;
    }


}

class Point{
    int x;
    int y;
    int z;
    int depth;

    public Point(int x, int y, int z, int depth){
        this.x = x;
        this.y = y;
        this.z = z;
        this.depth = depth;
    }
}