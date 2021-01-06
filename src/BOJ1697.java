//BOJ 1697 숨바꼭질

/*
이 문제는 도움을 받아서 풀었던 문제이다. 처음에 런타임 에러가 나서 왜 그런지 생각해보니, x의 범위가 문제에서 100000보다 작거나 같다였다.
그래서 나도 배열 index를 생성할 때, 100000으로 생성했다. 그래서 런타임 에러가 나왔다. 문제에서 100000보다 작거나 같다였다면, 배열 index 크기를 100001로 해주어야 한다.
 여기서 이러한 점을 알게 되었다. 그리고 처음에는 visit 배열을 배열로 사용하지 않고, ArrayList를 사용하였다.
 처음에 내 생각에는 ArrayList가 시간 복잡도가 더 줄어든다고 생각하여, 사용하였지만 그것이 아니었다.
 이 점을 방문했는지 안 했는지 확인하려면 배열은 그 index가 true인지 false인지 판단하기 때문에 O(1)이었고, ArrayList는 O(n)이었다는 점이다.
 왜냐하면 그 value가 있는지 없는지 찾기 위해 순차적으로 index를 탐색해야 하기 때문이다. 그래서 시간 초과가 났다.
 */

import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int start, end;
    static boolean visit[];
    static int count[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];
        count = new int[100001];

        bfs(start);
        System.out.println(count[end]);
    }
    //1. bfs로 start부터 시작해서 x좌표 배열을 만듬 -1 , 1, start로 그래서 더하는 거
    static void bfs(int st){
        Queue<Integer> q = new LinkedList<>();
        visit[st] = true;
        q.offer(st);
        while(!q.isEmpty()) {
            int current = q.poll();
            int dx[] = {-1, 1, current};
            if(current == end) break;
            for (int i = 0; i < 3; i++) {
                int X = current + dx[i];
                if (isRangeTrue(X) && !visit[X]) {
                    q.offer(X);
                    visit[X] = true;
                    count[X] = count[current] + 1;
                }
            }
        }
    }

    static boolean isRangeTrue(int x){
        return x >= 0 && x < 100001;
    }
}