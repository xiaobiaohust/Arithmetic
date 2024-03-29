package JianZhiOffer.Chapter5;

/**
 *数据流中的中位数
 * 如果数据流的数据数目为奇数，返回中间的一个，如果为偶数，返回中间两个数的平均值
 * 思路1：
 *  使用数组存储数据，当数据流中有新数据，进行插入；可以使用partition函数找出数组中
 *  中位数，插入和找到中位数的时间复杂度分别为：O(1)、O(N)
 *
 *  思路2：
 *  排序的链表，插入时间复杂度O(N)，可以使用一个指针指向中间元素，这样找到
 *  中位数的时间复杂度为O(1)
 *
 *  思路3：
 *   平衡二叉搜索树（AVL），只不过平衡的标准不一样，这个平衡二叉搜索树
 *   指的是左右子树的节点数。这个实现相对复杂
 *
 *   思路4：
 *   将数据进行排序后，两个指针p1,p2指向中间元素，可以看到，左边的元素全部小于p1，
 *   右边的元素全部大于p2。用一个最大堆实现左边的数据容器，用一个最小堆实现右边的
 *   数据容器，往堆中插入一个元素的时间复杂度为O(logN)，取得中位数的时间复杂度为
 *   O(1)
 *
 */
public class P214_StreamMedian {
    /**
     * 堆
     */
    public static class MedianFinder1{

    }
}
