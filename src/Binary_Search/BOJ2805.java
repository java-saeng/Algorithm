package Binary_Search;

//BOJ 2805 나무 자르기

/*
처음에 풀었을 때는 계속해서 시간 초과가 나왔다. 그래서 구글링을 하여 무엇이 문제인지 찾아보았다.
코드가 비슷하게 생겼는데 왜 내 코드는 시간 초과가 나오는지 말이다.
코드를 비교해보면서 무엇을 기준으로 이분 탐색을 돌리는지 정확히 알아야 하는 것이 중요한 걸 깨달았다.
왜냐하면 처음에 풀었던 코드는 나무 길이가 저장되어있는 배열을 인자 num과 비교하여 이분 탐색을 돌린 것이었고,
맞은 코드는 절단기의 길이를 가지고 총 가져갈 나무 길이와 비교하여 이분 탐색을 돌린 것이다.
내가 처음에 저렇게 코드를 짠 이유는 절단기 최대 길이를 구할 때, 절단기의 길이는 저 배열들의 값들 중에 있을 거라는 생각을 하고
처음에 절단기의 길이를 인자로 받아서 그 길이보다 큰 나무들을 자른 나머지를 더함으로써, 더한 값들이 원하는 나무길이와 같을 때 출력을 한다.
그래서 이 문제는 절단기의 길이를 가지고 이분 탐색을 돌려야 시간초과가 나오지 않음을 깨달았다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    static int woodArray[];
    static int woodLength;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wood = Integer.parseInt(st.nextToken());
        woodArray = new int[wood];

        woodLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < wood; i++)
            woodArray[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(woodArray);

        binarySearch();

    }
    /*1. 나무를 항상 가져갈 수 있다고 했기 때문에 내 생각에는 높이 최댓값을 구하려면 나무 길이 중에 하나를 선택해야함.
      2. 그러기 때문에 예제에서 보면 나무 길이 최댓값일 제외하고 15, 10, 17 중에 선택해야함.
      2-1. 만약 10을 선택하면 10보다 큰 수들에서 10을 뺀 합을 저장해야함.
      2-2. while문에서 st,ed,mid를 10이 나오면 mid보다 큰지 작은지 해서, 큰 쪽 수들을 나열해서 10씩 뺌
    */

    public static void binarySearch(){
        long st, ed, mid;
        st = 0;
        ed = woodArray[woodArray.length-1];

        while(st <= ed){
            long woodCount = 0;
            mid = (st + ed) / 2;
            for(int i = 0; i < woodArray.length; i++){
                if(woodArray[i] >= mid)
                    woodCount += woodArray[i] - mid;
            }
            if(woodCount >= woodLength)
                st = mid + 1;
            else
                ed = mid - 1;
        }
        System.out.println(ed);
    }
}
