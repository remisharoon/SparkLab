package com.remis.spark.performance

import com.remis.spark.context.SparkContext
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DataType, IntegerType}

object PerfTest1 extends App with SparkContext{

  val dataset = spark.read.option("header",true).csv("./files/biglog.txt")

  val groupedDataset = dataset.select(col("level"),
    date_format(col("datetime"),"MMM").as("month") ,
    date_format(col("datetime"),"M").as("month_num").cast(IntegerType)
  ).groupBy("level","month","month_num").count().as("total")
    .orderBy("month_num")
    .drop("month_num")

  groupedDataset.show()

  Thread.sleep(Integer.MAX_VALUE)

}
