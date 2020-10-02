package com.remis.scalacore

object ObjectTest {
  //def apply(): ObjectTest = new ObjectTest()

  var field1 = "OBJ Field1"
  var field2 = 2

  def testPrint(): Unit = {
    println(field1 + field2)
  }
}
