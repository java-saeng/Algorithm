package Greedy;

//BOJ 20115 에너지 드링크

import java.io.*;
import java.util.*;

public class BOJ20115 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = atoi(st.nextToken());

        int arr[] = new int[size];
        int max = -1;
        double sum = 0; // 소수점 써야해서 double 써야할 듯

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            int bottleSize = atoi(st.nextToken());
            if(bottleSize > max) max = bottleSize;
            arr[i] = bottleSize;
        }

        for(int index : arr){
            if(max != index) sum += (double) index / 2;
        }
        sum += max;
        System.out.print(sum);
    }
}
