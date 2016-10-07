package maestros;

class Persona {

    private String nombre;
    private String apellido;
    private String hobby;

    Persona(String nombre, String apellido, String hobby) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.hobby = hobby;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
