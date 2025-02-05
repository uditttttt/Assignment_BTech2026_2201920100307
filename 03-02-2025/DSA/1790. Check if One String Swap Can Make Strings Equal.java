class Solution {
  public boolean areAlmostEqual(String s1, String s2) {
// If the strings are already equal
      if (s1.equals(s2)) {
          // If there is a duplicate character in s1, we can swap those
          return true;
      }

      // Find the indices where characters differ
      List<Integer> diff = new ArrayList<>();
      for (int i = 0; i < s1.length(); i++) {
          if (s1.charAt(i) != s2.charAt(i)) {
              diff.add(i);
          }
      }

      // For a valid swap, there should be exactly two positions that differ
      if (diff.size() == 2) {
          int i = diff.get(0);
          int j = diff.get(1);
          // Check if swapping s2[i] and s2[j] makes s2 equal to s1
          return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
      }

      return false;
  }
}



// class Solution {
//     public boolean areAlmostEqual(String s1, String s2) {
//         int n1 = s1.length();
//         int n2 = s2.length();
//         int count = 0;
//         if(n1 != n2) return false;
//         HashMap<Character , Integer> map1 = new HashMap<>();
//         HashMap<Character , Integer> map2 = new HashMap<>();
//         for(int i=0; i<n1; i++){
//             char ch1 = s1.charAt(i);
//             map1.put(ch1 , map1.getOrDefault(ch1 , 0) + 1);
//             char ch2 = s2.charAt(i);
//             map2.put(ch2 , map2.getOrDefault(ch2 , 0) + 1);
//         }

//         for(int i=0 ;i<n1; i++){
//             char ch1 = s1.charAt(i);
//             char ch2 = s2.charAt(i);
//             if(map1.get(ch1) != map2.get(ch1)) return false;

//             if(ch1 != ch2) count++;
//             if(count > 2) return false;
//         }

//         return true;


//     }
// }

