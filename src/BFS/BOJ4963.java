package BFS;

//BOJ 4963 섬의 개수

import java.io.*;
import java.util.*;

public class BOJ4963 {
    static int w,h;
    static int ad[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            int island = 0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            ad = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    ad[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(ad[i][j] == 1 && !visit[i][j]){
                        bfs(i,j);
                        island++;
                    }
                }
            }
            System.out.println(island);
        }
    }

    static void bfs(int x, int y){
        int dx[] = {-1,-1,-1,0,0,1,1,1};
        int dy[] = {1,-1,0,1,-1,1,-1,0};
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;
        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for(int i = 0; i < 8; i++){
                int X = x + dx[i];
                int Y = y + dy[i];
                if(isRangeTrue(X, Y) && ad[X][Y] == 1 && !visit[X][Y]){
                    q.offer(X);
                    q.offer(Y);
                    visit[X][Y] = true;
                }
            }
        }
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}
