package heroes;

import java.util.ArrayList;

public abstract class Mutante {
    private int[] secuenciaGenetica;
    /** No podemos declarar poderes en la SuperClase porque aun no sabemos
     *  cuales son los poderes del Mutante.
     * */
    //private ArrayList<Poder> poderes;

    /** Tenemos que dejar el metodo abstracto*/
    public abstract Poder usarPoder(int poder);
}
