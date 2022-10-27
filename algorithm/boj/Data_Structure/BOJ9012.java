package boj.Data_Structure;

//BOJ 9012 괄호

/*
stack 클래스를 이용하여 문제를 풀었다.
1. '(' 을 받으면 push
2. ')'을 받을 때
2-1. stack이 비어있으면 VPS가 아님
2-2. stack이 비어있지 않으면 pop한다.
3. 스택이 비어있으면 VPS이고, 스텍이 비어있지 않으면 VPS가 아님.
 */

import java.util.*;
import java.io.*;

public class BOJ9012 {
    static Stack<Character> stack;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int test = Integer.parseInt(st.nextToken());


        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine());
            stack = new Stack<>();
            trueVPS(st.nextToken());
        }
        System.out.print(sb);
    }

    static void trueVPS(String str) {
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(') stack.push(ch);
            else{
                if(stack.isEmpty()){
                    sb.append("NO").append('\n');
                    return;
                }
                else stack.pop();
            }
        }
        if(stack.isEmpty()) sb.append("YES").append('\n');
        else sb.append("NO").append('\n');
    }
}
