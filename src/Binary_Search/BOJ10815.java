package Binary_Search;

//BOJ 10815 숫자 카드

/*
이분 탐색 문제를 풀어보니 풀이식이 다 비슷한 것 같다. 이 부분에서 실수한 부분은
1. mid를 비교할 때, sang [mid]를 비교해야 하는데 mid만 비교했다.
2. mid = st + ed 이 부분을 whil문에 넣지 않고, 밖에다가 계산을 해버렸다.
3. 이분탐색 할때, 무조건 비교당하는 배열은 정렬을 해주어야 하는데 해주지 않았다.
이러한 부분만 계속해서 생각하고 고치면 될 것 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    static StringBuilder sb = new StringBuilder();
    static int[] sang;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n,m;

        n = Integer.parseInt(st.nextToken());

        sang = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            sang[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sang);

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            binarySearch(num);
        }

        System.out.print(sb);

    }
    //1. binarySearch 메소드는 static 변수인 sang과 숫자카드를 비교해서
    //2. StringBuilder인 sb에 공백과 함께 입력하는 식으로 구성
    public static void binarySearch(int num){
        int st,ed,mid;
        st = 0;
        ed = sang.length-1;
        while(st <= ed){
            mid = (st + ed) / 2;
            if(sang[mid] == num) {
                sb.append(1 + " ");
                return;
            }
            else if(sang[mid] > num) ed = mid - 1;
            else st = mid + 1;
        }
        sb.append(0 + " ");
    }
}
