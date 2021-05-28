package BackTracking;


//BOJ 21772 가희의 고구마 먹방

import java.util.*;
import java.io.*;

public class BOJ21772 {
    static int row, col, time;
    static char arr[][];
    static boolean visit[][];
    static int result = 0;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        DPoint dp = null;
        arr = new char[row][col];
        visit = new boolean[row][col];


        for(int i = 0; i < row; i++){
            String str = br.readLine();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'G'){
                    dp = new DPoint(i, j, 0);
                    //강아지가 있는 좌표 찍기
               }
            }
        }

        dfs(dp, 0);
        System.out.println(result);
    }
    static void dfs(DPoint dp, int count){
        if(dp.depth == time ){
            result = Math.max(result, count);
            return;
        }
        int x = dp.x;
        int y = dp.y;
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            //1. visit가 true라 해도 벽만 아니면 그냥 지나갈 수 있다.
            //2. visit가 방문이어도 벽만 아니면 다시 재귀로
            //3. 최초방문일 때만 count + 1
            //4. 한번 방문했던 곳은 시간만 늘려준다.
            int X = x + dx[i];
            int Y = y + dy[i];
            if(!isRangeTrue(X, Y)) continue;
            //장애물만 아니면 지나갈 수 있다.

            if(arr[X][Y] == '#') continue;

            //방문을 했을 경우에는 지나는 갈 수 있다. 그래서 depth + 1만 --> 2번 해결
            //방문을 했을 경우에는 S든 G든 . 든 상관 X --> 2번, 4번

            if(visit[X][Y]){
                dfs(new DPoint(X, Y, dp.depth + 1), count);
            }
            //방문하지 않았을 경우
            //S이면 count + 1을 해주어야함
            //.이나 G면 방문표시하고 depth + 1

            else{
                if(arr[X][Y] == 'S'){
                    //최초방문일 떄만 count + 1 ---> 3번 해결
                    dfs(new DPoint(X, Y, dp.depth + 1), count + 1);
                    visit[X][Y] = false;
                }
                else{
                    dfs(new DPoint(X, Y, dp.depth + 1), count);
                }
            }

        }
    }
    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
class DPoint{
    int x, y, depth;
    DPoint(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}