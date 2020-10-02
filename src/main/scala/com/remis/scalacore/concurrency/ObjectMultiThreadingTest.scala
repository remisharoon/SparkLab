package com.remis.scalacore.concurrency
import scala.util.Random

object ObjectMultiThreadingTest {

  def main(args: Array[String]): Unit = {

    for (x <- 1 to 5) {
      var thread = new MyThread()
      thread.setName("Thread number :" + x.toString)
      thread.start()
    }
  }

  class MyThread extends Thread {
    override def run(): Unit = {
      Singleton.myname = this.getName
      Singleton.call(this.getName)
    }
  }

  object Singleton {
    var myname = "Singleton"
    def call(threadName: String): Unit = {
      val thName = threadName
      val random = new Random
      for (i <- 1 to 5) {
        println("My Name is set by " + myname)
        val sleeptime = random.nextInt(1000)
        println(
          "But, I am now running " + thName + ", sleeping for " + sleeptime
        )
        Thread.sleep(sleeptime)
      }
    }

  }
}
