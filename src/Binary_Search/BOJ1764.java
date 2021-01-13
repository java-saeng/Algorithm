package Binary_Search;

//BOJ 1764 듣보잡

/*
듣보잡 문제는 이분 탐색 문제이지만, 다루는 자료형이 String형이다. 이 문제를 풀면서 문자열에 관한 메소드를 많이 알아가게 됐다.
1. Arrays.sort는 배열을 오름차순으로 정렬해주는 메소드
2. Collections.sort는 List형을 오름차순으로 정렬해주는 메소드이다.
binarySearch는 다른 이분 탐색과 똑같다. 하지만 여기서 compareTo 메소드를 볼 수 있다.
처음에는 구글링을 잘못하여 compareTo 메소드를 사용하면서 반환하는 숫자가 0 , -1, 1밖에 없다고 생각한 것이다.
그러나 compareTo 메소드는  A.compareTo(B) 일 때, A가 B보다 앞선다면 음수가 나온다. 물론 정확한 어떤 숫자가 반환되는지는 알 수 있다.
아스키코드를 이용하여, 포함되어 있는 문자에서 빼주면 되는데 이 부분은 다음에 알아갈 것이다.
그래서 다시 문제로 넘어오면, A가 B보다 앞서게 되면 음수가 나와, st = mid + 1을 하여, mid보다 뒤에서 비교해야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    static ArrayList<String> arr = new ArrayList<>();
    static String[] nolisten;
    static String[] nosee;
    public static void main(String args[]) throws IOException {
        //1. 듣도 못한 사람을 배열에 정렬한 상태로 저장
        //2. 그리고 보도 못한 사람을 search 함수에 넣어서
        //듣도 못한 사람에 있는지 비교함
        //3. 있으면 ArrayList에 저장하고, 없으면 냅둠
        //4. 출력을 ArrayList 원소 갯수와 ArrayList 출력하자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nolisten = new String[n];

        for(int i = 0; i < n; i++){
            nolisten[i] = new String(br.readLine());
        }

        Arrays.sort(nolisten);

        nosee = new String[m];

        for(int i = 0; i < m; i++){
            nosee[i] = new String(br.readLine());
         }

        for(int i = 0; i < m; i++){
            binarySearch(nosee[i]);
        }

        Collections.sort(arr);

        System.out.println(arr.size());

        for(String index : arr)
            System.out.println(index);

    }

    public static void binarySearch(String str){
        int st,ed,mid;
        st = 0;
        ed = nolisten.length-1;
        while(st <= ed){
            mid = (st+ed) / 2;
            if(nolisten[mid].compareTo(str) == 0) {
                arr.add(str);
                return;
            }
            else if(nolisten[mid].compareTo(str) > 0){
                ed = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
    }
}
