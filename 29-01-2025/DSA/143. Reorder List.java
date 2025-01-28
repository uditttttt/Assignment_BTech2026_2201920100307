/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 // arraylist method

// // class Solution {
// //     public void reorderList(ListNode head) {
// //         ArrayList<Integer> arr = new ArrayList<>();
// //         ListNode temp = head;
// //         while(temp != null){
// //             arr.add(temp.val);
// //             temp = temp.next;
// //         }
// //         int l =1;
// //         int r  = arr.size()-1;
// //         int i = 1;
// //         while(l<=r){
// //             if(i%2 == 0){
// //                 int value = arr.get(l);
// //                 ListNode newnode = new ListNode(value);
// //                 head.next = newnode;
// //                 head = head.next;
// //                 l++;
// //                 i++;
// //             }else{
// //                 ListNode newnode = new ListNode(arr.get(r));
// //                 head.next = newnode;
// //                 head = head.next;
// //                 r--;  
// //                 i++;         
// //             }
// //         }
// //     }
// // }

// // recursion method

// class Solution {
//     ListNode curr;  // Global node to track the current node from the start of the list

//     // Recursive function to reorder the list
//     void solve(ListNode head) {
//         // Base case for recursion: If the head reaches the end (null), stop recursion
//         if (head == null) {
//             return;
//         }

//         // Recursive call to reach the last node
//         solve(head.next);

//         // Backtracking starts from here after reaching the end of the list
//         // Base case for backtracking: if curr.next is null, it means we have reached the last node and should stop
//         if (curr.next == null) {
//             return;
//         }
//         // Edge case: when curr and head point to the same node (i.e., for odd-length lists), we are at the middle, so break the list
//         else if (curr == head) {
//             head.next = null;  // Set the next pointer of the middle node to null to terminate the list
//             return;
//         }

//         // Store the next node after curr in a temporary variable
//         ListNode temp = curr.next;

//         // Link curr to the current backtracked head (this creates the reordered connection)
//         curr.next = head;

//         // If we encounter an even-length list and have reached the end, break the loop
//         head.next = (temp == head) ? null : temp;

//         // Move curr to the next node in the original list to continue backtracking
//         curr = temp;
//     }

//     // Main function to reorder the list
//     public void reorderList(ListNode head) {
//         curr = head;  // Initialize curr to point to the start of the list
//         solve(head);  // Call the recursive function
//     }
// }

class Solution {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;
        ListNode next; 
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head;
        ListNode right = prev;
        ListNode nextl;
        ListNode nextr;
        while(left != null && right != null){
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;
        }
    }
}