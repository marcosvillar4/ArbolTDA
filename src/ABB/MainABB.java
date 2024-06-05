package ABB;

public class MainABB {
    public TDAABB buscarElementoEnABB(TDAABB t, int x){
        if (t.ArbolVacio()){
            return null;
        } else if (t.Raiz() == x) {
            return t;
        } else if (t.Raiz() > x) {
            return this.buscarElementoEnABB(t.HijoIzq(), x);
        } else {
            return  this.buscarElementoEnABB(t.HijoDer(), x);
        }
    }
}
