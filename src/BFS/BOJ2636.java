package BFS;

import java.util.*;
import java.io.*;

//BOJ 2636 치즈

public class BOJ2636 {
    static int row, col, cheese = 0, depth = 0, result;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        //이 코드를 보고 이해가 안가면 무조건 예제 그림을 손으로 하나씩
        //언제 q에 offer하고 poll하는지 체크해가면서 해야한다.
        //나도 하나하나 다 손으로 해본 뒤 이해가 갔다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cheese++;
            }
        }

        //치즈가 다 없어질 때까지 bfs를 돌린다.
        while(cheese != 0){
            depth++;
            //난 이 아래 부분이 정말 중요하다고 생각함.
            //왜냐하면 문제에서 치즈가 모두 없어지기 한 시간전에 치즈가 몇 개있는지 물어보는거임.
            //만약에 bfs를 돌리고 나서 치즈가 다 없으면 반복문이 끝나게 됨.
            //따라서 지금 이렇게 저장한 이유는 bfs를 돌리기 전의 치즈의 값을 저장함으로써
            //다른 조치를 취하지 않고 치즈가 모두 없어지기 1시간 전의 개수를 구할 수 있음
            result = cheese;
            bfs();
        }
        System.out.println(depth);
        System.out.println(result);

    }
    static void bfs(){
        Queue<CheesePoint> q = new ArrayDeque<>();

        visit = new boolean[row][col];
        q.offer(new CheesePoint(0, 0));
        visit[0][0] = true;
        while(!q.isEmpty()){
            CheesePoint cp = q.poll();
            for(int i = 0; i < 4; i++){
                int X = cp.x + dx[i];
                int Y = cp.y + dy[i];
                if(!isRangeTrue(X, Y)) continue;
                if(visit[X][Y]) continue;

                //0이면 그대로 q에 넣어줌
                if(arr[X][Y] == 0){
                    q.offer(new CheesePoint(X, Y));
                    visit[X][Y] = true;
                }
                //1이면 0으로 바꿔준 뒤 치즈를 하나 없앰
                else if(arr[X][Y] == 1){
                    arr[X][Y] = 0;
                    cheese--;
                    visit[X][Y] = true;
                }
            }
        }
    }
    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

class CheesePoint{
    int x, y;

    CheesePoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}



