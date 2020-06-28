package com.remis.spark.context


import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

trait SparkContext {
  Logger.getLogger("org.apache").setLevel(Level.ERROR)
  val spark = SparkSession
    .builder()
    .master("local[*]")
    .config("spark.sql.shuffle.partitions","1")
    .getOrCreate()
}
