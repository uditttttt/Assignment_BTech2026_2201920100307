import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Map to store which color is assigned to each ball
        HashMap<Integer, Integer> ballToColor = new HashMap<>();

        // Map to store how many times each color appears
        HashMap<Integer, Integer> colorCount = new HashMap<>();

        int n = queries.length; // Number of queries
        int[] result = new int[n]; // Array to store the results
        int distinctColors = 0; // Count of distinct colors

        // Process each query
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];   // The ball being colored
            int newColor = queries[i][1]; // The new color to assign

            // If the ball was already colored, we need to remove the old color
            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball); // Get the old color of the ball
                
                // Reduce the count of the old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                
                // If no ball is using this old color anymore, remove it from the count
                if (colorCount.get(oldColor) == 0) {
                    distinctColors--; // The old color is no longer in use
                }
            }

            // Assign the new color to the ball
            ballToColor.put(ball, newColor);

            // Increase the count of this new color
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);

            // If this is the first ball using this new color, increase the distinct count
            if (colorCount.get(newColor) == 1) {
                distinctColors++;
            }

            // Store the current count of distinct colors in the result array
            result[i] = distinctColors;
        }

        // Return the array with distinct color counts after each query
        return result;
    }
}

/*
 
Step-by-Step Explanation
We use two HashMaps:

ballToColor: Stores which color is assigned to each ball.
colorCount: Stores how many times each color is used.
Processing Each Query

If the ball was already colored, remove the old color if it’s no longer used.
Assign the new color to the ball.
Increase the count of the new color.
Update the distinct color count.
Storing Results

After each query, we store the number of distinct colors in the result array
 */