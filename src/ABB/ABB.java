package ABB;

public class ABB implements TDAABB {
    NodoABB raiz;

    public int Raiz() {
        return raiz.dato;
    }

    public TDAABB HijoIzq() {
        return raiz.hijoIzq;
    }

    public TDAABB HijoDer() {
        return raiz.hijoDer;
    }

    public boolean ArbolVacio() {
        return raiz == null;
    }

    public void InicializarArbol() {
        raiz = null;
    }

    public void AgregarElem(int x) {
        if (raiz == null){
            raiz = new NodoABB();
            raiz.dato = x;
            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer = new ABB();
            raiz.hijoDer.InicializarArbol();
        } else if (raiz.dato > x) {
            raiz.hijoIzq.AgregarElem(x);
        } else if (raiz.dato < x) {
            raiz.hijoDer.AgregarElem(x);
        } else if (raiz.dato == x) {
            raiz.hijoIzq.AgregarElem(x);
        }

    }

    public void EliminarElem(int x) {
        if (raiz != null){
            if (raiz.dato == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()){
                raiz = null;
            } else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()){
                raiz.dato = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.EliminarElem(raiz.dato);
            } else if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()){
                raiz.dato = this.menor(raiz.hijoDer);
                raiz.hijoDer.EliminarElem(raiz.dato);
            } else if (raiz.dato < x) {
                raiz.hijoDer.EliminarElem(x);
            } else {
                raiz.hijoIzq.EliminarElem(x);
            }
        }
    }

    private int mayor(TDAABB a){
        if (a.HijoDer().ArbolVacio()){
            return a.Raiz();
        }
        else {
            return mayor(a.HijoDer());
        }
    }

    private int menor(TDAABB a){
        if (a.HijoIzq().ArbolVacio()){
            return a.Raiz();
        }
        else {
            return menor(a.HijoIzq());
        }
    }
}
