package com.remis.spark.scalatest

object ObjectTestClient {

  def main(args: Array[String]): Unit = {

    val obj = ObjectTest

    obj.field1 = "FFFFFFFF"

    println(obj.field1)
    obj.testPrint()

    val obj2 = ObjectTest

    println(obj2.field1)
    obj2.testPrint()

  }

}
