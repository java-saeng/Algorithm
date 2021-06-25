package Greedy;

//BOJ 11508 2+1 세일

import java.io.*;
import java.util.*;

public class BOJ11508 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = atoi(st.nextToken());

        Integer arr[] = new Integer[size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = atoi(st.nextToken());
        }
        //편하게 람다식 써봄
        Arrays.sort(arr, (i1,i2) -> i2 - i1);

        //원래 내림차순 정렬할 때 이렇게 썼는데 람다식
        //배우고 나서는 람다식 쓰는게 매우 편한 듯.
        /*Arrays.sort(arr, new Comparator<Integer>(){
           @Override
           public int compare(Integer i1, Integer i2){
               return i2 - i1;
           }
        });*/

        int sum = 0;
        for(int i = 0; i < size; i++){
            //가장 작은 수를 빼야하기 때문에
            //내림차순으로 정렬해서 3개중에 가장 끝에 있는 index는
            //3으로 나눌 때 나머지가 2인 위치에 있다.
            if(i % 3 == 2) continue;
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
