package ABB;

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

    public int altArbol(TDAABB t){

        if(!t.ArbolVacio()){
            alt++;
            //System.out.println(t.Raiz());
            if (t.HijoIzq().ArbolVacio() && t.HijoDer().ArbolVacio()){
                alt--;
            }
            altArbol(t.HijoIzq());
            altArbol(t.HijoDer());

        }



        return alt + 1;
    }

}
