package maestros;

public class Escuela {

    public static void main(String[] args) {
        Persona persona1 = new Maestro("Alberto", "Jimenez Cueto", "Tocar guitarra", "Matematicas");
        Persona persona2 = new Estudiante("Laura", "Arriaga Mendez", "Tocar escribir poesia", "S1203387");
        imprimeMateriaOMatricula(persona1);
        imprimeMateriaOMatricula(persona2);
    }

    private static void imprimeMateriaOMatricula(Persona persona) {
        if (persona instanceof Maestro) {
            System.out.println(((Maestro) persona).getMateria());
        }
        else {
            System.out.println(((Estudiante) persona).getMatricula());
        }
    }
}
