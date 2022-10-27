package boj.Binary_Search;


//BOJ 1654 랜선 자르기
/*
다양한 이분 탐색을 이용한 최댓값 문제를 풀어보니, 이번 문제 로직 생각하는데 어렵진 않았다.
다만 처음에 틀렸습니다랑, 런타임 에러(by zero)가 나와서 왜 그런지 문제를 다시 읽어보니 랜선의 길이가 자연수라고 정의되어있었다.
그래서 최솟값은 평상시처럼 0이 아니라 1이 되어야 했고, 랜선의 길이가 int형 범위이기 때문에, 처음에 mid는 int형 범위의 절반이 되고,
다음에는 int형 범위와 int형 절반 범위를 더하면 int형 범위가 넘어서기 때문에 long형으로 선언해주어야 맞출 수 있다.
이분 탐색을 풀면서 int형 범위가 넘는지 안 넘는지도 꼭 확인해보아야겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    static int line[];
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K;
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        line = new int[K];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);

        binarySearch();
    }
    //1. line을 정렬시키고 st = 0 ed = 제일 큰 길이의 랜선을 해놓음
    //2. 그래서 mid를 구하고 모든 데이터에서 mid를 나눔
    //2-1. 나눈 총 갯수가 N개 보다 작으면 mid를 작게해야지. ed = mid - 1
    //2-2. 나눈 총 갯수가 N개 보다 크거나 같으면 mid를 크게해야지. st = mid + 1
    public static void binarySearch(){
        long st,ed,mid;
        st = 1;
        ed = line[line.length-1];
        while(st <= ed){
            long count = 0;
            mid = (st + ed) / 2;
            for(int i = 0; i < line.length; i++){
                    count += line[i] / mid;
            }
            if(count >= N)
                st = mid + 1;
            else
                ed = mid - 1;
        }
        System.out.println(ed);
    }
}
