package com.remis.spark.pivot
import org.apache.spark.sql.SparkSession

object PivotTest extends App{

  val spark = SparkSession.builder().master("local[*]").appName("PivotTest").getOrCreate()

  val data = spark.read.option("header",true).option("inferSchema",true).csv("files/biglog.txt")
  data.show()


}
