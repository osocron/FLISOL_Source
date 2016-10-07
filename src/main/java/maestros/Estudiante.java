package maestros;

class Estudiante extends Persona {
    private String matricula;
    Estudiante(String nombre, String apellido, String hobby, String matricula) {
        super(nombre, apellido, hobby);
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
}
