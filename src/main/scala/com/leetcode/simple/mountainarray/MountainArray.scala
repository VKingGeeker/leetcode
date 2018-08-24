package com.leetcode.simple.mountainarray
import scala.util.control.Breaks._
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
