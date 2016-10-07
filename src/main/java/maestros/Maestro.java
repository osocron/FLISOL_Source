package maestros;

class Maestro extends Persona {
    private String materia;
    Maestro(String nombre, String apellido, String hobby, String materia) {
        super(nombre, apellido, hobby);
        this.materia = materia;
    }
    public String getMateria() {
        return materia;
    }
}
