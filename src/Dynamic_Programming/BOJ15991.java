package Dynamic_Programming;

//BOJ 15991  1, 2, 3 더하기 6
import java.util.*;

public class BOJ15991 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        long dp[] = new long[100001];

        //조건을 충족시키기 위해 dp[0] = 1로 함
        //아무것도 안 더하는 방법이 있다고 생각
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;

        for(int i = 6; i < dp.length; i++){
            dp[i] = (dp[i - 6] + dp[i - 4] + dp[i - 2]) % 1000000009;
        }

        int test = s.nextInt();

        while(test-- > 0){
            int num = s.nextInt();

            System.out.println(dp[num]);
        }
    }
}
