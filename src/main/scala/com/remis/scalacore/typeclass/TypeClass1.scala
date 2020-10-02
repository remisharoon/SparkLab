package com.remis.scalacore.typeclass

object TypeClass1 extends App{

  trait HtmlWritable[T]{
    def toHtml(t:T):String
  }

  case class User(name:String, id:Int, isManager:Boolean)

  object UserHtmlWritable extends HtmlWritable[User]{
    override def toHtml(
      t: User
    ): String = t.name + t.id
  }

  val remis = User("remis", 33, true)

  println(UserHtmlWritable.toHtml(remis))

}
