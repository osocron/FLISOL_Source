package sumas;

class ListSum {
    private int[] lista;

    ListSum(int[] lista) {
        this.lista = lista;
    }

    public int[] getLista() {
        return lista;
    }

    int suma() {
        int res = 0;
        for (int num : lista) {
            res += num;
        }
        return res;
    }

    int multiplicacion() {
        int res = 1;
        for (int num : lista) {
            res *= num;
        }
        return res;
    }

    int[] sumaAElementos(int s) {
        int[] res = new int[lista.length];
        for (int i = 0; i < lista.length; i++) {
            res[i] = lista[i] + s;
        }
        return res;
    }

    int[] restaAElementos(int s) {
        int[] res = new int[lista.length];
        for (int i = 0; i < lista.length; i++) {
            res[i] = lista[i] - s;
        }
        return res;
    }

}
