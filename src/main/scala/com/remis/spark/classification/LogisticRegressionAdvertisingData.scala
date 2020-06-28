package com.remis.spark.classification

//////////////////////////////////////////////
// LOGISTIC REGRESSION PROJECT //////////////
////////////////////////////////////////////

//  In this project we will be working with a fake advertising data set, indicating whether or not a particular internet user clicked on an Advertisement. We will try to create a model that will predict whether or not they will click on an ad based off the features of that user.
//  This data set contains the following features:
//    'Daily Time Spent on Site': consumer time on site in minutes
//    'Age': cutomer age in years
//    'Area Income': Avg. Income of geographical area of consumer
//    'Daily Internet Usage': Avg. minutes a day consumer is on the internet
//    'Ad Topic Line': Headline of the advertisement
//    'City': City of consumer
//    'Male': Whether or not consumer was male
//    'Country': Country of consumer
//    'Timestamp': Time at which consumer clicked on Ad or closed window
//    'Clicked on Ad': 0 or 1 indicated clicking on Ad

import org.apache.log4j._
import org.apache.log4j.spi.RootLogger

object LogisticRegressionAdvertisingData {

  def main(args: Array[String]): Unit = {
    Logger.getRootLogger.setLevel(Level.ERROR)
    ////////////////////////
    /// GET THE DATA //////
    //////////////////////

    // Import SparkSession and Logistic Regression
    import org.apache.spark.sql.SparkSession
    import org.apache.spark.ml.classification.LogisticRegression

    // Optional: Use the following code below to set the Error reporting

    // Create a Spark Session
    val spark = SparkSession.builder().master("local[*]").appName("LogReg Adv Data").getOrCreate()
    import spark.implicits._
    import org.apache.spark.sql.functions._

    // Use Spark to read in the Advertising csv file.
    val df = spark.read.option("inferSchema",true).option("header",true).csv("data/advertising.csv")

    // Print the Schema of the DataFrame
    df.printSchema()

    //    root
    //    |-- Daily Time Spent on Site: double (nullable = true)
    //    |-- Age: integer (nullable = true)
    //    |-- Area Income: double (nullable = true)
    //    |-- Daily Internet Usage: double (nullable = true)
    //    |-- Ad Topic Line: string (nullable = true)
    //    |-- City: string (nullable = true)
    //    |-- Male: integer (nullable = true)
    //    |-- Country: string (nullable = true)
    //    |-- Timestamp: timestamp (nullable = true)
    //    |-- Clicked on Ad: integer (nullable = true)

    ///////////////////////
    /// Display Data /////
    /////////////////////
    df.show(5,false)

    // Print out a sample row of the data (multiple ways to do this)


    ////////////////////////////////////////////////////
    //// Setting Up DataFrame for Machine Learning ////
    //////////////////////////////////////////////////

    //   Do the Following:
    //    - Rename the Clicked on Ad column to "label"
    //    - Grab the following columns "Daily Time Spent on Site","Age","Area Income","Daily Internet Usage","Timestamp","Male"
    //    - Create a new column called Hour from the Timestamp containing the Hour of the click

    val df4ml = df.withColumnRenamed("Clicked on Ad","label")
      .withColumn("Hour", hour( col("Timestamp")))

    df4ml.show(10,false)

    // Import VectorAssembler and Vectors

    // Create a new VectorAssembler object called assembler for the feature
    // columns as the input Set the output column to be called features


    // Use randomSplit to create a train test split of 70/30


    ///////////////////////////////
    // Set Up the Pipeline ///////
    /////////////////////////////

    // Import Pipeline
    // Create a new LogisticRegression object called lr

    // Create a new pipeline with the stages: assembler, lr

    // Fit the pipeline to training set.


    // Get Results on Test Set with transform

    ////////////////////////////////////
    //// MODEL EVALUATION /////////////
    //////////////////////////////////

    // For Metrics and Evaluation import MulticlassMetrics

    // Convert the test results to an RDD using .as and .rdd

    // Instantiate a new MulticlassMetrics object

    // Print out the Confusion matrix


  }


}
