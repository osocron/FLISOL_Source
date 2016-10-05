package heroes;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class Neutrales extends Mutante implements Extraterrestable {

    private String nombreReal;
    private LocalDate fechaNacimiento;
    private ArrayList<Poder> poderes;
    private ArrayList<String> mensajes;

    public Neutrales(String nombreReal,
                     LocalDate fechaNacimiento,
                     ArrayList<Poder> poderes,
                     ArrayList<String> mensajes) {
        this.nombreReal = nombreReal;
        this.fechaNacimiento = fechaNacimiento;
        this.poderes = poderes;
        this.mensajes = mensajes;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Poder> getPoderes() {
        return poderes;
    }

    public void addPoder(Poder poder) {
        poderes.add(poder);
    }

    @Override
    public Poder usarPoder(int poder) {
        return null;
    }

    @Override
    public void mandarMensajeTelepaticamente(String mensaje, Extraterrestable extraterrestable) {
        extraterrestable.recibirMensaje(mensaje);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }
}
