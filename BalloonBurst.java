/**
TC- O(nlogn)
SC - O(n)
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] balloons = buildBalloonArray(nums);  
        int[][] dp = new int[n][n]; 
        for (int len = 1; len <= n - 2; len++) { 
            for (int left = 1; left < n - 1; left++) { 
                int right = left + len - 1; 
                if (right >= n - 1) {
                    break;
                }
                int maxValue = 0;
                for (int last = left; last <= right; last++) { 
                    maxValue = Math.max(balloons[last] * balloons[left - 1] * balloons[right + 1] 
                                        + dp[left][last - 1] + dp[last + 1][right], maxValue); 
                dp[left][right] = maxValue;
            }
        }
        
    }
    return dp[1][n - 2];
    }
    
    private int[] buildBalloonArray(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }
        balloons[0] = 1;
        balloons[n + 1] = 1;
        return balloons;
    }
}
