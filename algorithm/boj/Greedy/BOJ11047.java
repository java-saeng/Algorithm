package boj.Greedy;

//BOJ 11047 동전 0

/*
첫 그리디 문제이다. 이 문제는 그냥 쉽게 생각했다. 오름차순으로 입력해주기 때문에 제일 뒤에서부터 K원보다 크면 넘어가면서 더 작은 가치의 동전으로 넘어가고,
K원보다 작거나 같으면 빼주면서 다시 while문을 돌렸다.
 */

import java.util.*;
import java.io.*;

public class BOJ11047 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coin_cnt = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        int coin[] = new int[coin_cnt];

        for(int i = 0; i < coin_cnt; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int limit = coin_cnt-1;

        while(value != 0){
            if(coin[limit] > value){
                limit--;
                continue;
            }
            else{
                value -= coin[limit];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
