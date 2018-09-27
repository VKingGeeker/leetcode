package com.leetcode.simple.smallestrangeI
import scala.util.control.Breaks._

/**
  * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
  *
  * After this process, we have some array B.
  *
  * Return the smallest possible difference between the maximum value of B and the minimum value of B.
  *
  *
  *
  * Example 1:
  *
  * Input: A = [1], K = 0
  * Output: 0
  * Explanation: B = [1]
  *
  * Example 2:
  *
  * Input: A = [0,10], K = 2
  * Output: 6
  * Explanation: B = [2,8]
  *
  * Example 3:
  *
  * Input: A = [1,3,6], K = 3
  * Output: 0
  * Explanation: B = [3,3,3] or B = [4,4,4]
  *
  *
  *
  * Note:
  *
  * 1 <= A.length <= 10000
  * 0 <= A[i] <= 10000
  * 0 <= K <= 10000
  */
object SmallestRangeI {
  def main(args: Array[String]): Unit = {
    println(smallestRangeI(Array(0,10), 2))
  }
//  def smallestRangeI(A: Array[Int], K: Int): Int = {
//    var min = 9999999
//    val maxOfA = A.max
//    val minOfA = A.min
//    breakable{
//      for(i <- -K to K){
//        for(j <- -K to K) {
//          if ((maxOfA + j) - (minOfA + i) < 0) {
//            min = 0
//            break()
//          }
//          if ((maxOfA + j) - (minOfA + i) < min) {
//            min = Math.abs((A.max + j) - (A.min + i))
//          }
//        }
//      }
//    }
//    min
//  }

//呈祥
  def smallestRangeI(A: Array[Int],s:Int): Int = {
    val d = A.length
    val b = A.sortWith(_<_)
    val c = b(d-1) - b(0)
    var e = 0
    if(2*s<c){
      e = b(d-1)-s - (b(0)+s)
    }
    e
  }
}
