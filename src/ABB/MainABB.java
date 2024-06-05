package ABB;

import java.util.Arrays;

public class MainABB {

    int ancho;
    int anchoIz;
    int anchoDe;
    int alt;

    public TDAABB buscarElementoEnABB(TDAABB t, int x){
        if (t.ArbolVacio()){
            return null;
        } else if (t.Raiz() == x) {
            return t;
        } else if (t.Raiz() > x) {
            return this.buscarElementoEnABB(t.HijoIzq(), x);
        } else {
            return this.buscarElementoEnABB(t.HijoDer(), x);
        }
    }

    public void graficarABB(TDAABB t){
        System.out.println(anchoArbol(t));
        System.out.println(altArbol(t));
        String[][] grafMat = new String[anchoArbol(t)][altArbol(t)];


        grafMat[anchoDer(t)][0] = String.valueOf(t.Raiz());
        //System.out.println(Arrays.deepToString(grafMat));
        matVal(grafMat, t, anchoDer(t), 0);
        for (int i = 0; i < altArbol(t) + 1; i++) {
            for (int j = 0; j < anchoArbol(t) - 1; j++) {
                if (grafMat[i][j] == null){
                    grafMat[i][j] = "  ";
                }
            }
            System.out.println(Arrays.toString(grafMat[i]));
        }


    }

    private void matVal(String[][] grafMat, TDAABB t, int x, int y){
        if(!t.ArbolVacio()){
            try {
                grafMat[x + 1][y + 1] = String.valueOf(t.HijoIzq().Raiz());
                grafMat[x + 1][y] = " \u2198";
            } catch (Exception ignored) {

            }
            try {
                grafMat[x - 1][y + 1] = String.valueOf(t.HijoDer().Raiz());
                grafMat[x - 1][y] = " \u2197";
            } catch (Exception ignored) {

            }
            matVal(grafMat, t.HijoIzq(), x + 1, y + 1);
            matVal(grafMat, t.HijoDer(), x - 1, y + 1);
        }
    }

    public int anchoArbol(TDAABB t){

        return anchoDer(t) + anchoIzq(t) + 1;
    }

    public int anchoIzq(TDAABB t){
        if (t.ArbolVacio()){
            int temp = anchoIz - 1;
            anchoIz = 0;
            return temp;
        }
        else {
            anchoIz++;
            return anchoIzq(t.HijoIzq());
        }

    }

    public int anchoDer(TDAABB t){

        if (t.ArbolVacio()){
            int temp = anchoDe - 1;
            anchoDe = 0;
            return temp;
        }
        else {
            anchoDe++;
            return anchoDer(t.HijoDer());
        }

    }

    private int altArbolRec(TDAABB t){

        if(!t.ArbolVacio()){
            alt++;
            //System.out.println(t.Raiz());
            if (t.HijoIzq().ArbolVacio() && t.HijoDer().ArbolVacio()){
                alt--;
            }
            altArbolRec(t.HijoIzq());
            altArbolRec(t.HijoDer());

        }



        return alt + 1;
    }

    public int altArbol(TDAABB t){
        alt = 0;
        altArbolRec(t);
        return alt + 1;
    }

}
