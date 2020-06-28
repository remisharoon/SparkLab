package com.remis.spark.misc

import org.apache.spark.sql.SparkSession

class SparkSessionTest {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().getOrCreate()

    SparkSession.getActiveSession

  }

}
