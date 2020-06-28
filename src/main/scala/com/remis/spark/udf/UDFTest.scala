package com.remis.spark.udf

import com.remis.spark.context.SparkContext
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions.col

object UDFTest extends App with SparkContext{

  spark.udf.register("hasPassed", (grade:String) => grade.equals("A+"))

  val hasPassed = udf((grade:String) => grade.equals("A+"))

  val students = spark.read.option("header",true).option("inferSchema",true).csv("./files/exams/students.csv")

  students.withColumn("Passed", hasPassed(col("grade")))
    .show(10)

}
