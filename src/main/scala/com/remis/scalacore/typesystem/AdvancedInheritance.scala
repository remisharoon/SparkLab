package com.remis.scalacore.typesystem

object AdvancedInheritance extends App{

  println("Helloooo")

  trait Writer[T]{
    def write(value:T):Unit
  }

  trait Closeable{
    def close(status:Int):Unit
  }

  trait GenericStream[T]{
    def foreach(f:T => Unit):Unit
  }

  def processStream[T](stream: GenericStream[T] with Writer[T] with Closeable): Unit ={
    stream.foreach(println)
    stream.close(0)
  }


  //diamond problem

  trait Animal {def name:String}
  trait Lion extends Animal { override def name: String = "Lion"}
  trait Tiger extends Animal { override def name: String = "Tiger"}

  object Mutant extends Tiger with Lion

  println(Mutant.name)

  //Last one gets picked


  //SUPER problem

  trait Cold{
    def print:Unit = println("Cold")
  }

  trait Green extends Cold{
    override def print: Unit = {
      println("Green")
      super.print
    }

  }

  trait Blue extends Cold{
    override def print: Unit = {
      println("BLue")
      super.print
    }
  }

  class Red {
    def print=println("Red")
  }

  class White extends Red with Green with Blue{
    override def print: Unit = {
      println("White")
      super.print
    }
  }

  val white = new White()
  white.print

}
