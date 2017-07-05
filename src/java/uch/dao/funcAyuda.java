package uch.dao;
public class funcAyuda {
    private static int TamanoPagina = 10;
    public static int ObtenerPaginaSiguiente(int totpag, int pagact) {
        //Total de paginas (totpag)
        //Pagina actual (pagact)
        int aux = pagact + 1;
        if (aux > totpag) {
            aux = totpag;
        }
        if (aux <= 0) {
            aux = 1;
        }
        return aux;
    }
    public static int ObtenerPaginaAnterior(int pagact) {
        //Total de paginas (totpag)
        //Pagina actual (pagact)
        int aux = pagact - 1;
        if (aux <= 0) {
            aux = 1;
        }
        return aux;
    }

    public static int getTamanoPagina() {
        return TamanoPagina;
    }

    public static void setTamanoPagina(int TamanoPagina) {
        funcAyuda.TamanoPagina = TamanoPagina;
    }
}
