import java.util
import org.apache.log4j.Logger

object Inputs {
  val logger: Logger = Logger.getLogger(getClass)
  def getSchema(columns: util.ArrayList[String]): String = {
    logger.info("""Select a csv schema from below to process or enter "Q|q" to exit""")
    for (i <- 0 until columns.size()) {
      logger.info(s"Press ${i + 1} to process schema - ${columns.get(i)} ")
    }

    val schemaSelection = scala.io.StdIn.readLine()
    schemaSelection
  }

  //Get Column name as user Input
  /**
   * Lets the user select column
   * @return selected column
   */
  def getColumn: String = {
    logger.info("""select a column  or enter "Q" to exit""")
    val inputColumn = scala.io.StdIn.readLine()
    inputColumn
  }

  //gets user input and check with switch case
  def getOperation: String = {
    println(
      """select Operation
        | Choose 1 : Min
        | Choose 2 : Max
        | Choose 3 : Mean
        | Choose 4 : Median
        | Choose 5 : Mode
        | Choose 6 : Standard deviation
        | Choose 7 : Count
        | Choose 8 : Variance
        | Choose 9 : Harmonic Mean
        | Choose 10 : Geometric Mean
        | Choose 0 : To select another column
        | choose X : To select other schema
        | Choose Q : Exit """.stripMargin)
    val inputOperation = scala.io.StdIn.readLine()
    inputOperation
  }
}
