package com.leetcode.simple.mergetwobinarytrees


//    Definition for a binary tree node.
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

object MergeTwoBinaryTrees {

  def main(args: Array[String]): Unit = {

  }

  object Solution {
    def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {

      if (t1 == null)
        return t2

      if (t2 == null)
        return t1
      t1.value += t2.value
      t1.left = mergeTrees(t1.left, t2.left)
      t1.right = mergeTrees(t1.right, t2.right)
      t1
    }
  }

}
