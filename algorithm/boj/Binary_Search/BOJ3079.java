package boj.Binary_Search;

//BOJ 3079 입국심사

/*
처음에 이 문제를 풀 때 ed값, 즉, 최댓값을 1000000000으로 설정하고 문제를 제출해서 틀렸다.
그래서 나는 ed값에 문제가 없는지 알고, 다른 부분을 계속 고쳤는데 마지막에 혹시 ed값이 잘못됐나 해서 수정하고 제출하니 맞았다.
여기서 최댓값을 1000000000으로 하면 안 되는 이유가 최대 걸릴 수 있는 시간은 사람 수 * 제일 많이 걸리는 시간이기 때문이다.
그래서 앞으로 이분 탐색을 하면서 최댓값을 더욱더 신중히 생각할 필요가 있다고 생각하였다.
물론, 여기서도 long형을 해주었는데 조금 생각하기 어려운 문제일수록 이런 사소한 것까지 생각해주어야한다고 느꼈다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3079{
    static long N, M, max;
    static int time[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken()); //심사대 개수
        M = Long.parseLong(st.nextToken()); //친구 명 수
        max = 0;
        time = new int[(int)N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            max = boj.Math.max(time[i], max);
        }
        Arrays.sort(time);
        binarySearch();
    }
    //1. st = 1, ed = max * M 로 설정함
    //2. 그래서 mid / time[i] 를 해서 sum에 다 더함
    //2-1. 더한 값이 사람 수보다 많거나 같을 때 mid를 줄여야함. 그래서 ed = mid - 1을 해주고,
    //2-2. 더한 값이 사람 수보다 적으면 mid를 늘려야함. 그래서 st = mid + 1을 해주어야함.
    public static void binarySearch(){
        long st,ed,mid,sum;
        st = 1;
        ed = max * M;
        while(st <= ed){
            sum = 0;
            mid = (st + ed) / 2;
            for(int i = 0; i < N; i++){
                sum += mid / time[i];
            }
            if(sum >= M) ed = mid - 1;
            else st = mid + 1;
        }
        System.out.println(st);
    }
}
