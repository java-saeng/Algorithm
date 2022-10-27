package boj.Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static String s = "";
    static String bomb = "";
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean flag = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) !=
                    bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        bomb = br.readLine();
    }
}
