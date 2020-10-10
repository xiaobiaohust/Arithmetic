package InterviewGuildCode.Others;

/**
 * 在两个排序数组中找到第K小的数
 * 要求：时间复杂度O(log(min(M,N)))，额外空间复杂度O(1)
 * 思路1：
 *      求第K小的数，最开始的想法是最大堆，但是空间复杂度不满足要求
 *
 * 思路2：利用之前的求两个长度相同排序数组的上中位数
 *  假设长度较短的数组shortArr长S，长度较长的数组longArr长L
 *  1：K<1 或者 K>S+L,
 *  2：K<S，，则在长短两个数组的最前面分别取K个元素，求中位数
 *  3：K>L，令m=L+S-K,则shortArr中[1,S-m-1],不可能是第K个元素,而且是之前的元素；
 *  longArr中[1,L-m-1]也不可能是第K个元素，而且是之前的元素，
 *  如果shortArr[S-m]大于longArr最后一个元素，则shortArr[S-m]是第K个元素
 *  如果longArr[L-m]大于shortArr最后一个元素，则longArr[L-m]是第K个元素
 *  以上都不是则在shortArr[]
 *
 */
public class Problem_27_FindKthMinNumber {
}
