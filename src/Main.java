import ABB.ABB;

import ABB.MainABB;

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();
        MainABB funcarb = new MainABB();
        arbol.InicializarArbol();
        arbol.AgregarElem(10);
        arbol.AgregarElem(9);
        arbol.AgregarElem(8);
        //System.out.println(funcarb.anchoIzq(arbol));
        arbol.AgregarElem(7);
        //arbol.AgregarElem(8);
        arbol.AgregarElem(10);

        arbol.AgregarElem(9);
        arbol.AgregarElem(11);
        //System.out.println(funcarb.anchoIzq(arbol));
        //System.out.println(funcarb.anchoDer(arbol));}
        System.out.println("Ancho total: " + funcarb.anchoArbol(arbol) + " Ancho Rama izq: " + funcarb.anchoIzq(arbol) + " Ancho rama der: " + funcarb.anchoDer(arbol));
        System.out.println(funcarb.altArbol(arbol));
        //System.out.println(funcarb.altArbol(arbol));

        funcarb.graficarABB(arbol);
    }
}