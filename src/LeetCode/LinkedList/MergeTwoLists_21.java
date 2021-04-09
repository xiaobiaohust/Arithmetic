package LeetCode.LinkedList;

public class MergeTwoLists_21 {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    /*
    方法一、递归
     思路：递归的定义两个链表的merge操作
        list1[0]+merge(list1[1:],list2)   list1[0]<list2[0]
        list2[0]+merge(list1,list2[1:])   otherwise
        我们直接将以上递归过程建模，同时需要考虑边界情况。
        如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要
        返回非空链表。否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，
        然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束
    时间复杂度：O(N+M)，
        每一次递归调用都会去掉L1或者L2中的头结点，所以实际复杂度取决于合并后的链表长度
    空间复杂度：O(N+M)
        递归调用时需要消耗栈空间，栈空间的大小取决于递归调用的深度
     */
    public ListNode merge1(ListNode L1, ListNode L2) {
        if (L1 == null) {
            return L2;
        } else if (L2 == null) {
            return L1;
        } else if (L1.value < L2.value) {
            L1.next = merge1(L1.next, L2);
            return L1;
        } else {
            L2.next = merge1(L1, L2.next);
            return L2;
        }
    }

    /*
    方法二、迭代
    思路：当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，
        将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点
        向后移一位。
    算法：
        首先，我们设定一个哨兵节点 prehead ，这可以在最后让我们比较容易地返回合并
        后的链表。我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。然后，
        我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前节点的值小于
        等于 l2 ，我们就把 l1 当前的节点接在 prev 节点的后面同时将 l1 指针往后移一位。
        否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都需要
        把 prev 向后移一位。

        在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的
        ，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素
        都要大。这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链
        表即可。
    时间复杂度：O(N+M)
    空间复杂度：O(1)


     */

    public ListNode merge2(ListNode L1, ListNode L2) {
        ListNode prehead = new ListNode(0);
        ListNode cur = prehead;
        while (L1 != null && L2 != null) {
            if (L1.value < L2.value) {
                cur.next = L1;
                L1 = L1.next;
            } else {
                cur.next = L2;
                L2 = L2.next;
            }
        }
        cur.next = L1 == null ? L1 : L2;
        return prehead.next;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

        }
    }


}
