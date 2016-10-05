package heroes;

import java.time.LocalDate;
import java.util.ArrayList;

public class MundoMarvel {
    public static void main(String[] args) {
        SuperHeroe spiderMan = new SuperHeroe("Spider Man",
                "Peter Parker", LocalDate.now(),
                new ArrayList<>(),
                new ArrayList<>());
        Villano doctorOctopus = new Villano("Doctor Octopus",
                "Otto Octavio", LocalDate.now(),
                new ArrayList<>(),
                new ArrayList<>());
        spiderMan.mandarMensajeTelepaticamente("Hola Octavio", doctorOctopus);
        ArrayList<String> mensajes = doctorOctopus.getMensajes();
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }
}
