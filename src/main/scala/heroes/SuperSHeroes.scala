package heroes

import java.time.LocalDate

import scalaz.State

case class SuperSHeroes(nombreHeroico: String,
                        nombreReal: String,
                        fechaNacimiento: LocalDate,
                        poderes: List[SPower],
                        messages: List[String]) extends SMutant with Alien

case class SVillano(nombreVillano: String,
                    nombreReal: String,
                    fechaNacimiento: LocalDate,
                    poderes: List[SPower],
                    messages: List[String]) extends SMutant with Alien

case class SNeutral(nombreReal: String,
                    fechaNacimiento: LocalDate,
                    poderes: List[SPower],
                    messages: List[String]) extends SMutant with Alien

case class SPower(nombre: String, efecto: String, tipo: String)

trait SMutant {
  val nombreReal: String
  val fechaNacimiento: LocalDate
  val poderes: List[SPower]
  def usarPoder(poder: Int): SPower = poderes(poder)
}

trait Alien {

  val messages: List[String]

  def sendMessage(message: String, alien: Alien): State[Alien, String] =
    alien.recieveMessage(message)

  def recieveMessage(message: String): State[Alien, String] = State {
    case st@SuperSHeroes(_, _, _, _, _) => (st.copy(messages = messages :+ message), message)
    case st@SVillano(_, _, _, _, _)     => (st.copy(messages = messages :+ message), message)
    case st@SNeutral(_, _, _, _)        => (st.copy(messages = messages :+ message), message)
  }

  def haveConversation(a1: Alien, a2: Alien, conversacion: List[(String, String)]): (Alien, Alien) =
    conversacion match {
      case Nil => (a1, a2)
      case (m1, m2) :: t =>
        val (a2_n, _) = a1.sendMessage(m1, a2).run(a2)
        val (a1_n, _) = a2_n.sendMessage(m2, a1).run(a1)
        haveConversation(a1_n, a2_n, t)
    }

}

object MundoDC extends App {

  val superMan = SuperSHeroes("Super Man",
    "Clark Kent",
    LocalDate.now(),
    List(SPower("Rayos X", "Quema a la gente", "Vista"),
         SPower("Super Fuerza", "Golpea a la gente", "Fuerza")), List())

  val killerCroc = SVillano("Killer Croc",
    "Nancy",
    LocalDate.now(),
    List(SPower("Super Fuerza", "Golpea a la gente", "Fuerza")), List())

  val conversacion = List(
    ("Croc!!!","Superfool..."),
    ("Hell you doing here","I'm about to kill you!"),
    ("Yeah right.. surrender!","Never fool!"),
    ("Alright.. you asked for it!","Noooooooooo"))

  val (sup, kC) = superMan.haveConversation(superMan, killerCroc, conversacion)

}