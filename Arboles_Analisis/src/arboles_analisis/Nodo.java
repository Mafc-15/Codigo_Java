package arboles_analisis;

public class Nodo {
    // Valor que almacena el nodo
    String valor;
    // Referencias a otros nodos
    Nodo izquierda;
    Nodo derecha;

    // Constructor del nodo
    public Nodo(String valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}
