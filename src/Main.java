import ABB.ABB;

import ABB.MainABB;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------- TEST 1 -------------");

        test1();

        System.out.println("---------- TEST 2 -------------");
        test2();
    }

    static void test1(){
        ABB arbol = new ABB();
        MainABB funcarb = new MainABB();
        arbol.InicializarArbol();
        arbol.AgregarElem(13);
        arbol.AgregarElem(9);
        arbol.AgregarElem(8);
        //System.out.println(funcarb.anchoIzq(arbol));
        arbol.AgregarElem(7);
        //arbol.AgregarElem(8);
        arbol.AgregarElem(10);

        arbol.AgregarElem(9);
        arbol.AgregarElem(11);
        arbol.AgregarElem(15);
        arbol.AgregarElem(13);
        arbol.AgregarElem(16);
        arbol.AgregarElem(14);
        funcarb.buscarElementoEnABB(arbol, 10);
        //System.out.println(funcarb.anchoIzq(arbol));
        //System.out.println(funcarb.anchoDer(arbol));}
        System.out.println("Ancho total: " + funcarb.anchoArbol(arbol) + " Ancho Rama izq: " + funcarb.anchoIzq(arbol) + " Ancho rama der: " + funcarb.anchoDer(arbol));
        System.out.println(funcarb.altArbol(arbol));
        //System.out.println(funcarb.altArbol(arbol));

        funcarb.graficarABB(arbol);
    }

    static void test2(){
        ABB arbol2 = new ABB();
        MainABB funcarb = new MainABB();
        arbol2.InicializarArbol();
        arbol2.AgregarElem(50);
        arbol2.AgregarElem(100);
        arbol2.AgregarElem(15);
        arbol2.AgregarElem(25);
        arbol2.AgregarElem(75);
        arbol2.AgregarElem(20);
        arbol2.AgregarElem(5);
        arbol2.AgregarElem(10);
        arbol2.AgregarElem(150);
        arbol2.AgregarElem(120);
        arbol2.AgregarElem(80);
        arbol2.AgregarElem(110);

        System.out.println(funcarb.MismaForma(arbol2, arbol2));

        funcarb.graficarABB(arbol2);
    }
}