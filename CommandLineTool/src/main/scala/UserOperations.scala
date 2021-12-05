import org.apache.log4j.Logger
import StatisticalOperations._
import Inputs.{getColumn, getOperation, getSchema}
import Utils.{exit, roundOff}

object UserOperations {
 val logger: Logger = Logger.getLogger(getClass)
  def executeOperation(valList: Array[Double], continueColumnFlagInput: Boolean):Boolean = {
    var continueOperationFlag = true
    var continueColumnFlag = continueColumnFlagInput
    do {
      val operation = getOperation
      operation match {
        case "Q" =>
          continueOperationFlag = false
          exit
        case "0" =>
          continueOperationFlag = false
        case "X" =>
          continueOperationFlag = false
          continueColumnFlag = false
        case "1" => findMin(valList)
        case "2" => findMax(valList)
        case "3" => findMean(valList)
        case "4" =>
          val medianResult = findMedian(valList)
          logger.info(s"Median : ${roundOff(medianResult)}")
        case "5" => findMode(valList)
        case "6" => findStdDev(valList)
        case "7" => findCount(valList)
        case "8" => findVariance(valList)
        case "9" => findHarmonicMean(valList)
        case "10" => findGeometricMean(valList)
        case _ => logger.error("choose a valid number")
      }
    } while (continueOperationFlag)
    continueColumnFlag
  }
}