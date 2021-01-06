package DFS;

//BOJ 2210 숫자판 펌프

/*
이 dfs문제는 미로 찾기 문제와 비슷하다는 느낌이 들어 코드 구성에 있어서 어려운 점이 없었던 것 같다.
하지만 거쳐가는 숫자들을 문자열로 저장해서 할지, 정수형으로 나타낸다면 또 어떻게 나타낼지에 대한 고민을 무척 오래 했다.
문자열로 저장하기에는 입력하는 부분에서 코드가 복잡해질 것 같았고, 정수형으로는 나타낼 방법이 없었다. 또한, 중복된 것들을 어떻게 없앨까라는 생각도 했었다.
하나하나 천천히 생각해보니, 숫자들은 dfs메소드를 들어갈 때마다 num을 10씩 곱해서 거치는 숫자를 더해주면 정수형으로 쉽게 나타낼 수 있다는 생각이 들어서 구현을 했다.
그리고 거쳐간 숫자들을 배열에 저장해서 일일이 중복된 것을 찾아야하나라고 초반에 생각이 들었다.
그런데 Set 컬렉션을 사용하면 중복된 숫자들이 없어진다는 것이 생각나서 딱 6개의 숫자를 거쳐가는 시점에 set에 num을 넣어주는 식으로 했다. 처음에 dfs 메소드를 사용할 때,
cnt를 1로 해주는 이유는, 시작점에서부터 숫자를 거쳐가기 때문에 cnt를 1부터 시작해주었다. 만약 0부터 시작하려면 cnt == 5에서 멈추면 될 것 같다.
 */

import java.util.*;
import java.io.*;
public class BOJ2210 {
    static int[][] ad = new int[5][5];
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++)
                ad[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i,j,1,ad[i][j]);
            }
        }
        System.out.print(set.size());
    }
    static boolean isTrue(int x, int y){
        if(x < 0 || x >= 5 || y >= 5 || y <0)
            return false;
        return true;
    }
    static void dfs(int x, int y, int cnt, int num){
        if(cnt == 6){
            set.add(num);
            return;
        }
        if(isTrue(x+1,y)) dfs(x+1,y,cnt+1,10*num+ad[x+1][y]);
        if(isTrue(x,y-1)) dfs(x,y-1,cnt+1,10*num+ad[x][y-1]);
        if(isTrue(x-1,y)) dfs(x-1,y,cnt+1,10*num+ad[x-1][y]);
        if(isTrue(x,y+1)) dfs(x,y+1,cnt+1,10*num+ad[x][y+1]);
    }
}