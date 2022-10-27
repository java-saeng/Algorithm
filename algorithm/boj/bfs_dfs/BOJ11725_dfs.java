package boj.bfs_dfs;

//BOJ 11725 트리의 부모 찾기

/*
이 문제는 dfs 알고리즘을 풀면서 처음으로 혼자 힘으로 풀어냈다.
노드 그래프를 그리고 어떻게 해결해야 할지 생각했다. 처음에는 인접 리스트를 사용해서 가장 작은 숫자가 부모 노드일 줄 알았는데 바로 반례가 생각이 나서 그게 아니라 끊임없이 생각했다.
그러면 dfs를 통해서 노드를 지나치기 때문에, 그때의 노드를 result라는 배열에 사용해서 index를 result의 index에 넣고 그때의 노드를 값으로 집어넣는 것이다.
왜냐하면 그 때의 dfs에서 num이 자신의 부모 노드이기 때문이다.
 */

import java.util.*;
import java.io.*;

public class BOJ11725_dfs {
    static boolean[]visit;
    static ArrayList<Integer> []ad;
    static int result[];
    static int nV; //노드의 개수
    static int nE; //간선

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken()); //노드의 개수

        visit = new boolean[nV+1];
        ad = new ArrayList[nV+1];
        result = new int[nV+1];

        for(int i = 1; i <= nV; i++)
            ad[i] = new ArrayList<>();

        for(int i = 1; i < nV; i++){
            st = new StringTokenizer(br.readLine());

            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            ad[t1].add(t2);
            ad[t2].add(t1);
        }
        dfs(1);
        for(int i = 2; i <= nV; i++)
            System.out.println(result[i]);
    }

    static void dfs(int num){
        visit[num] = true;
        for(int index : ad[num]){
            if(!visit[index]) {
                result[index] = num;
                dfs(index);
            }
        }
    }
}
