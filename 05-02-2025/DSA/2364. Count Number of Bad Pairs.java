import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        // Step 1: Transform the array
        // We modify each element nums[i] to nums[i] - i to make comparisons easier.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - i;
        }

        // Step 2: Initialize a HashMap to store frequencies of transformed values
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Variable to store the count of bad pairs
        long count = 0;
        
        // Step 3: Insert the first element into the map
        map.put(nums[0], 1);

        // Step 4: Iterate through the rest of the array to count bad pairs
        for (int j = 1; j < nums.length; j++) {
            // Total pairs that can be formed with (j, i) where i < j
            long totalPairs = j;
            
            // Number of good pairs (pairs where nums[j] - j == nums[i] - i)
            long goodPairs = 0;
            if (map.containsKey(nums[j])) {
                goodPairs = map.get(nums[j]); // Get the count of previously seen nums[j] values
            }
            
            // Bad pairs are the remaining pairs
            long badPairs = totalPairs - goodPairs;

            // Add the count of bad pairs to the total count
            count += badPairs;

            // Update the HashMap with the current element's frequency
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }

        // Step 5: Return the final count of bad pairs
        return count;
    }
}
