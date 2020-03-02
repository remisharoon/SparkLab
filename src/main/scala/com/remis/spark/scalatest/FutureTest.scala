package com.remis.spark.scalatest
import java.util.concurrent.Executors

import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object FutureTest {

  def main(args: Array[String]): Unit = {

    val executorService = Executors.newFixedThreadPool(10)
    implicit val executionContext = ExecutionContext.fromExecutorService(executorService)
    val rnd = new scala.util.Random

    var numreportsincurrbatch = 0
    val futuresQ = new mutable.Queue[Future[Int]]
    var i = 1
    while (i < 10){
      if(numreportsincurrbatch < 10) {
        val f = Future { val i2 = i; Thread.sleep(5000 + rnd.nextInt(5001));  println("Finished job " + i2); i2}
        futuresQ.enqueue(f)
        f.onComplete({
          case Success(result) => {numreportsincurrbatch -= 1; println("Success : " + result)}
          case Failure(t) => {println("An error has occurred: " + t.getMessage); numreportsincurrbatch -= 1;}
        })(executionContext)
        numreportsincurrbatch += 1
        i+=1
      }else{
        Thread.sleep(10)
      }
    }

    while(!futuresQ.isEmpty){
      val f = futuresQ.dequeue()
      Await.result(f, Duration.Inf)
    }

//    Await.result(f, Duration.Inf)
//    println("f finished");
//    Await.result(f2, Duration.Inf)
//    println("f2 finished");
//    Await.result(f3, Duration.Inf)
//    println("f3 finished");


    println("shutting down 1")
    executionContext.shutdown()
    println("shutting down 2")
    executorService.shutdown()

    println("FINISH")
  }

}
