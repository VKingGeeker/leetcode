package com.leetcode

object JewelsAndStones  {
  def main(args: Array[String]): Unit = {
//    numJewelsInStones("aA","aAAbbbb")
    println(Array(1,2,3).reverse)
  }

  def numJewelsInStones(J: String, S: String): Int = {
    val js = J.toCharArray
    var count = 0
    for (ele1 <- js) {
      if (S.contains(ele1)) {
        count += 1
      }
    }
    count
  }
}
