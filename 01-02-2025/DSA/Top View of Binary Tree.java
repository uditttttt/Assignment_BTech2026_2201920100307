
/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Info{
  int hd;
  Node node;
  
  public Info(int hd , Node node){
      this.hd = hd;
      this.node = node;
  }
}

class Solution {
  static ArrayList<Integer> topView(Node root) {
      ArrayList<Integer> ans = new ArrayList<>();
      if (root == null) return ans;

      // Map to store the first node encountered at each horizontal distance (hd)
      TreeMap<Integer, Integer> map = new TreeMap<>();
      Queue<Info> q = new LinkedList<>();
      
      // Start with root at horizontal distance 0
      q.add(new Info(0, root));

      while (!q.isEmpty()) {
          Info curr = q.poll();
          
          // If horizontal distance (hd) is encountered for the first time, store the node
          if (!map.containsKey(curr.hd)) {
              map.put(curr.hd, curr.node.data);
          }

          // Process left and right child
          if (curr.node.left != null) {
              q.add(new Info(curr.hd - 1, curr.node.left));
          }
          if (curr.node.right != null) {
              q.add(new Info(curr.hd + 1, curr.node.right));
          }
      }

      // Extracting values from map in sorted order (left to right)
      ans.addAll(map.values());
      return ans;
  }
}