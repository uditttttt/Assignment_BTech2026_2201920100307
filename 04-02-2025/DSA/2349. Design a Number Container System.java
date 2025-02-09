class NumberContainers {
  private Map<Integer, PriorityQueue<Integer>> res;
  private Map<Integer, Integer> index_val;

  public NumberContainers() {
      res = new HashMap<>();
      index_val = new HashMap<>();
  }

  public void change(int index, int number) {
      // If index already exists, remove it from the old number's priority queue
      if (index_val.containsKey(index)) {
          int prevNum = index_val.get(index);
          if (prevNum == number)
              return; // No need to change if same number
          res.get(prevNum).remove(index);
      }

      // If the number does not have a priority queue, create one
      // if (!res.containsKey(number)) {
      // res.put(number, new PriorityQueue<>());
      // }

      // // Add the index to the priority queue
      // res.get(number).offer(index);

      // Shorthand for above code
      res.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index); 

      // Update the index-to-number mapping
      index_val.put(index, number);
  }

  public int find(int number) {
      // // Get the priority queue for the number
      // PriorityQueue<Integer> pq = res.get(number);

      // // If the number does not exist or has an empty queue, return -1
      // if (pq == null || pq.isEmpty()) {
      // return -1;
      // }
      
      // by default pq show min heap property(means elements r arranged in ascending order)
      // return pq.peek(); // Return the smallest index
       
       // Shorthand for above codeA
      PriorityQueue<Integer> pq = res.getOrDefault(number, new PriorityQueue<>());
      return pq.isEmpty() ? -1 : pq.peek();
  }
}

/**
* Your NumberContainers object will be instantiated and called as such:
* NumberContainers obj = new NumberContainers();
* obj.change(index,number);
* int param_2 = obj.find(number);
*/