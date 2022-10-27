package boj.TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ1484 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int G;
    static ArrayList<Integer> al = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        //G가 되는 자연수 곱을 구해야함.
        getMul();
        get();

        if(sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
    }

    static void get() {
        for (int i = al.size()-1; i >=0; i -= 2) {
            int max = boj.Math.max(al.get(i), al.get(i - 1));
            int min = boj.Math.min(al.get(i), al.get(i - 1));

            if((max + min) % 2 == 0 && (max-min) % 2 == 0){
                sb.append((max+min) / 2).append("\n");
            }
        }
    }

    static void getMul() {
        int s = 1, e = G;

        while (s < e) {
            int val = s * e;

            if(val > G){
                e--;
            }
            else if(val < G){
                s++;
            }
            else{
                al.add(s);
                al.add(e);
                s++;
                e--;
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = atoi(br.readLine());
    }
}
