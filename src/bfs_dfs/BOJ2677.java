package bfs_dfs;

//BOJ 2677 단지번호 붙이기

/*
이 문제는 옛날에 dfs를 이용하여 문제를 해결했다. 그래서 이번에는 bfs를 이용하여 문제를 풀어보았다.
문제를 풀면서 조금 애먹은 부분은 bfs 메소드를 구현하는 중에 while문에서 큐에 element를 언제 집어넣고 언제 빼는지, 또, dx[i]와 dy[i]를 언제 더해주는지 순서가 매우 헷갈렸다.
그러나 bfs의 개념을 제대로 생각하여 구현했다. 그리고 컴포넌트의 개수와 각 컴포넌트에는 몇 개의 element가 있는지
이것들을 어디에 저장해야지 출력 순서가 엇갈리지 않게 출력할 수 있을까라는 생각이 들었다. 그래서 배열 생각을 했다.
그러나 ArrayList를 사용하여 큐에 element가 추가될 때마다 count++를 해주고, bfs메소드가 끝나면 ArrayList에 count를 추가해주었다.
이런 식으로 진행하게 되면 따로 컴포넌트의 개수를 구하지 않아도 된다. 왜냐하면 ArrayList의 원소의 개수가 컴포넌트의 개수이기 때문이다.
그래서 ArrayList를 오름차순 정렬해주고, size와 element들을 출력해주면 된다.
 */

import java.util.*;
import java.io.*;

public class BOJ2677 {
    static int arr[][];
    static boolean visit[][];
    static int size;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());

        arr = new int[size][size];
        visit = new boolean[size][size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < size; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visit[i][j] && arr[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        Collections.sort(al);

        System.out.println(al.size());

        for(int i = 0; i < al.size(); i++){
            System.out.println(al.get(i));
        }
    }

    static void bfs(int x, int y){
        Queue<homePoint> q = new ArrayDeque<>();
        q.offer(new homePoint(x, y));
        visit[x][y] = true;
        int count = 1;
        while(!q.isEmpty()){
            homePoint hp = q.poll();
            for(int i = 0; i < 4; i++){
                int dX = hp.x + dx[i];
                int dY = hp.y + dy[i];
                if(isRangeTrue(dX, dY) && !visit[dX][dY] && arr[dX][dY] == 1) {
                    q.offer(new homePoint(dX, dY));
                    visit[dX][dY] = true;
                    count++;
                }
            }
        }
        al.add(count);
    }

    static boolean isRangeTrue(int x, int y){
        return (x >= 0 && x < size && y >= 0 && y < size);
    }
}

class homePoint{
    int x, y;
    homePoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}