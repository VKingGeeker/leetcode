package com.leetcode.simple.selfdividingnumbers
object SelfDividingNumbers {
  def main(args: Array[String]): Unit = {
    selfDividingNumbers(1,22)
  }

  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    var list = List[Int]()
    for (i<-left to right) {
      var flag = true
      if (!i.toString.contains("0")) {
        val set = i.toString.toCharArray.toSet
        set.foreach(ele => {
          if (i % ele.toString.toInt != 0) {
            flag = false
          }
        })
        if (flag) {
          list = list :+ i
        }
      }
    }
    list
  }
}
