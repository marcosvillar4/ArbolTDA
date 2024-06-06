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
        String[][] dataMat = new String[anchoArbol(t)][altArbol(t)]; 
        String[][] fMat = new String[anchoArbol(t)][altArbol(t)]; 


        dataMat[anchoDer(t)][0] = String.valueOf(t.Raiz());
        //System.out.println(Arrays.deepToString(dataMat));
        matVal(dataMat, t, anchoDer(t), 0, fMat);
        for (int i = 0; i < altArbol(t) + 1; i++) {
            for (int j = 0; j < anchoArbol(t) - 1; j++) {
                if (dataMat[i][j] == null){
                    dataMat[i][j] = "  ";
                }if (fMat[i][j] == null){
                    fMat[i][j] = "  ";
                }

            }

            System.out.println(Arrays.toString(dataMat[i]).replaceAll("[],]+", " ").replace("[" ," "));
            System.out.println(Arrays.toString(fMat[i]).replaceAll("[],]+", " ").replace("[", " "));
        }


    }

    private void matVal(String[][] dataMat, TDAABB t, int x, int y, String[][] fMat){
        if(!t.ArbolVacio()){
            try {
                dataMat[x + 1][y + 1] = String.valueOf(t.HijoIzq().Raiz());
                fMat[x][y] = "  \u2198";
            } catch (Exception ignored) {

            }
            try {
                dataMat[x - 1][y + 1] = String.valueOf(t.HijoDer().Raiz());
                fMat[x - 1][y] = "  \u2197";
            } catch (Exception ignored) {

            }
            matVal(dataMat, t.HijoIzq(), x + 1, y + 1, fMat);
            matVal(dataMat, t.HijoDer(), x - 1, y + 1, fMat);
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
