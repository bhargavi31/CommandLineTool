import org.apache.log4j.Logger

import Utils.roundOff

object StatisticalOperations {

 val logger: Logger = Logger.getLogger(getClass)
  /**
   * Calculates Minimum of selected column
   * @param col selected column
   * @return Minimum of the column
   */
  def findMin(col: Array[Double]):Double={
    logger.info("Calculating Minimum...")
    val tStart = System.currentTimeMillis()
    val minimum = col.min
    val tEnd = System.currentTimeMillis()
    logger.info(s" Minimum value : $minimum executed in ${tEnd - tStart}ms ")
    minimum
  }

  /**
   * finds Maximum value of selected Column
   * @param col selected column
   * @return Minimum of the column
   */
  def findMax(col: Array[Double]):Double= {
    logger.info("Calculating Maximum...")
    val tStart = System.currentTimeMillis()
    val maximum = col.max
    val tEnd = System.currentTimeMillis()
    logger.info(s" Maximum value : $maximum executed in ${tEnd - tStart}ms")
    maximum
  }
  /**
   * calculates mean of selected column
   * @param col selected column by user
   * @return  Mean of the column
   */
  def findMean(col: Array[Double]): Double = {
    logger.info("Calculating Mean...")
    val tStart = System.currentTimeMillis()
    val x = col.length
    val mean = roundOff(col.sum / x)
    val tEnd = System.currentTimeMillis()
    logger.info(s" Mean : $mean executed in ${tEnd - tStart}ms")
    mean
  }
  /**
   * calculate median of selected column
   * @param col selected column by user
   * @return  Median of the column
   */
  def findMedian(col: Array[Double]): Double = {
    logger.info("Calculating Median...")
    val tStart = System.currentTimeMillis()
    val (lower, upper) = col.sortWith(_ < _).splitAt(col.length / 2)
    var median = 0.0
    if (col.length % 2 == 0) {
     median = roundOff((lower.last + upper.head) / 2.0)
      val tEnd = System.currentTimeMillis()
      logger.info(s"Median :  $median executed in ${tEnd - tStart}ms")
      median
    }
    else {
      val tStart = System.currentTimeMillis()
      median =  roundOff(upper.head)
      val tEnd = System.currentTimeMillis()
      logger.info(s"Median :  $median executed in ${tEnd - tStart}ms")
      median
    }
  }

  /**
   * calculates mode
   * @param col Selected column by user
   * @return  Mode of the column
   */
  def findMode(col: Array[Double]): Double = {
    logger.info("Calculating Mode...")
    val tStart = System.currentTimeMillis()
    val mode = col.groupBy(i => i).mapValues(_.length).maxBy(_._2)._1
    val tEnd = System.currentTimeMillis()
    logger.info(s"Mode : $mode executed in ${tEnd - tStart}ms")
   mode
  }

  /**
   * calculates Standard Deviation
   * @param col Selected column by user
   * @return Standard Deviation of the column
   */
  def findStdDev(col: Array[Double]): Double = {
    logger.info("Calculating Standard Deviation...")
    val tStart = System.currentTimeMillis()
    val mean = col.sum / col.length
    val stdDev = roundOff(Math.sqrt((col.map(_ - mean)
      .map(t => t * t).sum) / col.length))
    val tEnd = System.currentTimeMillis()
    logger.info(s"Standard deviation : $stdDev executed in ${tEnd - tStart}ms")
    stdDev
  }
  /**
   * Counts the number of values
   * @param col Selected column by user
   * @return Count of the column
   */
  def findCount(col: Array[Double]):Double = {
    logger.info("Counting...")
    val tStart = System.currentTimeMillis()
    val count = col.length
    val tEnd = System.currentTimeMillis()
    logger.info(s"Count : $count executed in ${tEnd - tStart}ms")
    count
  }
  /**
   * Calculates Harmonic Mean
   * @param col Selected column by user
   * @return Harmonic Mean of the column
   */
  def findHarmonicMean(col: Array[Double]): Double = { // Declare sum variables and
    logger.info("Calculating Harmonic Mean...")
    val tStart = System.currentTimeMillis()
    var sum = 0.0  // initialize with zero
    val x = col.length
    for (i <- 0 until x) {
      val deno = 1/ col(i)
      sum = sum+deno
    }
    val HM = roundOff( x / sum)
    val tEnd = System.currentTimeMillis()
    logger.info(s"Harmonic Mean : $HM executed in ${tEnd - tStart}ms")
    HM
  }

  /**
   * Calculates Variance
   * @param col Selected column by user
   * @return Variance of the column
   */
  def findVariance(col: Array[Double]): Double = { // Compute mean (average
    // of elements)
    logger.info("Calculating Variance...")
    val tStart = System.currentTimeMillis()
    val mean = findMean(col)
    val length = col.length
    var sum = 0.0
    for(i <- 0 until length) {
      sum =  sum + Math.pow((col(i) - mean), 2)
    }

    val variance = roundOff(sum / length)
    val tEnd = System.currentTimeMillis()
    logger.info(s"Variance : $variance executed in ${tEnd - tStart}ms")
    variance

  }
  /**
   * Calculates Geometric Mean
   * @param col Selected column by user
   * @return Geometric Mean of the column
   */
  def findGeometricMean(col: Array[Double]): Double = { // declare product variable and
    // initialize it to 1.
    logger.info("Calculating Geometric Mean...")
    val tStart = System.currentTimeMillis()
    var product = 1.0
    val length = col.length
    for (i <- 0 until length) {
      product = product * col(i)
    }
    val gm = roundOff(Math.pow(product, 1.toFloat / length))
    val tEnd = System.currentTimeMillis()
    logger.info(s"Geometric Mean : $gm executed in ${tEnd - tStart}ms")
    gm
  }

}
