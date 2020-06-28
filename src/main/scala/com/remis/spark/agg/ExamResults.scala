package com.remis.spark.agg

import com.remis.spark.context.SparkContext

object ExamResults extends App  with SparkContext{

  val students = spark.read.option("header",true).option("inferSchema",true).csv("./files/exams/students.csv")

//  students.show(5)
  /**
    * +----------+--------------+----------+----+-------+-----+-----+
    * |student_id|exam_center_id|   subject|year|quarter|score|grade|
    * +----------+--------------+----------+----+-------+-----+-----+
    * |         1|             1|      Math|2005|      1|   41|    D|
    * |         1|             1|   Spanish|2005|      1|   51|    C|
    * |         1|             1|    German|2005|      1|   39|    D|
    * |         1|             1|   Physics|2005|      1|   35|    D|
    * |         1|             1|   Biology|2005|      1|   53|    C|
    * |         1|             1|Philosophy|2005|      1|   73|    B|
    */

  /**
    * Task : Find Highest Score in each subject
    */
  val highestScores = students.groupBy("subject").max("score")
  highestScores.show(10)
  Thread.sleep(Integer.MAX_VALUE)
}
