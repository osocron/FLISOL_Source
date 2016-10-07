package maestros

/**
  * Created by osocron on 10/6/16.
  */
class SPersona(nombre: String, apellido: String, hobby: String)

case class SMaestro(nombreM: String, apellidoM: String, hobbyM: String, materia: String)
  extends SPersona(nombreM, apellidoM, hobbyM)

case class SEstudiante(nombreE: String, apellidoE: String, hobbyE: String, matricula: String)
  extends SPersona(nombreE, apellidoE, hobbyE)

object SEcuela extends App {

  val maestro: SPersona = SMaestro("Alberto", "Jimenez Cueto", "Tocar guitarra", "Matematicas")
  val estudiante: SPersona = SEstudiante("Laura", "Arriaga Mendez", "Tocar escribir poesia", "S1203387")

  def imprimeMateriaOMatricula(persona: SPersona): Unit = persona match {
    case SMaestro(_,_,_,materia)      => println(materia)
    case SEstudiante(_,_,_,matricula) => println(matricula)
  }

  imprimeMateriaOMatricula(maestro)
  imprimeMateriaOMatricula(estudiante)
}
