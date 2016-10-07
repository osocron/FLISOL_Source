package sumas

/**
  * Created by osocron on 10/5/16.
  */
object SumasScala extends App {
  val lista = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(lista.foldLeft(0)(_ + _))
  println(lista.foldLeft(1)(_ * _))
  println(lista.map(_ + 5))
  println(lista.map(_ - 5))
}
