package com.remis.scalacore

object MatchTest {

  def main(args: Array[String]): Unit = {

    5 match {

      case 5 => println("5")
      case 1 => println("1")
      case none => println("none")
        println("default")
    }

  }
}
