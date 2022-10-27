package boj.Data_Structure;

//BOJ 10828 스택

//https://c-king.tistory.com/

/*
자바 컬렉션을 사용하지 않고, 배열을 사용하면서 size를 조절하며 메소드를 구현하며 문제를 해결했다.
이 문제는 스택에 관련 메소드를 구현 연습을 할 수 있었다. 스택의 개념이 무엇인지만 알지, 메소드를 한번 더 구현함으로써스택을 더 정확히 알게된 문제였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10828 {
    static int stack[];
    static int size = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(st.nextToken());
        stack = new int[cnt];

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int i){
        stack[size] = i;
        size++;
    }

    public static int top(){
        if(size == 0) return -1;
        return stack[size-1];
    }

    public static int size(){
        return size;
    }

    public static int pop(){
        if(size == 0) return -1;
        else{
            int result = stack[size-1];
            stack[size-1] = 0;
            size--;
            return result;
        }
    }

    public static int empty(){
        if(size == 0) return 1;
        else return 0;
    }
}
