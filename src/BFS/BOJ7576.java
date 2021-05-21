package BFS;

//BOJ 7576 토마토

/*
이 문제를 저번에 풀어본 적이 있어서 다시 푸는데 어려움은 없었다. 아마 다른 점은 인접 행렬을 구현할 때, 최대 크기 + 1로 해주었냐 이 차이인 것 같다.
복기하자면, bfs에서 최단경로를 구할 때에는 x, y좌표를 나타내는 class에서 count변수도 같이 추가해주면 좋다. 하지만 이 문제를 처음에 생각하면서 시간 복잡도를 생각해보았다.
인접 행렬을 이용하여 구현한 bfs는 O(n * m)이다. 그러나 여기서 bfs로 구현한 뒤, arr 값에 0이 있는지 없는지 탐색을 해야 한다. 그래서 O(n * m)이 된다.
따라서, TLE가 날 줄 알았는데 나지 않았다. 아마 for문 안에서 한 번에 돌리지 않고 따로 돌려서 그런 것 같다.
 */

import java.io.*;
import java.util.*;

public class BOJ7576{
    static int arr[][];
    static boolean visit[][];
    static int row, col;
    static Queue<TomatoPoint> q = new ArrayDeque<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 --> 여기서 row col을 반대로 줌
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        //상하좌우 이동
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        int cnt = 0;

        //배열 객체 생성
        arr = new int[row][col];
        visit = new boolean[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 1)
                    //아마 처음에 큐에 넣으니까 1부터 시작해야할듯
                    //동시에 토마토가 익으니까 큐에 바로 집어넣어줌
                    q.offer(new TomatoPoint(i, j, 1));
            }
        }

        //인접 행렬로 해서 시간복잡도 O(nm)
        while(!q.isEmpty()){
            TomatoPoint tp = q.poll();
            visit[tp.x][tp.y] = true;
            for(int i = 0; i < 4; i++){
                int X = tp.x + dx[i];
                int Y = tp.y + dy[i];
                if(isRangeTrue(X, Y) && !visit[X][Y] && arr[X][Y] == 0){
                    q.offer(new TomatoPoint(X, Y, tp.count + 1));
                    visit[X][Y] = true;
                    arr[X][Y] = 1;
                    //cnt 구하는 방법이 생각이 안남. 그래서 이거라도 했음. 다른 방법 찾아봐야겠다.
                    cnt = Math.max(cnt, tp.count);
                }
            }
        }

        //여기서 탐색 O(nm)
        for(int index1[] : arr){
            for(int index2 : index1){
                if(index2 == 0){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

class TomatoPoint{
    int x, y, count;
    TomatoPoint(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}