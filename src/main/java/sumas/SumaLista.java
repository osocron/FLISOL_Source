package sumas;

public class SumaLista {
    public static void main(String[] args) {

        ListSum lista = new ListSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        System.out.println(lista.suma());
        System.out.println(lista.multiplicacion());

        int[] listaSumada = lista.sumaAElementos(5);
        for (int num : listaSumada) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        int[] listaRestada = lista.restaAElementos(5);
        for (int num: listaRestada) {
            System.out.print(num + " ");
        }
    }
}
