package com.leetcode.simple.sortarraybyparity
/**
  * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
  *
  * You may return any answer array that satisfies this condition.
  *
  *
  *
  * Example 1:
  *
  * Input: [3,1,2,4]
  * Output: [2,4,3,1]
  * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
  *
  *
  *
  * Note:
  *
  * 1 <= A.length <= 5000
  * 0 <= A[i] <= 5000
  */
object SortArrayByParity2 {
  def main(args: Array[String]): Unit = {
    println(sortArrayByParity(Array(1,3,4,2,5,7)).foreach(println(_)))
  }
  def sortArrayByParity(A: Array[Int]): Array[Int] = {
    //partition分割符合条件和不符合条件的元素到一个数组二元组中
    val (even,odd) = A.partition(_%2 == 0)
    //两个数组可以合并成一个
    even ++ odd
  }
}
