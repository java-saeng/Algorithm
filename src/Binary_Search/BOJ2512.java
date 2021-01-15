package Binary_Search;

//BOJ 2512 예산

/*
이전에 푼 나무 자르기 문제와 아주 유사한 문제이다. 나무 자르기와 예산 문제를 이해하는데 하루가 가버렸다. 제일 이해가 가지 않는 부분이 if(sumarr > yesan) 부분이었다.
여기에 >= 하게 되면 틀렸다고 나오고, > 만 하면 맞았다고 나왔다. 그냥 느낌대로는 아 이게 맞아서 저렇게 풀었지만 누구한테 설명해보라고 할 때, 나 자신이 제대로 설명을 하지 못할 것 같아 스스로 납득할 때까지 생각해보았다.
그래도 제대로 이해하지 못해 주변 사람들에게 도움을 요청했다.
설명해보자면, 여기서 mid가 의미하는 것이 상한액이고, sumarr이 상한액을 정했을 때 나라마다 원하는 예산들의 총합이다.
그래서 만약 나라마다 원하는 예산들의 총합이 예산보다 크면 상한액을 낮춰야한다. 그래서 ed = mid -1 이다.
왜냐하면 mid를 낮춰야 하기 때문이다. 그러고 나서 = 이 되는지 안되는지 확인하려면 이러한 생각을 하면 된다.
만약 sumarr == yesan이 될 때는 이게 상한액이 가장 최댓값일 때가 아닌가? 그래서 만약에 ed = mid - 1은 mid를 계속해서 낮추는 것이고, st = mid + 1은 mid를 계속 높이는 것이다.
그래서 sumarr == yesan이 가장 최댓값인데, sumarr >= yesan을 하게 되면 mid를 계속 낮추는 것이기 때문에, 다음 while문을 계속 돌아도 mid값이 다시는 나오지 않는다.
하지만, st = mid + 1은 mid를 계속해서 높이는 것이기 때문에, while문이 계속 돌아도 mid가 다시 나올 수 있다는 것이다.
그래서 ed = mid -1  부분에 >= 넣으면 안되는 이유이다.
이전에 풀었던 나무 자르기를 보면서 다시 한번 생각해보면 이해가 될 것이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {
    static int nationarr[];
    static int yesan;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int nation = Integer.parseInt(st.nextToken());
        nationarr = new int[nation];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nation; i++) {
            nationarr[i] = Integer.parseInt(st.nextToken());
            sum += nationarr[i];
        }
        Arrays.sort(nationarr);

        st= new StringTokenizer(br.readLine());

        yesan = Integer.parseInt(st.nextToken());

        ////////////////////////////////////////////////////////////////입력 끝

        if(yesan >= sum)
            System.out.println(nationarr[nation-1]);    //예산이 총 금액보다 클 때에는 제일 큰 값 출력
        else
            binarySearch();

    }
    //1. nation_arr에 데이터를 저장하고, total에 총예산을 저장함
    //2. binarySearch에는 예산에 관한 이분 탐색을 실시
    //2-1. 만약 총 예산이 arr에 저장되어 있는 총합보다 높으면 그냥 제일 큰 값 출력
    //2-2. 작으면 이제 상한액을 정해야함.
    //3. 상한액
    //4. mid 값을 구하고 상한액보다 크면 상한액만큼 주고, 상한액보다 작으면 그 예산만큼 다줌
    //4-1. 그 합이 총 예산보다 작거나 같으 st = mid + 1 을 하고 크면 ed = mid - 1을 해줌
    //4-2. st > ed가 되는 순간에 ed를 출력하면된다.
    public static void binarySearch(){
        int st,ed,mid;
        int result = 0;
        st = 0;
        ed = yesan;
        while (st <= ed) {
            int sumarr = 0;
            mid = (st + ed) / 2;
            for(int i = 0; i < nationarr.length; i++){
                if(nationarr[i] > mid){
                    sumarr += mid;
                }
                else{
                    sumarr += nationarr[i];
                }
            }
            if(sumarr > yesan) {
                ed = mid - 1;
            }

            else st = mid + 1;
        }
        System.out.print(ed);
    }
}
