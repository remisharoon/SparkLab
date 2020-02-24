package com.remis.spark.scalatest
import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext

object FutureTest {

  def main(args: Array[String]): Unit = {

    val executorService = Executors.newFixedThreadPool(10)
    val executionContext = ExecutionContext.fromExecutorService(executorService)

  }

}
