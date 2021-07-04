package BFS;

//BOJ 16928 뱀과 사다리 게임

import java.util.*;
import java.io.*;

public class BOJ16928 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static boolean visit[] = new boolean[101];
    static int count[] = new int[101];
    static int block[] = new int[101];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r_size = atoi(st.nextToken());
        int s_size = atoi(st.nextToken());

        for(int i = 0; i < r_size+s_size; i++){
            st = new StringTokenizer(br.readLine());
            int start = atoi(st.nextToken());
            int end = atoi(st.nextToken());
            block[start] = end;
        }
        ////////////////////////////////////////////////입력 끝

        bfs();

    }
    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visit[1] = true;

        while(!q.isEmpty()){
            int element = q.poll();

            if(element == 100){
                System.out.print(count[100]);
                return;
            }

            for(int i = 0; i < 6; i++){
                int X = element + ( i + 1 );
                if(!isRangeTrue(X)) continue;
                if(visit[X]) continue;
                visit[X] = true;

                if(block[X] != 0){
                    if(!visit[block[X]]) {
                        q.offer(block[X]);
                        visit[block[X]] = true;
                        count[block[X]] = count[element] + 1;
                    }
                }
                else {
                    q.offer(X);
                    count[X] = count[element] + 1;
                }
            }
        }
    }
    static boolean isRangeTrue(int x){
        return x < 101;
    }
}