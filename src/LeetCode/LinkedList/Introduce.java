package LeetCode.LinkedList;

/*
链表
1、链表是一种物理存储单元非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接
次序实现的。数组插入和删除的平均时间复杂度都是O(N)，对查询特别友好，链表适合删除插入
2、链表的基本操作
    * 插入
    * 删除
    * 遍历
3、链表使用思路
（1）一个原则
     一个原则就是画图，通过画图来了解思路
（2）两个考点
    * 指针的修改
        典型的是反转链表
    * 链表的拼接
（3）三个注意
    * 环
        出现了环，造成死循环，使用快慢指针解决
    * 边界
        头结点可能被移除或者更改，使用虚拟节点
    * 前后序
        前序遍历，可以想象前面的链表都处理好了，怎么处理的不用管。后序遍历可以想象
        后面的链表都处理好了，怎么处理的buyon管
        前序遍历：
            def dfs(head, pre):
                if not head: return pre
                next = head.next
                # # 主逻辑（改变指针）在后面
                head.next = pre
                dfs(next, head)
            dfs(head, None)
        后序遍历：
            def dfs(head):
                if not head or not head.next: return head
                res = dfs(head.next)
                # 主逻辑（改变指针）在进入后面的节点的后面，也就是递归返回的过程会执行到
                head.next.next = head
                head.next = None

    return res

（4）四个技巧
    * 虚拟头结点
        虚拟头结点指向头结点，不是题目中给的节点，不参与运算，因此不需要特殊判断
    * 快慢指针
        环的问题，或者倒数第几项元素都可以使用快慢指针
    * 穿针引线
    * 先穿再排后判空

 */
 

public class Introduce {
}
