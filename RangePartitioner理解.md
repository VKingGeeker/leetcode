# RangePartitioner理解
[分析](#分析)

<a name="作用"></a>
## 一、作用
Spark中默认分区主要有HashPartitioner和RangePartitioner，今天主要来看下RangePartitioner。

首先看一下类的注释，了解它大概是做什么的

```
/**
 * A [[org.apache.spark.Partitioner]] that partitions sortable records by range into roughly
 * equal ranges. The ranges are determined by sampling the content of the RDD passed in.
 */
 解释：将可排序的记录按范围划分为大致相等的几个范围。这些范围是通过对传入的RDD的内容进行采样来确定的。
```

大致意思就是，把给定的记录集，划分为记录数量大致相等的几个分区，且分区间有序。

1. 首先从父RDD的每个分区中用[水塘抽样]算法随机抽取一定数量的记录。
2. 判断是否存在记录数与其他分区相差较大的分区，对其用sample算子重新抽取，直到所有分区达到大致平衡状态。
3. 根据每个样本的权重与给定的欲分区数，确定每个分区的边界点(为每个分区中抽样结果中的最大样本)。
4. 根据key获取分区id

<a name="分析1"></a>
## 分析
下面列出了类的创建及关键方法

```
class RangePartitioner[K : Ordering : ClassTag, V](
    //欲分区数
    partitions: Int,
    //父RDD
    rdd: RDD[_ <: Product2[K, V]],
    //是否升序
    private var ascending: Boolean = true,
    //默认每个分区抽样个数
    val samplePointsPerPartitionHint: Int = 20)
  extends Partitioner {
    
    
    /**
     * 水塘抽样以及确定抽样未平衡的分区并重新分区，最后进行确定边界列表
     * @return 分区边界列表
     */
    private var rangeBounds: Array[K] = {
        ……
    }
    
    
    /**
     * 根据给定的key获取所属分区编号（重写父类方法）
     * @param key 给定key
     * @return 分区编号
     */
    def getPartition(key: Any): Int ={
        ……
    }
    
  }
private[spark] object RangePartitioner {


    /**
     * 通过水塘抽样算法为每个分区进行抽样
     * @param rdd 父RDD
     * @param sampleSizePerPartition 每个分区的样本数
     * @return (样本总数,Array(分区索引,该分区数据总量,该分区样本列表))
     */
    def sketch[K : ClassTag](
        rdd: RDD[K],
        sampleSizePerPartition: Int): (Long, Array[(Int, Long, Array[K])]) = {
            ……
        }
    
    
    /**
     * 分区边界确定方法
     * @param candidates 已经确定好的样本列表
     * @param partitions 欲分区数
     * @return 分区编号
     */
    def determineBounds[K : Ordering : ClassTag](
        candidates: ArrayBuffer[(K, Float)],
        partitions: Int): Array[K] = {
            ……
        }
}
```
接下来，对函数进行分析，首先看RangePartitioner重写父类的getPartition()方法。

```
1 	def getPartition(key: Any): Int = {
2 	  val k = key.asInstanceOf[K]
3 	  var partition = 0
4 	  if (rangeBounds.length <= 128) {
5 	    // If we have less than 128 partitions naive search
6 	    while (partition < rangeBounds.length && ordering.gt(k, rangeBounds(partition))) {
7 	      partition += 1
8 	    }
9 	  } else {
10	    // Determine which binary search method to use only once.
11	    partition = binarySearch(rangeBounds, k)
12	    // binarySearch either returns the match location or -[insertion point]-1
13	    if (partition < 0) {
14	      partition = -partition-1
15	    }
16	    if (partition > rangeBounds.length) {
17	      partition = rangeBounds.length
18	    }
19	  }
20	  if (ascending) {
21	    partition
22	  } else {
23	    rangeBounds.length - partition
24	  }
25	}
```
如果边界列表长度不大于128，就直接用循环的方式比较给定key与边界点，直到找到大于给定key的边界点，该边界点在边界列表中的索引就是给定key所在的分区索引。

如果边界列表长度大于128，就使用二分法搜索算法查找给定key在边界列表中的索引。如果key存在于边界列表中，则该索引就是key所在分区的索引；否则，二分法会返回-[key按序插入边界列表的位置]-1
