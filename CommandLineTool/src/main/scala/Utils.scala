import java.text.DecimalFormat

import org.apache.log4j.Logger

object Utils {
  val logger: Logger = Logger.getLogger(getClass)


  //exits from execution
  def exit {
    logger.info("Ending Application....")
    System.exit(1)
  }

  def roundOff(value: Double): Double = {
    val df = new DecimalFormat("0.00")
    df.format(value).toDouble
  }

}
