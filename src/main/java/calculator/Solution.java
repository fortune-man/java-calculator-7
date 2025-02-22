package calculator;

//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


//  Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

// 이진 트리 root의 하위 경로를 형성하는지 boolean값을 return
class Solution {
  public boolean isSubPath(ListNode head, TreeNode root) {
    // 재귀 NullPointerException -> null 체크로 개선
    if (root==null || root.left == null || root.right == null) return false;
    boolean subLeft = head.next.equals(root.left);
    boolean subRight = head.next.equals(root.right);

    // root와 head의 val이 동일한 경우
    if (head.val == root.val) {
      // 하위 경로를 형성하면 true
      if (subLeft || subRight && head == null ) { return true; }
      // 아닌 경우 false
      // if (!subLeft || !subRight) { return false; }

    }
    // // 특정 경로에서 하위 경로가 형성되는 경우 true return
    if (subLeft || subRight) { return true; }

    // if (!subLeft || !subRight) { return false; }

    // 다음 head와 root 왼쪽 / 오른쪽 전달하며 재귀한다
    return isSubPath(head.next, root.left) || isSubPath(head.next, root.right);
  }
}
