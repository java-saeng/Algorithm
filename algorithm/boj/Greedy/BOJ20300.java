package boj.Greedy;

//BOJ 20300 서강근육맨

import java.io.*;
import java.util.*;

public class BOJ20300 {
    static long atoi(String str){
        return Long.parseLong(str);
    }
    static int acoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = acoi(st.nextToken());

        long arr[] = new long[size];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            arr[i] = atoi(st.nextToken());
        }

        Arrays.sort(arr);
        long sum = arr[size - 1];

        if(size % 2 == 0){
            for(int i = 0; i < size / 2; i++){
                long value = arr[i] + arr[size - 1 - i];
                if(sum < value) sum = value;
            }
        }
        else{
            for(int i = 0; i < size / 2; i++){
                long value = arr[i] + arr[size - 2 - i];
                if(sum < value) sum = value;
            }
        }

        System.out.println(sum);
    }
}
