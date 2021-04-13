import java.util.HashMap;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node newPrehead = new Node(-1);
        Node cur = head;
        Node newCur = newPrehead;
        while (cur != null) {
            newCur.next = new Node(cur.val);
            map.put(cur, newCur.next);
            cur = cur.next;
            newCur = newCur.next;
        }
        cur = head;
        newCur = newPrehead;
        while (cur != null) {
            newCur.next.random = map.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newPrehead.next;

    }
}
// @lc code=end
