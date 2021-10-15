package bfs_dfs;

//BOJ 11724 연결 요소의 개수

/*
이 문제를 쉽게 풀 수 있었던 이유는 dfs 기초를 하면서 연습했기 때문이다. 대신에 다른 점이 있다면 시간 복잡도에 따른 풀이 방법이다.
 시간제한 3초에 N이 1 ~ 1000 까지였고 , M 은 N*(N-1)/2 까지였다. 그래서 이차원 배열로 풀었을 때 아마 O(VE)가 3초를 넘어섰기 때문에 인접 리스트를 사용해서 풀었다.
 */

import java.util.*;
import java.io.*;

public class BOJ11724_dfs {
    static ArrayList<Integer> [] ad;
    static boolean[] visit;
    static int nV, nE;
    static int component = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());

        visit = new boolean[nV+1];
        ad = new ArrayList[nV+1];

        for(int i = 1; i <= nV; i++){
            ad[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < nE; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            ad[t1].add(t2);
            ad[t2].add(t1);
        }
        dfs_count();
        System.out.print(component);
    }
    static void dfs_count(){
        for(int i = 1; i <= nV; i++){
            if(!visit[i]){
                dfs(i);
                component++;
            }
        }
    }

    static void dfs(int start){
        visit[start] = true;

        for(int index : ad[start]){
            if(!visit[index]){
                dfs(index);
            }
        }
    }
}