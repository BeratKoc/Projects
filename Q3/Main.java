/* Dynamic Programming Java implementation of Coin
   Change problem */
import java.util.Arrays;
 
class CoinChange {
    static long countWays(int coins[], int n, int sum)
    {
        // Time complexity of this function: O(n*sum)
        // Space Complexity of this function: O(sum)
 
        // table[i] will be storing the number of solutions
        // for value i. We need sum+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (sum = 0)
        long[] table = new long[sum + 1];                                // O(1)
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);                                           // O(1)
 
        // Base case (If given value is 0)
        table[0] = 1;                                                    // O(1)
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < n; i++)                                      // O(n)
            for (int j = coins[i]; j <= sum; j++)                        // O(sum) 
                table[j] += table[j - coins[i]];                         // O(1)
 
        return table[sum];                                               // O(1)
    }
 
    //  Function to test 
    public static void main(String args[])
    {
        int coins[] = {8, 3, 1, 2};
        int n = coins.length;
        int sum = 3;
        System.out.println(countWays(coins, n, sum));
    }
}
// T(n) = O(1) + O(1) + O(1) + O(n) + O(sum) + O(1) + O(1) = O(n*sum)