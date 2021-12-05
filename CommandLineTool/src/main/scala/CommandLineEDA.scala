import com.typesafe.config.ConfigFactory
import org.apache.log4j.Logger
import smile._
import java.io._
import java.util._
import smile.data.DataFrame
import scala.collection.mutable.ArrayBuffer

import StatisticalOperations._
import UserOperations.executeOperation
import Inputs._
import Utils.exit


object CommandLineEDA {


 val logger: Logger = Logger.getLogger(getClass)

  /**
   * Loads configuration of the file
   */
  def loadConfig {
    val directory = ConfigFactory.load().getString("directory") //loads the configuration file
    val folderPath = ConfigFactory.load().getString("get.file.folderpath") //loads the configuration file
    val delimiter =  ConfigFactory.load().getString("get.file.delimiter").charAt(0)//loads the configuration file
    val location = directory + folderPath

    val f = new File(location)
    if (!f.isDirectory) {
      logger.info("Selected path is not a directory....")
      System.exit(1)
    }

    val fileNameFilter = new FilenameFilter() {
      override def accept(dir: File, name: String): Boolean = {
        if (name.lastIndexOf('.') > 0) { // get last index for '.' char
          val lastIndex = name.lastIndexOf('.')
          // get extension
          val str = name.substring(lastIndex)
          // match path name extension
          if (str == ".csv") return true
        }
        false
      }
    }

    val filesList = f.listFiles(fileNameFilter)
    val fileActualHeaders = new java.util.HashMap[String, String]()
    val headerSchemas = new java.util.HashMap[String, ArrayList[String]]()

    for (i <- 0 until filesList.length) {
      val filePath = filesList(i).getName
      println(filePath)
      val br = new BufferedReader(new FileReader(filesList(i)))
      val headerString = br.readLine()  // Reads headers of dataset
      val headers = headerString.split(",").toList.sorted.mkString(",")
      fileActualHeaders.put(filePath, headerString)
      if (headerSchemas.containsKey(headers)) {
        headerSchemas.get(headers).add(filePath)
      } else {
        val headerFilesList = new ArrayList[String]()
        headerFilesList.add(filePath)

        headerSchemas.put(headers, headerFilesList)   //Headers as key and Files as Value

      }
    }
    println(headerSchemas, "header")
    val headers = new ArrayList[String](headerSchemas.keySet())
    var selectedColumns = ""
    var validInputReceived = false   // Validates Input
    do {
      val selectedSchema = getSchema(headers)
      if ("Q".equalsIgnoreCase(selectedSchema)) {
        validInputReceived = true
        exit
      } else {
        try {
          selectedColumns = headers.get(selectedSchema.toInt - 1)
          validInputReceived = true
        } catch {
          case e: Exception => {
            logger.info("Invalid Input selected. Please choose a valid option")
            validInputReceived = false
          }
        }
      }

      if (validInputReceived) {
        val selectedFiles = headerSchemas.get(selectedColumns)
        println(selectedFiles, "selectedFiles")

        logger.info("Extracting files...................")
        val tStart = System.currentTimeMillis()
        val dataFrames = new ArrayList[DataFrame]()
        if (selectedFiles.size() > 0) {
          for (i <- 0 until selectedFiles.size()) {
            // Reading as DataFrames
            val data = read.csv(folderPath + "/" + selectedFiles.get(i),delimiter = delimiter)
            println(data)
            dataFrames.add(data)
            println(s"Loaded file : ${selectedFiles.get(i)}")
          }
        }
        val tEnd = System.currentTimeMillis()
        logger.info(s"Extraction Done . Extracted in ${tEnd - tStart}ms")

        val columnNames = dataFrames.get(0).names()  // header names
        val colList = columnNames.toList
        for (i <- 0 until columnNames.length)
          println(s" $i :${colList(i)}")    // prints columns

        var continueColumnFlag = true

        do {
          var inputColumn = getColumn
          try {
            val columnIndex = inputColumn.toInt
            inputColumn = colList(columnIndex)
          } catch {
            case e: Exception => {
              inputColumn = inputColumn
            }
          }

          if (inputColumn == "Q") {
            logger.info("Ending Application")
            continueColumnFlag = false
            exit
          } else if (!columnNames.contains(inputColumn)) {
            logger.error("Column Doesn't exist in CSV. Please choose a correct column")
          } else if ("String".equalsIgnoreCase(dataFrames.get(0)(inputColumn).`type`().toString())) {
            logger.error("Selected Column is of type 'String'. Please choose another column")
          } else {

            var column = dataFrames.get(0)(inputColumn).toStringArray()
            for (i <- 1 until dataFrames.size()) {
              column = column ++ (dataFrames.get(i)(inputColumn).toStringArray())
            }

            val valList = new ArrayBuffer[Double]()
            var nullCount = 0

            column.foreach(x => if (x != null && x !="null") valList += (x.toDouble) else nullCount = nullCount + 1)

            if (nullCount > 0) {
              val slicedMedian = findMedian(valList.toArray)
              for (i <- 0 until nullCount) {
                valList += slicedMedian
              }
            }
            continueColumnFlag = executeOperation(valList.toArray, continueColumnFlag)
          }
        } while (continueColumnFlag)
      }
    } while (true)
  }

  def main(args: Array[String]): Unit = {
    loadConfig
  }
}