package boj.bfs_dfs;

//BOJ 7562 나이트의 이동

/*
처음에 문제를 풀면서 dx[]를 초기화할 때, 값을 -2 -2를 하지 않고 2 2를 해서 계속 틀렸다.
그래서 이 부분을 간과하고 다른 부분에서 틀린 곳이 없는데 계속해서 찾아내려고 했다.
다시 처음부터 코드를 읽어보니 그 부분이 잘못됐다는 걸 보고, 수정했더니 맞았다.
다음부터는 이런 부분에서 실수를 없도록 해야한다.

 이 문제를 풀면서 count[X][Y] = count[currentX][currentY] + 1 이 부분이 중요하다고 생각된다.
 왜냐하면 한 번 이동하고 나서 이 X Y 가 다음 이동하는 좌표, current가 현재 있는 좌표를 계속해서 수정해나가기 때문이다.
 */

import java.io.*;
import java.util.*;

public class BOJ7562 {
    static int count[][];
    static boolean visit[][];
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());

        for(int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            visit = new boolean[size][size];
            count = new int[size][size];

            for(int v = 0; v < size; v++){
                for(int w = 0; w < size; w++)
                    count[v][w] = 0;
            }

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(startX,startY,endX,endY);
            System.out.println(count[endX][endY]);
        }
        //1. count[X][Y] = count[startx][starty] + 1
        //2. 만약에 X Y 가 end x 와 end y 가 같아질 때 조건이 있음.
        //3. count[endx][endy] < count[X][Y] 일때, 대입을 하는거지.
        //4.
    }

    static void bfs(int startx, int starty, int endx, int endy){
        int dx[] = {2,2,1,1,-1,-1,-2,-2};
        int dy[] = {-1,1,2,-2,2,-2,-1,1}; //나이트가 이동할 수 있는 x y 좌표
        Queue<Integer> q = new LinkedList<>();
        q.offer(startx);
        q.offer(starty);
        visit[startx][starty] = true;
        while(!q.isEmpty()){
            int currentX = q.poll();
            int currentY = q.poll();
            if(currentX == endx && currentY == endy){
                break; //목적지와 현재있는 위치가 같으면 break함
            }
            for(int i = 0; i < 8; i++){
                int X = currentX + dx[i];
                int Y = currentY + dy[i];
                if(isRangeTrue(X, Y) && !visit[X][Y]){
                    q.offer(X);
                    q.offer(Y);
                    visit[X][Y] = true;
                    count[X][Y] = count[currentX][currentY] + 1; //나이트가 현재 있는 위치에서 다음 index에 해당하는 값에 1을 더함
                }
            }
        }
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
