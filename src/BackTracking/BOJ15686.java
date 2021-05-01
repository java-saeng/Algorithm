package BackTracking;

//BOJ 15686 치킨 배달

/*
1. 입력을 하면서 숫자가 1이면 home ArrayList에, 2면 chicken ArrayList에 저장을 한다.
1-2. 여기서 우리는 한 집(숫자 1)을 기준으로 여러 치킨 집에 대한 맨허튼 거리를 계산하고, 그중에 최솟값이 치킨 거리이다.
     그래서 visit 배열을 사용하여 철거하지 않은 치킨집을 true로 한다. 그래서 visit배열의 크기는 chicken ArrayList의 size와 같다.
2. 백트래킹 메소드에서 visit 배열을 true로 하고 재귀 함수를 부르는 것은 어느 백트래킹 문제와 같다.
3. 이제 depth와 M(치킨집 갯수)가 같을 때 생각해보자.
3-1. 집을 기준으로 각각 치킨집들과의 거리를 계산해야 한다. 그중에 가장 최솟값이 치킨 거리이다. 따라서 기준을 i(집)으로 잡고 j로 각각 치킨집과의 맨해튼 거리를 계산한다.
     그리고 temp를 이용하여 그중 최솟값을 temp에 저장한다.
3-2. temp는 이제 한 집에서의 치킨 거리를 나타낸다. 그리고 이제 sum을 이용하여 각 치킨 거리의 합 즉, 도시의 치킨 거리를 구한다.
     이 부분은 이제 치킨 거리가 1 2 3일 때 최솟값을 갖는지, 1 2 4일 때 최솟값을 갖는지 비교하는 것이다. 따라서 min이 도시의 치킨 거리의 최솟값이다.
 */
import java.io.*;
import java.util.*;

public class BOJ15686{
    static int arr[][];
    static int N, M;
    static ArrayList<ChicPoint> home = new ArrayList<>();
    static ArrayList<ChicPoint> chicken = new ArrayList<>();
    static boolean visit[];
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num; // ---------------- 1
                if(num == 1) home.add(new ChicPoint(i,j));
                else if(num == 2) chicken.add(new ChicPoint(i,j));
            }
        }
        visit = new boolean[chicken.size()]; // ----- 1-2

        backTracking(0,0);
        System.out.print(min);
    }

    static void backTracking(int start, int depth){
        if(depth == M){ // --------------------------- 3
            int sum = 0;
            int distance = 0;
            for(int i = 0; i < home.size(); i++){
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    if(visit[j]){
                        distance = checkDistance(home.get(i), chicken.get(j));
                        // ----------------- 3-1
                        temp = Math.min(temp, distance);
                    }
                }
                sum += temp;
            }
            min = Math.min(sum, min);
            return;
        }
        for(int i = start; i < chicken.size(); i++){ // ------------2
            if(visit[i]) continue;

            visit[i] = true;
            backTracking(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    static int checkDistance(ChicPoint a, ChicPoint b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class ChicPoint{
    int x, y;
    ChicPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}