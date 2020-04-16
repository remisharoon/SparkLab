package com.remis.spark.scalatest
import org.apache.spark.sql.{Encoder, Encoders}

object GenericsTest {
  case class P1(c1: Int, c2: String)
  case class P2(c3: Boolean, c4: Double)

  def processCaseClass[T](p: T): T = {
    println(p)
    return p
  }

  def processCaseClass2[T](e: Encoder[T]){
    println(e)
  }


  def main(args: Array[String]): Unit = {



    val p1 = P1(1, "Boy")
    val p2 = P2(true, 1.1)

    val p1procd = processCaseClass(p1)
    val p2procd = processCaseClass(p2)

    val e1 = Encoders.product[P1]
    val e2 = Encoders.product[P2]

    val e1procd = processCaseClass2(e1)
    val e2procd = processCaseClass2(e2)




  }

}
