package com.remis.scalacore.monocle

object Lenses extends App {

  case class Guitar(make:String, model:String)
  case class Guitarist(name:String, favouriteGuitar:Guitar)
  case class RockBand(name:String, yearFormed:Int, leadGuitarist:Guitarist)

  val metallica = RockBand("Metallica", 1981, Guitarist("Kirk Hammet", Guitar("ESP", "M II")))



  //changing a nested field value using monocle

  val kirksGuitar = Guitar("ESP", "M II")

  import monocle.Lens
  import monocle.macros.GenLens

  val guitarModelLens:Lens[Guitar, String] = GenLens[Guitar](_.model)

  //inspect a model
  val kirksGuitarModel = guitarModelLens.get(kirksGuitar)
  println(kirksGuitarModel)

  //modilfy a field
  val formattedGuitar = guitarModelLens.modify(_.replace(" ", "-"))(kirksGuitar)

  val leadGuitaristLens:Lens[RockBand, Guitarist] = GenLens[RockBand](_.leadGuitarist)
  val favGuitarLens:Lens[Guitarist,Guitar] = GenLens[Guitarist](_.favouriteGuitar)

  val composedLens:Lens[RockBand,String] = leadGuitaristLens.composeLens(favGuitarLens).composeLens(guitarModelLens)

  val kirksGuitarModel2 = composedLens.get(metallica)

  val metallicaFixed = composedLens.modify(_.replace(" ", "-"))(metallica)

  




}
