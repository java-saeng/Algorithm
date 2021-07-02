package BruteForce_Search;

//BOJ 1065 한수

import java.util.*;
import java.io.*;

public class BOJ1065 {
    static int N;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(i < 10) {
                cnt++;
                continue;
            }
            if(rel(i)) cnt++;
        }
        System.out.print(cnt);
    }
    static boolean rel(int num){
        ArrayList<Integer> al = new ArrayList();
        boolean flag = false;
        while(num > 0){
            al.add(num % 10);
            num /= 10;
        }

        int result = al.get(0) - al.get(1);

        for(int i = 0; i < al.size() - 1; i++){
            if(result == al.get(i) - al.get(i+1))
                flag = true;
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}


