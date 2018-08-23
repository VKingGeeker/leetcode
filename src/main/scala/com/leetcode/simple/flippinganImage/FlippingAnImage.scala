package com.leetcode.simple.flippinganImage

object FlippingAnImage {
  def main(args: Array[String]): Unit = {
    flipAndInvertImage(Array(Array(1,1,0),Array(1,0,1),Array(0,0,0))).foreach(_.foreach(println(_)))

//    println(flipAndInvertImage(Array(Array(1,1,0),Array(1,0,1),Array(0,0,0))))
  }

  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
    //    输入: [[1,1,0],[1,0,1],[0,0,0]]
    //    输出: [[1,0,0],[0,1,0],[1,1,1]]
    //    解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
    //    然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]


    //    输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    //    输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    //    解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
    //    然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]


    for (i <- A.indices) {
      A(i) = A(i).reverse
    }

    for (i <- A.indices) {
      for (j <- A(i).indices) {
        if (1 == A(i)(j)){
          A(i)(j) = 0
        }else{
          A(i)(j) = 1
        }
      }
    }
    A
  }
}
