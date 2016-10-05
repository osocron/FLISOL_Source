package heroes;

public class Poder {

    private String nombre;
    private String efecto;
    private String tipo;

    public Poder(String nombre, String efecto, String tipo) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
