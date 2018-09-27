package com.leetcode.simple.mountainarray
import scala.util.control.Breaks._

/**
  * Let's call an array A a mountain if the following properties hold:
  *
  * A.length >= 3
  * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
  * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
  *
  * Example 1:
  *
  * Input: [0,1,0]
  * Output: 1
  * Example 2:
  *
  * Input: [0,2,1,0]
  * Output: 1
  * Note:
  *
  * 3 <= A.length <= 10000
  * 0 <= A[i] <= 10^^6
  * A is a mountain, as defined above.
  **/
object MountainArray {
  def main(args: Array[String]): Unit = {
    println(peakIndexInMountainArray(Array(0,1,0)))
  }
  def peakIndexInMountainArray(A: Array[Int]): Int = {
    var index = 0
    breakable{
      for (i<- 0 until A.length-1) {
        if (A(i)>A(i+1)) {
          index = i
          break()
        }
      }
    }
    index
  }
}
