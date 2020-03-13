package com.leetcode.simple.sqrtx

/**
  * Created with IntelliJ IDEA.
  * Description: Implement int sqrt(int x).
  *
  * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
  *
  * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
  *
  * Example 1:
  *
  * Input: 4
  * Output: 2
  *
  * Example 2:
  *
  * Input: 8
  * Output: 2
  * Explanation: The square root of 8 is 2.82842..., and since
  * the decimal part is truncated, 2 is returned.
  * User: ww
  * Date: 2019-04-25
  * Time: 13:48
  */


object SqrtX {
  def main(args: Array[String]): Unit = {
    println(mySqrt(2147483647))
  }

  def mySqrt(x: Int): Int = {
    var res = 0
    var i = 0
    while (i <= (x:BigInt)){
      if (x>=i*i && x<=(i+1) * (i+1)) {
        res = i
      }
      i+=1
    }
    res
  }
}
