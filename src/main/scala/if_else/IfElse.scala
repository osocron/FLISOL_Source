package if_else

/**
  * Created by osocron on 10/12/16.
  */
object IfElse extends App {

  def if_else[A](p: Boolean)(t: => A)(f: => A): A = p match {
    case true => t
    case false => f
  }

  val x = 5
  if_else(x > 3)(2*3)(if_else(x > 0)(x)(-x))

}
