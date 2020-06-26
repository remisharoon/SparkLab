package com.remis.spark.sixsparkexercises
import org.apache.spark.sql.SparkSession

// What is the average revenue of the orders?

object Exercise1 extends App{

  val spark = SparkSession.builder
  .master("local")
  .config("spark.sql.autoBroadcastJoinThreshold", -1)
  .config("spark.executor.memory", "500mb")
  .appName("Exercise1")
  .getOrCreate()



}
