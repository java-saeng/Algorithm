package bfs_dfs;

//BOJ 11724 연결 요소의 개수

/*
이 문제는 bfs함수를 int로 반환해주고, bfs가 돌아가면 1을 리턴해주고, bfs가 실행이 안되면 0을 리턴해주는 방식으로, component의 개수를 구했다.
 */

import java.io.*;
import java.util.*;

public class BOJ11724 {
    static int nV, nE;
    static int ad[][];
    static boolean visit[];
    static int component = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());

        ad = new int[nV+1][nV+1];
        visit = new boolean[nV+1];

        for(int i = 0; i < nE; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1][s2] = ad[s2][s1] = 1;
        }

        for(int i = 1; i <= nV; i++){
            component += bfs(i);
        }

        System.out.println(component);
    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        if(visit[start]) return 0;

        visit[start] = true;
        while(!q.isEmpty()){
            start = q.poll();
            for(int i = 1; i <= nV; i++){
                if(!visit[i] && ad[start][i] == 1) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
        return 1;
    }
}
