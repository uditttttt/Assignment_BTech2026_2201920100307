class Solution {
  public int tupleSameProduct(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int count = 0;

      // Loop to find all pairs (i, j) and calculate their product
      for (int i = 0; i < nums.length - 1; i++) {
          for (int j = i + 1; j < nums.length; j++) {
              int product = nums[i] * nums[j];
              // Increment count of this product in the map
              map.put(product, map.getOrDefault(product, 0) + 1);
          }
      }

      // Calculate the number of valid quadruples
      for (int frequency : map.values()) {
          if (frequency > 1) {
              // If a product appears 'n' times, there are n * (n - 1) / 2 ways to form pairs
              count += frequency * (frequency - 1) / 2;
          }
      }

      // Each valid pair of pairs corresponds to 8 quadruples, so multiply by 8
      return count * 8;
  }
}
/*
Explanation:
Mapping Products: In the double loop, we calculate the product for every pair of distinct indices (i, j), storing how many times each product appears in the map.

Counting Pairs: For each product that appears n times, we calculate how many distinct pairs can be formed using the formula n * (n - 1) / 2. This formula counts how many ways we can pick two pairs from n items.

Multiplying by 8: Each valid pair (i, j), (k, l) can be arranged in 8 ways, so we multiply the count by 8.

Time Complexity:
O(n^2), where n is the length of nums, since we are using two nested loops to calculate all pairs.
Space Complexity:
O(n^2), as we store products of pairs in a HashMap. In the worst case, all pairs could have distinct products.

Great question! The formula n * (n - 1) / 2 comes from combinatorics, specifically from calculating how many ways you can choose 2 distinct items from a set of n items.

Explanation:
Imagine you have n distinct items (in our case, distinct pairs of numbers whose products are equal), and you want to know how many ways you can pick two of them. This is equivalent to choosing 2 pairs out of the n pairs, which is a combination problem.

The general formula for combinations is:
 C(n ,2) =  n!/2!*(n-2)! = n(n-1)/2

This formula calculates how many ways we can pick 2 items from a total of n items, without regard to order (i.e., the order of the pairs doesn't matter).

*/