# scala-command-line-eda
Contains the implementation of dataframe which is present in python and spark. Implemented in native scala code
## Introduction
A command line tool which helps to import any csv dataset into memory and performs various statistical functional that helps data analyst and data scientist to perform EDA.
## Software Requirements
The project has the following software requirements.

1) Scala Version: 2.12.8
2) Java SDK: 8
3) Sbt Version: 1.3.8

## Library Dependencies
Following are the library dependencies of this project.


- smile-scala: 2.3.0 library for dataframe
- scalatest: 3.1.1 Test library for scala
- typesafe config: 0.3.0 Configuration Reader library
- scala-logging: 3.9.2 library for logger
- logback-classic:1.0.3 library for logger

## Execution
Clone this repository, Add the directory of the folder where the .csv(which you wanted to perform operations on) files are located in application.conf. Now run CommandLineEDA.scala
- StatisticalOperations.scala contains the implementation of Statistical Operations that performs on certain selected data.
- Inputs.scala contains the code that takes user inputs.
- UserOperations.scala performs respective operations based on user's choice.

## Setting up the tool
Now launch sbt inside the project directory. 
### Run the following commands in the terminal
- `compile` to compile
- `run` to launch the Tool

