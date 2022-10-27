package boj.bfs_dfs;

//BOJ 1926 그림

/*
처음에 이 문제를 제출했을 때, 틀렸던 이유는 minvalue를 0으로 설정해놓지 않고, Integer.MIN_VALUE로 했기 때문이다.
왜냐하면 문제에서 그림이 존재하지 않을 경우에 가장 넓은 그림의 넓이를 0이라고 설정했기 때문에,
만약 위와 같이 변수를 설정하고, 그림이 존재하지 않는다면 가장 넓은 그림은 Integer.MIN_VALUE값이 나오게 된다. 그래서 minvalue값을 처음에 0으로 설정해야 문제가 맞게 된다.
 */

import java.io.*;
import java.util.*;

public class BOJ1926 {
    static int n,m;
    static int ad[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int component = 0;
        int imagecount = 0;
        int minvalue = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ad = new int [n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                ad[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visit[i][j] && ad[i][j] == 1){
                    imagecount = bfs(i,j,0);
                    component++;
                    if(imagecount > minvalue)
                        minvalue = imagecount;
                }
            }
        }
        System.out.println(component);
        System.out.println(minvalue);
    }

    static int bfs(int x, int y, int count){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;
        count++;
        while(!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 4; i++) {
                int reX = X + dx[i];
                int reY = Y + dy[i];
                if (isRangeTrue(reX, reY) && ad[reX][reY] == 1 && !visit[reX][reY]) {
                    q.offer(reX);
                    q.offer(reY);
                    visit[reX][reY] = true;
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}