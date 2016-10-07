package magiarec

import scala.util.Random
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
  * Created by osocron on 10/7/16.
  */
object SCuadroMagico extends App {

  def generarCuadroMagico: List[List[Int]] =
    Random.shuffle((1 until 10).toList).grouped(3).toList

  def sumaVertical(xs: List[List[Int]]): List[Int] = xs.transpose.map(_.sum)

  def sumaHorizontal(xs: List[List[Int]]): List[Int] = xs.map(_.sum)

  def sumaDiagonal(xs: List[List[Int]]): List[Int] = {
    val reversed = xs.map(_.reverse)
    List((for {i <- xs.indices} yield xs(i)(i)).sum,
         (for {j <- xs.indices} yield reversed(j)(j)).sum)
  }

  def esMagico(xs: List[List[Int]]): Boolean =
    (sumaVertical(xs) ++ sumaHorizontal(xs) ++ sumaDiagonal(xs)).distinct.size == 1

  def encontrarCuadro(count: Int): (List[List[Int]], Int) = {
    val cuadro = generarCuadroMagico
    if (esMagico(cuadro)) (cuadro, count)
    else encontrarCuadro(count + 1)
  }

  val c1 =  Future(encontrarCuadro(1))
  val c2 =  Future(encontrarCuadro(1))
  val c3 =  Future(encontrarCuadro(1))
  val c4 =  Future(encontrarCuadro(1))
  val c5 =  Future(encontrarCuadro(1))
  val c6 =  Future(encontrarCuadro(1))
  val c7 =  Future(encontrarCuadro(1))
  val c8 =  Future(encontrarCuadro(1))
  val c9 =  Future(encontrarCuadro(1))
  val c10 = Future(encontrarCuadro(1))

  val first = Future.firstCompletedOf(Seq(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10))

  Await.result(first, Duration.Inf) match {
    case (cuadro, contador) =>
      cuadro.foreach(fila => println(s"${fila.mkString(" ")}"))
      println(s"Cuadro encontrado de $contador iteraciones")
  }

}
