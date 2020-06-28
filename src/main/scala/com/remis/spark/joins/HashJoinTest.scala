package com.remis.spark.joins
import com.remis.spark.context.SparkContext
import org.apache.spark.sql.functions._

object HashJoinTest extends App with SparkContext{

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
    Thread.sleep(Integer.MAX_VALUE)

}
