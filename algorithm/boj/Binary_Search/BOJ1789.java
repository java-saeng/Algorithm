package boj.Binary_Search;

// BOJ 1789 수들의 합

/*
이 문제를 처음 풀면서 어떻게 풀어야 할지부터 생각이 들었다.
왜냐하면 서로 다른 N개의 자연수의 합이 S라고 할 떄, S만 아는 것이다. 그러면 이걸 어떻게 접근해야 하지라는 생각이 들었다.
일단 무조건 1부터 순차적으로 더하는게 N을 제일 크게 할 수 있다는 생각이 들었다. 예를 들어 10을 만들 때, 1+9 보다는 1+2+7이 있고, 1+2+3+4가 최대가 된다.
따라서 1부터 순차적으로 더해서 만약 sum 값이 주어진 S보다 크게 되면 count에서 하나 빼는 것을 생각했다. 여기서, count를 하나 뺀 이유는 예시에 200이 있다.
그러면 1~19 1~19까지 더하면 190이 되고, 20을 더하면 210이 되어 200을 뛰어넘게 된다.
그래서 1~20 1~20까지 한 뒤, count--해주는 값은 200에 도달하기 위해 숫자 10을 빼주기 때문에 count--을 하게 된다.
이 문제는 이게 point인 것 같다. 주어진 숫자보다 커지면 그 숫자를 만들기 위해 하나의 숫자를 뺀다라는 생각이 필요한 것 같다.

 */
import java.util.*;
import java.io.*;

public class BOJ1789 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Long.parseLong(st.nextToken());
        long sum = 0;
        long count = 0;

        //1. sum이 s보다 작으면 계속해서 더해줌
        //2. count을 한개씩 늘리면서 더해줌.
        //3. 만약 count을 한개씩 늘리면서 sum이 s를 뛰어 넘게되면, count을 하나 빼줌

        while (sum < s) {
            count++;
            sum += count;
        }

        if(sum > s){
            count--;
        }

        System.out.println(count);
    }
}
