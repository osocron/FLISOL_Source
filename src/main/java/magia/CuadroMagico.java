package magia;

import java.util.Random;

public class CuadroMagico {

    private static int ancho = 3;
    private static int largo = 3;
    private static int top = (ancho * largo) + 1;
    private static int iteraciones = 0;
    private static int[][] matriz = new int[ancho][largo];

    public static void main(String[] args) {
        calcularCuadro();
        while (!verificarCuadroMagico(matriz)){
            calcularCuadro();
            iteraciones++;
        }
        System.out.print("Cuadro magico encontrado despues de "+iteraciones+" iteraciones\n\n");
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //Genera una matriz con números aleatorios
    private static void calcularCuadro(){

        boolean[] usado = new boolean[top];
        //Llenar usado con valores false
        for (int x = 0; x < (top - 1); x++) {
            usado[x] = false;
        }

        //Se genera la matriz con numeros aleatorios
        Random randomClass = new Random();
        for(int i = 0; i < ancho; i++ ){
            for (int j = 0; j < largo; j++){
                //La bandera done nos ayuda a saber que podemos salir de la funcion
                boolean done = false;
                while (!done) {
                    int random = randomClass.nextInt(top - 1) + 1;
                    //Se usa el vector usado para saber si el numero no ha sido usado
                    if (random != 0 && !usado[random]) {
                        matriz[i][j] = random;
                        done = true;
                        usado[random] = true;
                    }
                }
            }
        }
    }

    //Verifica que la matriz sea un cuadro mágico cuando la suma de las aristas verticales más las horizontales más las
    //diagonales den el mismo resultado
    private static boolean verificarCuadroMagico(int[][] matriz){
        boolean esMagico = false;
        int[] vertical = new int[largo];
        int[] horizontal = new int[ancho];
        int[] diagonal = new int[2];
        //Sumar las columnas y poner los resultados en vertical
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < largo; j++) {
                vertical[i] += matriz[i][j];
            }
        }
        //Sumar las filas y guardar el resultado en horizontal
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < ancho; j++) {
                horizontal[i] += matriz[j][i];
            }
        }
        //Sumar las diagonales y poner el resultado en diagonal
        for (int i = 0; i < largo; i++) {
            diagonal[0] += matriz[i][i];
        }
        int j = 0;
        for (int i = ancho - 1; i >= 0; i--) {
            diagonal[1] += matriz[j][i];
            j++;
        }
        //Si las sumas verticales no son iguales salir de la funcion
        int verticalAnterior = vertical[0];
        for (int i = 1; i < largo; i++) {
            if (vertical[i] != verticalAnterior){
                return false;
            }
            verticalAnterior = vertical[i];
        }
        //Si las sumas horizontales no son iguales salir de la funcion
        int horizontalAnterior = horizontal[0];
        for (int i = 0; i < ancho; i++) {
            if (horizontal[i] != horizontalAnterior){
                return false;
            }
        }
        //Comparar las diagonales con alguna vertical como ultimo paso
        if ((diagonal[0] == diagonal[1]) && (diagonal[0] == vertical[0])){
            esMagico = true;
        }
        return esMagico;
    }

}
