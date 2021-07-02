package BruteForce_Search;

//BOJ 14501 퇴사

import java.io.*;
import java.util.*;

public class BOJ14501 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static Company com[];
    static int result;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = atoi(st.nextToken());
        com = new Company[size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            com[i] = new Company(atoi(st.nextToken()), atoi(st.nextToken()));
        }
        findMax(0,0);
        System.out.print(result);
    }
    static void findMax(int index, int money){
        if(index >= com.length){
            result = Math.max(result, money);
            return;
        }

        if(index + com[index].day <= com.length)
            findMax(index + com[index].day, money + com[index].money);
        else
            findMax(index + com[index].day, money);

        //시작점을 다음날로 하는거
        findMax(index + 1, money);
    }
}

class Company{
    int money, day;

    Company(int day, int money){
        this.day = day;
        this.money = money;
    }
}