package bfs_dfs;

//BOJ 1743 음식물 피하기

/*
이 문제는 여느 bfs문제와 비슷했다. 다만, 최소 경로 이런 것이 아니라 그 넓이의 최댓값을 비교하는 것이었다.
 */

import java.io.*;
import java.util.*;

public class BOJ1743 {
    static int width, height, garbage;
    static int ad[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxvalue = Integer.MIN_VALUE;
        int garbagevalue = 0;

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        garbage = Integer.parseInt(st.nextToken());

        ad = new int[width+1][height+1];
        visit = new boolean[width+1][height+1];

        for(int i = 0; i < garbage; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1][s2] = 1;
        }

        for(int i = 1; i <= width; i++){
            for(int j = 1; j <= height; j++){
                if(ad[i][j] == 1 && !visit[i][j]) {
                    garbagevalue = bfs(i, j);
                    if(garbagevalue > maxvalue){
                        maxvalue = garbagevalue;
                    }
                }
            }
        }
        System.out.println(maxvalue);

    }

    static int bfs(int start, int end){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        q.offer(end);
        visit[start][end] = true;
        count += 1;
        while(!q.isEmpty()){
            int X = q.poll();
            int Y = q.poll();
            for(int i = 0; i < 4; i++){
                int reX = X + dx[i];
                int reY = Y + dy[i];
                if(isRangeTrue(reX, reY) && !visit[reX][reY] && ad[reX][reY] == 1){
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
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}