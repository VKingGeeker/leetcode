package com.leetcode.simple.selfdividingnumbers
import util.control.Breaks._
object SelfDividingNumbers2 {
  def main(args: Array[String]): Unit = {
    selfDividingNumbers(1,22)
  }

  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    var list = List[Int]()
    for (i<-left to right) {
      var flag = true
      var temp = i
      breakable{
        while (temp > 0) {
          val last = temp % 10
          if (last == 0 || i % last != 0) {
            flag = false
            break()
          }
          temp /= 10
        }
      }
        if (flag) {
          list = list :+ i
        }
      println(list.last)
    }
    list
  }
}
