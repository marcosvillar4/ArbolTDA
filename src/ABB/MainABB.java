package ABB;

import java.util.Arrays;

public class MainABB {

    int anchoIz;
    int anchoDe;
    int alt;

    /*

        Clase de funciones extra para arboles:

        TODO: Ver matVal, Metodo para comparacion de estructuras de arboles






     */




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

    public void graficarABBalt(TDAABB t){
        /*

            Metodo para graficar el arbol:
            1) Creamos una matriz para los valores y una para las direcciones
            2) Agregamos como primer valor la raiz, esta va ser nuestra posicion base para movernos
            3) Llamamos a la funcion matVal para cargar los valores a las matrices


        */
        String[][] dataMat = new String[anchoArbol(t)][altArbol(t)];
        String[][] fMat = new String[anchoArbol(t)][altArbol(t)];

        dataMat[anchoDer(t)][0] = String.valueOf(t.Raiz());
        matVal(dataMat, t, anchoDer(t), 0, fMat);

        /*
        for (int i = 0; i < anchoArbol(t); i++) {
            System.out.println(Arrays.toString(dataMat[i]).replace("null", "   "));
        }

        Graficar matriz cruda

        */


        for (int i = 0; i < anchoArbol(t); i++) {       // Preparamos e imprimimos la matriz
            String dataString = Arrays.toString(dataMat[i]).replaceAll("[],]+", "  ").replace("[" ," ");
            System.out.println(dataString.replace("null", "  "));
            String fString = Arrays.toString(fMat[i]).replaceAll("[],]+", "  ").replace("[", " ");
            System.out.println(fString.replace("null", "   "));
        }


    }

    private void matVal(String[][] dataMat, TDAABB t, int x, int y, String[][] fMat){

        /*

            Metodo para cargar los valores a las matrices, tenemos como argumentos las matrices que generamos antes, el arbol
            y las coordenadas de la raiz en la matriz data

            Utiliza metodo de pre-orden para iterar

            EJ

                      17
                    ↗
                 15              [null, null,   17]     [ , ↗, ]
               ↗    ↘            [null,   15, null]     [↗, ↘, ]
            10        12     ==  [  10, null,   12]     [↘,  , ]
               ↘                 [null,    9, null]     [ ,↘ , ]
                 9               [null, null,    8]     [ ,  , ]
                    ↘
                      8

            TODO: Implementar un buen metodo para graficar el arbol, actualmente utilliza un fix medio malo


        */
        if(!t.ArbolVacio()){
            try {
                if(dataMat[x + 1][y + 1] != null) {// Usamos un try para evitar un error al tratar de buscar un hijo izquierdo en una hoja
                    dataMat[x + 1][y + 1] = "↱" + dataMat[x + 1][y + 1] + "|↳" + t.HijoIzq().Raiz(); // Nos desplazamos 1 para abajo y uno para la derecha, almacenamos ahi el valor del hijo izquierdo
                }
                else {
                    dataMat[x + 1][y + 1] = String.valueOf(t.HijoIzq().Raiz()); // Nos desplazamos 1 para abajo y uno para la derecha, almacenamos ahi el valor del hijo izquierdo
                } // Guardamos en la matriz de flechas una flecha hacia abajo, por como se imprime en pantalla no necesita offset vertical
                fMat[x][y] = "  ↘";
            } catch (Exception ignored) {

            }
            try {       // Usamos un try para evitar un error al tratar de buscar un hijo derecho en una hoja
                if (dataMat[x - 1][y + 1] != null) {
                    dataMat[x - 1][y + 1] = dataMat[x - 1][y + 1] + "|" + t.HijoDer().Raiz(); // Nos desplazamos 1 para arriba y uno para la derecha, almacenamos ahi el valor del hijo derecho
                }
                else {
                    dataMat[x - 1][y + 1] = String.valueOf(t.HijoDer().Raiz()); // Nos desplazamos 1 para arriba y uno para la derecha, almacenamos ahi el valor del hijo derecho
                }
                fMat[x - 1][y] = "  ↗"; // Guardamos en la matriz de flechas una flecha hacia arriba, lo tenemos que desplazar a la fila de arriba para poder mostrarlo en la posicion necesaria
            } catch (Exception ignored) {

            }
            matVal(dataMat, t.HijoIzq(), x + 1, y + 1, fMat);   // Llamamos la misma funcion para su hijo izquierdo desplazando la coordenada de raiz 1 a la derecha y uno para abajo
            matVal(dataMat, t.HijoDer(), x - 1, y + 1, fMat);   // Llamamos la misma funcion para su hijo izquierdo desplazando la coordenada de raiz 1 a la derecha y uno para arriba
        }
    }

    public int anchoArbol(TDAABB t){

        return anchoDer(t) + anchoIzq(t) + 1;   // Sumamos el ancho de la derecha e izquierda, se le suma 1 para tener en cuenta la raiz
    }

    public int anchoIzq(TDAABB t){              // Buscamos el ancho desde la raiz hacia la izquierda, sumamos 1 por iteracion de recorrido a la izquierda
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

    public int anchoDer(TDAABB t){              // Buscamos el ancho desde la raiz hacia la derecha, sumamos 1 por iteracion de recorrido a la derecha

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

        if(!t.ArbolVacio()){    // Iteramos pre orden por el arbol por cada iteracion sumamos 1
            alt++;

            if (t.HijoIzq().ArbolVacio() && t.HijoDer().ArbolVacio()){      // Si encontramos una hoja, restamos 1
                alt--;
            }
            altArbolRec(t.HijoIzq());
            altArbolRec(t.HijoDer());

        }



        return alt + 1;     // Sumamos 1 para tener en cuenta la raiz
    }

    public int altArbol(TDAABB t){
        alt = 0;
        alt = altArbolRec(t);     // Manejo de variables para poder correr alt arbol multiples veces
        return alt + 1;
    }

    public boolean MismaForma(TDAABB a, TDAABB b) {
        if (a.ArbolVacio() && b.ArbolVacio()) {
            return true; // Ambos árboles están vacíos
        } else if (a.ArbolVacio() || b.ArbolVacio()) {
            return false; // Uno está vacío y el otro no (DIFERENCIA de estructura)
        } else {
            // Ambos árboles no están vacíos, comprobar hijos izquierdo y derecho
            return MismaForma(a.HijoIzq(), b.HijoIzq()) && MismaForma(a.HijoDer(), b.HijoDer());
            //Con un falso recursivo, se vuelven falsas todas las comparaciones anteriores, resultando en un return false
        }
    }

    public void graficarABB (TDAABB t){
        MostrarABB(t, -1);
    }
    private void MostrarABB(TDAABB a, int nivel) {
        if (!a.ArbolVacio()) {
            MostrarABB(a.HijoDer(), nivel+1);
            for (int i = 0; i < nivel; i++)
                System.out.print("\t");
            System.out.print(a.Raiz());
            System.out.println();
            MostrarABB(a.HijoIzq(), nivel+1);
        }
    }
}
