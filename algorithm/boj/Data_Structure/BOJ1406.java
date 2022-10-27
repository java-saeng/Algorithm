package boj.Data_Structure;

//BOJ 1406 에디터

/*
답을 처음 작성했을 때, 코드 1처럼 작성을 했다. 문자 입력에 따라 index값을 변화시켜 커서를 움직이는 식으로 했다.
그러나 그렇게 하게 되면, 문자를 삭제하고 list안에서 재배열될 때 O(n)이 나오게 되고, 이것을 반복하게 되면 O(n^2)로  총 명령어가 500,000개 이므로 500,000^2가 되어 시간 초과가 나온다.
그래서 stringbuilder도 사용해보고 했지만 계속해서 시간 초과가 나와 힌트를 얻기 위해 구글링을 했다.
시간 초과를 피하기 위해서 사용한 방법은 왼쪽 스택, 오른쪽 스택을 구현하는 것이었다. 스택에서의 push, pop은 시간 복잡도가 O(1)이기 때문에 반복하면 O(n)이 되기 때문에 시간 초과가 나오지 않는다.
솔직하게 힌트를 보지 않았다면 이 문제는 풀 수 없었을 것 같다. 왼쪽 스택, 오른쪽 스택을 구분하여 문제를 푸는 것이 정말 기발하다고 생각했다.
그리고, index값을 변화시켜 커서를 움직이면 O(n)이 사용된다는 것도 알게 되었다.
그래서 스택을사용하여 문제를 풀었는데도 시간 초과가 나왔다. 마지막에 StringBuilder를 사용하니 문제가 맞았다.
이 점을 보고, stringbuilder가 println보다 빠른 출력을 하게 됨을 알 수 있었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1406 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftstack = new Stack<>();
        Stack<Character> rightstack = new Stack<>();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++)
            leftstack.push(str.charAt(i));

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){
            String order = br.readLine();
            switch(order.charAt(0)){
                case 'L':
                    if(!leftstack.isEmpty()) rightstack.push(leftstack.pop());
                    break;
                case 'D':
                    if(!rightstack.isEmpty()) leftstack.push(rightstack.pop());
                    break;
                case 'B':
                    if(!leftstack.isEmpty()) leftstack.pop();
                    break;
                case 'P':
                    leftstack.push(order.charAt(2));
            }
        }

        while(!leftstack.isEmpty())
            rightstack.push(leftstack.pop());

        StringBuilder sb = new StringBuilder();

        while(!rightstack.isEmpty())
            sb.append(rightstack.pop());

        System.out.print(sb);
    }
}
