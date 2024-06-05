package ABB;

public interface TDAABB {
    int Raiz();
    TDAABB HijoIzq();
    TDAABB HijoDer();
    boolean ArbolVacio();
    void InicializarArbol();
    void AgregarElem(int x);
    void EliminarElem(int x);
}
