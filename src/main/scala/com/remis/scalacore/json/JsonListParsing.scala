package com.remis.scalacore.json

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.json4s.jackson.JsonMethods._
import org.json4s._

object JsonListParsing extends App{
  implicit val formats = DefaultFormats
  object JsonUtil {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    def toJson(value: Map[Symbol, Any]): String = {
      toJson(value map { case (k,v) => k.name -> v})
    }
    def toJson(value: Any): String = {
      mapper.writeValueAsString(value)
    }
    def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)
    def fromJson[T](json: String)(implicit m : Manifest[T]): T = {
      mapper.readValue[T](json)
    }
  }


  val jsonString = "[{\"StartDateTimeEpoch\":123456, \"EndDateTimeEpoch\":45365465000},{\"StartDateTimeEpoch\":123456, \"EndDateTimeEpoch\":45365465111}]"
  case class ExcludeRanges(StartDateTimeEpoch:Long,EndDateTimeEpoch:Long)
  val json = parse(jsonString)
  val examples = json.extract[List[ExcludeRanges]]
  println(examples)

}
