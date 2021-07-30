package Graph;

//BOJ 6118 숨바꼭질

/*
처음에 문제를 읽고 ad함수를 이차원배열로 풀었더니 메모리 초과가 나왔다. 그래서 어느 부분 때문에 메모리 초과가 나오는지 확인해보았다.
count배열, visit배열들을 static으로 하지 않고 bfs메소드 안에 넣어서 제출을 해도 메모리초과가 나왔다.
그래서 ad함수를 이차원 배열이 아닌 ArrayList를 사용해서 풀었더니 정답이 되었다.
이 점을 보고 문제를 다시 읽어보았다. 문제에서 헛간의 개수가 20000개, 간선의 개수가 50000개이다. 즉, 20000개면 총 길은
20000^2 개인데, 여기서 간선의 개수가 50000이면 이차원 배열을 사용할 경우 메모리가 매우 낭비된다는 것을 깨달았다. 그래서
다음에는 문제를 제대로 읽고, 이 때 간선과 정점의 최대 개수를 생각해서 이차원 배열을 할당할지, ArrayList를 할당할지
생각한 뒤에 해야겠다.
 */

import java.util.*;
import java.io.*;

public class BOJ6118 {
    static int nV, nE;
    static ArrayList<Integer> ad[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());

        ad = new ArrayList[nV+1];

        for(int i = 0; i <= nV; i++){
            ad[i] = new ArrayList<>();
        }

        for(int i = 0; i < nE;i ++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1].add(s2);
            ad[s2].add(s1);
        }

        bfs(1);

    }

    //1. 구해야할 값 : 선택한 헛간 번호, 헛간까지 거리, 같은 거리의 있는 헛간 갯수
    //2. bfs를 돌린 뒤에, count배열에 저장을 함. 그래서 count의 배열 index가 헛간 번호임
    //3. 그래서 배열을 탐색해서 가장 길이가 긴 헛간 거리를 먼저 구함.
    //4. 그 때 범위를 같다하지 않고 그냥 크다고만 설정해서 index를 구한 뒤, 갯수가 같으면 ++해주면 될듯
    //5. 크거나 같다 안하는 이유는 같다를 하게 되면 제일 끝 헛간 번호가 출력될 것 같다 생각함.

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        int count[] = new int[nV+1];
        boolean visit[] = new boolean[nV+1];
        int max = Integer.MIN_VALUE;
        int index = 0;
        int max_count = 0;
        q.offer(x);
        visit[x] = true;
        while(!q.isEmpty()){
            x = q.poll();
            for(int idx : ad[x]){
                if(!visit[idx]){
                    q.offer(idx);
                    visit[idx] = true;
                    count[idx] = count[x] + 1;
                }
            }
        }

        for(int i = 0; i <= nV; i++){
            if(count[i] > max){
                max = count[i];
                index = i;
                max_count = 1;
            }
            else if(max == count[i])
                max_count++;
        }

        System.out.println(index + " " + count[index] + " " + max_count);
    }
}