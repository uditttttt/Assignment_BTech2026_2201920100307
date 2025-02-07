class Solution {
  public int kthGrammar(int n, int k) {
      if (n == 1 && k == 1) {
          return 0;
      }
      int len = (int) Math.pow(2, n - 1);
      int mid = len / 2;
      if (k <= mid) {
          return kthGrammar(n - 1, k);
      } else { // (k>mid)
          return 1 ^ kthGrammar(n - 1, k - mid);  // returning not of answer(means opposite)
      }
  }
}



// class Solution {
//     public int kthGrammar(int n, int k) {
//         if( n == 1 && k == 1){
//             return 0;
//         }
//         int num = (int)Math.pow(2, n-1);
//         int mid  = num/2;
//         if(k <= mid){
//             return kthGrammar(n-1, k);
//         }else{
//            if( kthGrammar(n-1, k-mid) == 0){
//             return 1;
//            }else{
//             return 0;
//            }
//         }
//     }
// }