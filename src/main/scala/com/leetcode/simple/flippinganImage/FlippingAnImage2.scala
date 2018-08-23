package com.leetcode.simple.flippinganImage

object FlippingAnImage2 {
  def main(args: Array[String]): Unit = {
    flipAndInvertImage(Array(Array(1, 1, 0), Array(1, 0, 1), Array(0, 0, 0))).foreach(_.foreach(println(_)))

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

    val B = new Array[Array[Int]](A.length)
    for (i <- A.indices) {
      val bi = new Array[Int](A(i).length)
      for (j <- A(i).indices) {
        bi(j) = A(i)(A(i).length-1-j)
      }
      B(i) = bi
    }

    for (i <- B.indices) {
      for (j <- B(i).indices) {
        if (1 == B(i)(j)) {
          B(i)(j) = 0
        } else {
          B(i)(j) = 1
        }
      }
    }
    B
  }
}
