package test1;

public class tile_decoration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		solution(n);
		solution2(n);
	}
	public static long solution(int N) {
       
        long [] arr = new long[N+2];
        long answer = 2*(dp(N,arr)+dp(N+1,arr));
        return answer;
    }
	public static long dp(int n, long[] arr) {
//		if (n<=0) return 0;
		if (n<=2) return 1;
		
		if (arr[n]!=0) return arr[n];

		arr[n]=dp(n-1,arr)+dp(n-2,arr);
		return arr[n];

	}
	
	public static long solution2(int N) {
        long answer = 0;
        long[] dp = new long[81];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        answer = dp[N] * 2 + (dp[N] + dp[N - 1]) * 2;
        return answer;
    }

}
