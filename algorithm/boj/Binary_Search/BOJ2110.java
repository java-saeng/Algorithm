package boj.Binary_Search;

//BOJ 2110 공유기 설치

/*
처음에 이 문제를 풀 때 st, ed값은 어떻게 해야 할지 그리고 공유기를 어떻게 설치해야 할지 생각하는데 많은 시간을 썼다.
그래서 for문으로 집을 하나씩 조사하면서, 그 전 집과 거리를 비교하여 최대 거리만큼 떨어져 있으면 공유기를 설치할 수 있게끔 하였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static int N,C;
    static int ad[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //집의 개수
        C = Integer.parseInt(st.nextToken()); //공유기 개수

        ad = new int[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            ad[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ad);
        binarySearch();

    }
    //1. st = 1, ed = ad[N] - ad[1]로 설정하고
    //2. 최대 거리를 계산하면서, 갯수를 만족하는지 봐야함.
    //2-1. 설치하려는 갯수가 C보다 크거나 같으면 간격을 늘려야하므로 left = mid + 1해주고
    //2-2. 설치하려는 갯수가 C보다 작으면 간격을 줄여야해서 right = mid - 1을 해주어야함.
    public static void binarySearch(){
        int st,ed,mid,cnt,before;
        before = 0;
        mid = 0;
        st = 1;
        ed = ad[N] - ad[1];
        while(st <= ed){
            mid = (st + ed) / 2;
            cnt = 1;
            before = ad[1];
            for(int i = 2; i <= N; i++){
                if(ad[i] - before >= mid){
                    cnt++;
                    before = ad[i];
                }
            }
            if(cnt >= C){
                st = mid + 1;
            }
            else{
                ed = mid - 1;
            }
        }
        System.out.println(ed);
    }
}
