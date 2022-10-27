package boj.bfs_dfs;

//BOJ 1260 DFS와 BFS

/*
이 문제는 한창 DFS 문제를 풀 때, 봤던 문제인데 BFS 공부를 하지 않아 풀지 못했던 문제이다. 그래서 이번에 BFS 공부를 했기 때문에 바로 풀어보았다.
처음에 잘못한 점은 문제를 똑바로 읽지 않았다는 것이다. 간선 입력을 할 때, 방향성이 있는 줄 알고, 문제를 풀어서 답이 계속 나오지 않아 뭐가 잘못된 건지를 몰랐다.
그러나 입력 마지막 부분에 주어지는 간선은 양방향이다.라는 것을 보고 아..라는 말이 나왔다.
그리고 출력의 시간을 줄이기 위해 System.out.print를 쓰기 보다는 이번에 StringBuilder를 이용해 출력을 해보았다.
그랬더니 채점 현황에서 볼 때 시간이 다른 코드에 비해 빨랐다.
이 문제를 풀면서 새롭게 알게된 점은 ArrayList를 정렬시키는 방법이다.
나는 이때까지 배열을 정렬하는 Arrays.sort만 알고 있었는데, 생각해보니 ArrayList는 어떻게 정렬을 해야 하나 생각을 들어 구글링을 하였다.
그랬더니 ArrayList는 컬렉션 프레임워크이기 때문에 Collections.sort(ArrayList arraylist)를 사용하면 되는 것을 알았다.
 */

import java.io.*;
import java.util.*;

public class BOJ1260 {
    static int N,M,V;
    static ArrayList<Integer>ad[];
    static boolean[] visit_dfs;
    static StringBuilder sb_dfs = new StringBuilder();
    static StringBuilder sb_bfs = new StringBuilder();
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());   //시작점

        ad = new ArrayList[N+1];
        visit_dfs = new boolean[N+1];
        for(int i = 1; i <= N; i++)
            ad[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            ad[t1].add(t2);
            ad[t2].add(t1);
        }

        for(int i = 1; i <= N; i++)
            Collections.sort(ad[i]);

        dfs(V);
        bfs(V);
        System.out.println(sb_dfs);
        System.out.println(sb_bfs);

    }

    public static void dfs(int start){
        sb_dfs.append(start + " ");
        visit_dfs[start] = true;
        for(int index : ad[start]){
            if(!visit_dfs[index]){
                //       sb_dfs.append(index + " ");
                dfs(index);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visit_bfs = new boolean[N+1];
        visit_bfs[start] = true;
        Q.add(start);
        while(!Q.isEmpty()){
            int element = Q.poll();
            sb_bfs.append(element + " ");
            for(int index : ad[element]){
                if(!visit_bfs[index]){
                    Q.add(index);
                    visit_bfs[index] = true;
                }
            }
        }
    }
}
