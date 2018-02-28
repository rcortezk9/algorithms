//Use dynamic programming to find minimum of coins to make a given value

public class MinNumOfCoins {
    // m is the size of array.  the number of different coins.
    static int minCoin (int coins[], int m, int V){

        //table[i] will store the the min number of coins required for i value.
        //so table[V] will have the results
        int table[] = new int[V + 1];

        table[0] = 0; //base case. If V == 0, then requires 0 coins

        for(int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE; //initialize all table values to infinite

        for(int i = 1; i <= V; i++){

            for(int j = 0; j < m; j++) //go thru all coins smaller then i
            if(coins[j] <= i){

                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                    table[i] = sub_res + 1;

            }
        }

        return table[V];

    }

    public static void main(String[] args) {

        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum of coins required is " + minCoin(coins, m, V));
    }
}
