package Greedy;

//BOJ 2217 로프

import java.io.*;
import java.util.*;

public class BOJ2217 {
    /*
    k개의 로프에 중량 w 물체 올릴 때 각각 w/k만큼
    로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량
    1. 모든 로프를 사용해야할 필요 X 임의로 몇 개의 로프를 골라서 사용가능
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = c(st.nextToken());
        int rope[] = new int[num];
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int value = c(st.nextToken());
            rope[i] = value;
        }

        Arrays.sort(rope);

        int result = 0;
        for(int i = num -1; i > -1; i--){
            rope[i] = rope[i] * (num - i);
            if(rope[i] > result) result = rope[i];
        }
        System.out.println(result);
    }
    static int c(String str){
        return Integer.parseInt(str);
    }
}
