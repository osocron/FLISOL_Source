package heroes;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class SuperHeroe extends Mutante implements Extraterrestable {

    private String nombreHeroico;
    private String nombreReal;
    private LocalDate fechaNacimiento;
    private ArrayList<Poder> poderes;
    private ArrayList<String> mensajes;

    public SuperHeroe(String nombreHeroico,
                      String nombreReal,
                      LocalDate fechaNacimiento,
                      ArrayList<Poder> poderes, ArrayList<String> mensajes) {
        this.nombreHeroico = nombreHeroico;
        this.nombreReal = nombreReal;
        this.fechaNacimiento = fechaNacimiento;
        this.poderes = poderes;
        this.mensajes = mensajes;
    }

    public String getNombreHeroico() {
        return nombreHeroico;
    }

    public void setNombreHeroico(String nombreHeroico) {
        this.nombreHeroico = nombreHeroico;
    }

    public String getNombreReal() { return nombreReal; }

    public void setNombreReal(String nombreReal) { this.nombreReal = nombreReal; }

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
        return poderes.get(poder);
    }

    @Override
    public void mandarMensajeTelepaticamente(String mensaje, Extraterrestable extraterrestable) {
        extraterrestable.recibirMensaje(mensaje);
    }

    @Override
    public void recibirMensaje(String mensaje) { mensajes.add(mensaje); }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }
}
