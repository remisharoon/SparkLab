package com.remis.spark.basic
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object HashJoinTest {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
                        .builder()
                        .appName("")
                        .master("local[2]")
                        .getOrCreate()
    import spark.implicits._

    val df1 = Seq(
      (1,"one"),
      (2,"two"),
      (3,"three"),
      (4,"four"),
      (5,"five")
    ).toDF("num","name")
      .repartition(col("num"))

    df1.explain()

    val df2 = Seq(
      (1,"wahid"),
      (2,"isnan"),
      (3,"thalatha"),
      (4,"arba"),
      (5,"khamsa")
    ).toDF("num","name")
      .repartition(col("num"))


    val dfJoined = df1.join(df2, df1.col("num") <=> df2.col("num"), "inner")




    dfJoined.explain(true)

    dfJoined.show()

  }

}
