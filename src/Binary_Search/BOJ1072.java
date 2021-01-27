package Binary_Search;


//BOJ 1072 게임

/*
이 문제는 이전에 풀어왔던 이분 탐색 문제들과는 조금 달랐다. 이전 문제들은 전부 최댓값을 구하는 것이었는데, 이 문제는 최솟값을 구하는 것이다.
그래서 최댓값 문제를 풀 때와 무슨 차이가 있는지 유심히 보았다.
1. changeZ - z > 0
만약 changeZ == z가 되면, 게임 횟수를 늘려줘야 하기 때문에 st = mid + 1 부분에 = 이 붙어져 있다.
2. System.out.println(st)
최댓값 구할 때는 ed를 출력하지만, 최솟값 구할 때는 st값을 출력한다.
이 문제를 풀면서 실수한 점은 ratio를 구할 때, y / x * 100이라고 했다. 이 점을 보면, 아직 컴퓨터적 사고가 제대로 길러지지 않아 제대로 생각하지 않으면 이런 부분에서 실수하는 것 같다.
더욱더 머리를 컴퓨터적 사고로 바꿔야 할 것 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    static long x, y, z, changeZ;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = y * 100 / x ;

        if(z >= 99)
            System.out.println(-1);
        else
            binarySearch();
    }
    //1. changeZ와 z 차이가 1이 될 떄까지의 최소 게임 횟수
    //2. mid가 최소 게임 횟수이므로, changeZ = (y + mid) / (x + mid) * 100이 됨
    //2-1. 그래서 changeZ와 z의 차이가 1이면 뽑아내고, 아니면 다시 돌리는거임
    //2-2. 만약 changeZ와 z의 차이가 0보다 크면 ed = mid - 1 하고 작거나 같으면 st = mid + 1; 해야함
    public static void binarySearch(){
        long st, ed, mid;
        st = 1;
        ed = x;
        while(st <= ed){
            changeZ = 0;
            mid = (st + ed) / 2;
            changeZ = ((y + mid) * 100 / (x + mid));
            if(changeZ - z > 0){
                ed = mid -1;
            }
            else
                st = mid + 1;
        }
        System.out.println(st);
    }
}
