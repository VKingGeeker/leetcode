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
object SortArrayByParity {
  def main(args: Array[String]): Unit = {
    println(sortArrayByParity(Array(1,3,4,2,5,7)).foreach(println(_)))
  }
  def sortArrayByParity(A: Array[Int]): Array[Int] = {

    val a = Array[Int]().toBuffer
    val b = Array[Int]().toBuffer
    A.foreach(ele=>{if (ele%2 ==0) a.+=(ele) else b.+=(ele)})
    b.++=(a).toArray
  }
}
