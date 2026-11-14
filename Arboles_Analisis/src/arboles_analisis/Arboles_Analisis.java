package arboles_analisis;
import java.util.Scanner;

public class Arboles_Analisis {
    public static void main(String[] args) {
        Nodo ejemplo1 = new Nodo("5");
        Nodo ejemplo2 = new Nodo("3");
        Nodo ejemplo3 = new Nodo("2");
        // Se crea el nodo para la suma dentro del paréntesis
        Nodo suma = new Nodo("+");
        suma.izquierda = ejemplo1;
        suma.derecha = ejemplo2;
        // Se crea la raíz para la multiplicación
        Nodo raizEjemplo = new Nodo("*");
        raizEjemplo.izquierda = suma;
        raizEjemplo.derecha = ejemplo3;
        // Se muestra la expresión y su resultado
        System.out.println("(5 + 3) * 2");
        System.out.println("RESULTADO: " + evaluar(raizEjemplo));

        // SEGUNDO EJEMPLO: Operaciones ingresadas por el usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el primer numero: ");
        double num1 = sc.nextDouble();
        System.out.print("Ingresa el segundo numero: ");
        double num2 = sc.nextDouble();
        System.out.print("Ingresa el tercer numero: ");
        double num3 = sc.nextDouble();

        System.out.println("\nOPERACION DENTRO DEL PARENTESIS");    //Para que puedas escoger que operacion quieres hacer dentro de los parentesis
        System.out.println("1. Suma (+)");
        System.out.println("2. Resta (-)");
        System.out.println("3. Multiplicacion (*)");
        System.out.println("4. Division (/)");
        System.out.print("Elige una opcion: ");
        int op1 = sc.nextInt();
        String operacion1 = operador(op1);

        System.out.println("\nOPERACION FUERA DEL PARENTESIS");    //Operación fuera de los parentesis 
        System.out.println("1. Suma (+)");
        System.out.println("2. Resta (-)");
        System.out.println("3. Multiplicacion (*)");
        System.out.println("4. Division (/)");
        System.out.print("Elige una opcion: ");
        int op2 = sc.nextInt();
        String operacion2 = operador(op2);
        // Se crean los nodos que guardaran los numeros
        // Hojas del arbol
        Nodo n1 = new Nodo("" + num1);
        Nodo n2 = new Nodo("" + num2);
        Nodo n3 = new Nodo("" + num3);

        Nodo interno = new Nodo(operacion1);
        // Se crea este nodo para que guarde la operación dentro del parentesis
        interno.izquierda = n1;
        interno.derecha = n2;

        Nodo raiz = new Nodo(operacion2);
        // Se crea la raiz, que es el nodo principal del arbol
        raiz.izquierda = interno;
        // Es para que se conecten la op interna a la izq
        // y el último número se vaya a la derecha
        raiz.derecha = n3;

        System.out.println("\nEXPRESION ALGEBRAICA");
        System.out.println("(" + num1 + " " + operacion1 + " " + num2 + ") " + operacion2 + " " + num3);
        System.out.println("\nARBOL: ");
        mostrarArbol(raiz);
        System.out.println("\nRESULTADO: " + evaluar(raiz));
    }
    public static String operador(int opcion) {
        // Convierte la opción en el signo correspondiente
        switch (opcion) {
            case 1: return "+";
            case 2: return "-";
            case 3: return "*";
            case 4: return "/";
            default: throw new IllegalArgumentException("Opcion incorrecta");
            // Por si el usuario mete una opción que no existe
        }
    }

    public static double evaluar(Nodo nodo) {
        // Metodo que sirve para que recorra el arbol y va a realizar la operación para mostrar el resultado

        if (nodo.izquierda == null && nodo.derecha == null) {
            // Comprueba si el nodo es hoja
            return Double.parseDouble(nodo.valor);
            // Convierte el valor que se guardo en el nodo a numero para poder realizar operaciones
        }

        double izquierda = evaluar(nodo.izquierda);
        // Se obtienen el resultado de los nodos izquierdo y derecho mediante recursividad
        double derecha = evaluar(nodo.derecha);

        switch (nodo.valor) {
            // Es para que dependiendo del signo guardado en el nodo, se realice la op correspondiente

            case "+":
                return izquierda + derecha;

            case "-":
                return izquierda - derecha;

            case "*":
                return izquierda * derecha;

            case "/":
                if (derecha == 0) {
                    // Comprueba que el divisor no sea 0
                    throw new ArithmeticException("No se puede dividir entre cero");
                }
                return izquierda / derecha;
        }
        return 0;
    }

    public static void mostrarArbol(Nodo raiz) {
        System.out.println("       " + raiz.valor);
        System.out.println("      /   \\");
        System.out.println("     " + raiz.izquierda.valor
                + "     " + raiz.derecha.valor);
        System.out.println("    / \\");
        System.out.println("   " + raiz.izquierda.izquierda.valor
                + "   " + raiz.izquierda.derecha.valor);
    }
}
