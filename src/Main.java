//BOJ 2178 미로 탐색

/*
이 문제를 처음으로 보면서 해야 할 생각이

1. 입력값들을 어떻게 처리하는지

2. 최소 경로를 어떻게 구해야할지이다.

첫 번째, 입력값들을 처리하기 위해서 나는 주어진 한 줄, 한 줄을 string으로 저장하여, char형으로 하나하나 뺀 뒤에 아스키코드를 이용하여 '0'을 빼주었다.

2. 최소 경로는 count[reX][reY] = count[X][Y] + 1을 이용하여 저장하였다. 이 말은 전에 있던 경로의 수에 하나를 더함으로써, 이때까지 들린 칸의(경로의) 개수를 나타낸다.

 */

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int ad[][];
    static boolean visit[][];
    static int count[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ad = new int[n][m];
        visit = new boolean[n][m];
        count = new int[n][m];

        count[0][0] = 1;

        for (int i = 0; i < n; i++) {
            String str = new String(br.readLine());
            for (int j = 0; j < m; j++) {
                ad[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(count[n-1][m-1]);


    }

    static void bfs(int x, int y){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;
        while(!q.isEmpty()){
            int X = q.poll();
            int Y = q.poll();
            if(X == n-1 && Y == m - 1) break;
            for(int i = 0; i < 4; i++){
                int reX = X + dx[i];
                int reY = Y + dy[i];
                if(isRangeTrue(reX,reY) && !visit[reX][reY] && ad[reX][reY] == 1){
                    q.offer(reX);
                    q.offer(reY);
                    visit[reX][reY] = true;
                    count[reX][reY] = count[X][Y] + 1;
                }
            }
        }
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}