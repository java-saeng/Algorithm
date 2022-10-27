package boj.Binary_Search;

//BOJ 10816 숫자 카드 2

/*
이 문제를 처음에 풀면서 중복된 것을 생각 못하고 일반적인 이분 탐색으로 풀었다. 당연히 풀리지 않았다.
그래서 중복된 숫자를 배열의 index에 집어넣고 그 배열의 값을 한 개씩 증가시키는 방법을 사용하려 했다.
그러나 예제에 음수가 있는 것을 보고 그 방법이 안된다는 것을 알게 됐다.
그래서 마지막으로 생각한 것이 HashMap이었다. 이 문제를 풀면서 HashMap을 제대로 공부하게 되었다.
만약, 음수가 존재하지 않았다면 index에 집어넣는 방법도 나쁘지 않다고 생각한다.
그리고 이분 탐색하면서 꼭꼭 기억해야 하는 점이 있다면, binarySearch에서 sang[mid] == num 일 때, 꼭 return 해주어야 한다는 점이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10816 {
    static StringBuilder sb = new StringBuilder();
    static int sang[];
    static HashMap<Integer, Integer> sangHash = new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;

        n = Integer.parseInt(st.nextToken());
        sang = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int sang_num = Integer.parseInt(st.nextToken());
            sang[i] = sang_num;
            if(sangHash.containsKey(sang_num))
                sangHash.put(sang_num,sangHash.get(sang_num)+1);
            else
                sangHash.put(sang_num,1);
        }

        Arrays.sort(sang);

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            binarySearch(num);
        }

        System.out.println(sb);
    }
    //1. sang을 Treeset으로 한다음에 중복되는 거랑 오름차순을 같이해서 Set을 배열로 만든다.
    //2. 이분탐색을 해서 있는 숫자를 index 배열에 저장을 함.
    //2-1. 여기서 그 숫자가 의미하는 건 index를 의미함.
    //3. 처음 sang배열에 있는 숫자의 갯수를 구해야함.
    //3-1. 이거는 count[해당하는숫자]++ 이런식으로하면될듯.
    //4. 그래서 count[index]에 해당하는 숫자를 뽑아내면 될듯. count 배열의 개수 최대치는 20000001
    //------------------------------------------------- 이 방법은 배열 index가 음수가 안되는걸 간과하고있었음
    //1. HashMap을 이용해서 갯수를 저장해놔야함
    //2. sang에 대응하는 HashMap을 만들고
    //2-1. sang을 정렬시켜서 이분탐색 돌리고 있는 숫자를 배열에 저장해서
    //2-2. 그 배열의 값을 HashMap의 키로 쓰면 될 듯
    public static void binarySearch(int num){
        int st,mid,ed;
        st = 0;
        ed = sang.length-1;
        while(st <= ed){
            mid = (st + ed) / 2;
            if(sang[mid] == num) {
                sb.append(sangHash.get(num) + " ");
                return;
            }
            else if(sang[mid] > num) ed = mid - 1;
            else st = mid + 1;
        }
        sb.append(0 + " ");
    }
}
