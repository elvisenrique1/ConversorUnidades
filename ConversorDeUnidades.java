package conversordeunidades;

// *** Programa que realiza Conversión de Unidades de Almacenamiento Informático ***
// *** (Bits - Byte - Kilobytes - Megabytes - Gigabytes - Terabytes) ***

import java.util.Scanner;

/**
 *
 * @author Elvis Enrique Guaiquire
 */

public class ConversorDeUnidades {    
    
    public static void main(String[] args) {        
        
        solucionProgramaConversorDeUnidades();
        
    } // *** Cierre del main ***
    
    
    // *** Este procedimiento contiene la clase Scanner, declaracion de variables y llamado de las Funciones y                              Prodecimientos en forma ordenada de la funcion Ppal. en el main. ***
    public static void solucionProgramaConversorDeUnidades(){        
        Scanner teclado = new Scanner(System.in);        
        imprimirEncabezadoDelPrograma();        
        double valor = solicitarValorAConvertir(teclado);
        // *** Vector clase String que representa las cadenas de carácteres de las Unidades de Almacenamiento Informático a imprimir por pantalla ***
        final String[] UNIDADES_DE_ALMACENAMIENTO = {"Bits", "Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};     
        // *** Vector de tipo de dato double que representa los valores para cada elemento del vector String, para la conversion entre Unidades de Almacenamiento Informático en bits. ***         
        final double[] CONVERSIONES = {1.0, 8.0, 8.0 * 1024, 8.0 * 1024 * 1024, 8.0 * 1024 * 1024 * 1024, 8.0 * 1024 * 1024 * 1024 * 1024};
        /*
        Explicación del vector CONVERSIONES
        1 bits = 1 bits.
        1 byte = 8 bits.
        1 kb   = 8 x 1024 bits.
        1 mb   = 8 x 1024 bits x 1024 bits. 
        1 Gb   = 8 x 1024 bits x 1024 bits x 1024 bits.
        1 Tb   = 8 x 1024 bits x 1024 bits x 1024 bits x 1024 bits.
        
        Primero se convierte todo el valor a nuestra unidad base que es el bit y
        Luego el resultado se convierte a la unidad requerida dividiendo
        */
        int unidadInicial = obtenerUnidad(teclado, UNIDADES_DE_ALMACENAMIENTO, "Inicial" );
        int unidadFinal = obtenerUnidad(teclado, UNIDADES_DE_ALMACENAMIENTO, "Final");
        imprimirConversionEntreUnidades(valor, unidadInicial, unidadFinal, UNIDADES_DE_ALMACENAMIENTO, CONVERSIONES);
        obtenerValidacion(teclado);  
    }
    
    // *** Este procedimiento simplemente imprime un encabezado. ***
    public static void imprimirEncabezadoDelPrograma(){
        System.out.println("*.- B I E N V E N I D O -.*");
        System.out.println("*.- Trabajo Práctico Nro. 1: ***\"Conversor de Unidades de Almacenamiento Informático. - JAVA\" ***");
        System.out.println("\n*.- El programa permite la conversión entre las siguientes unidades:");
        System.out.println("*.- (Bits - Bytes - Kilobytes - Megabytes - Gigabytes - Terabytes) -.*");      
    }
    
    // *** Función que solicita al usuario que ingrese el valor a convertir y devuelve ese valor como double. ***
    public static double solicitarValorAConvertir(Scanner teclado){        
        System.out.print("\n*.- Ingrese el valor a convertir: ");
        double valor = teclado.nextDouble();         
        return valor;
    }
    
    // *** Esta función solicita al usuario seleccionar la unidad de almacenamiento informático (inicio y final) que desea convertir ***
    public static int obtenerUnidad(Scanner teclado, String[] UNIDADES_DE_ALMACENAMIENTO, String unidad){         
        System.out.println("");        
        // *** Recorre el vector/arreglo Unidades de Almacenamiento e imprime el índice y el elemento encontrado para cada                      índice. ***
        for (int i = 0; i < UNIDADES_DE_ALMACENAMIENTO.length; i++) {
            System.out.println((i+1) + ". " + UNIDADES_DE_ALMACENAMIENTO[i]);
        }
        System.out.print("Seleccione la unidad " + unidad + " a convertir: ");
        int unidadInicial = teclado.nextInt();
        // *** Validación en caso que la unidad seleccionada sea errónea. ***
        if (unidadInicial < 1 || unidadInicial >= UNIDADES_DE_ALMACENAMIENTO.length+1) {
            System.out.println("E R R O R..! Unidad " + unidad + " inválida.");            
            return obtenerUnidad(teclado, UNIDADES_DE_ALMACENAMIENTO, unidad);            
        }        
        return unidadInicial;        
    } 
    
    // *** Procedimiento que imprime el resultado de la conversión entre las unidades de almacenamiento informático ***
    public static void imprimirConversionEntreUnidades(double valor, int unidadInicial, int unidadFinal, String[] UNIDADES_DE_ALMACENAMIENTO, double[] CONVERSIONES){
        double resultado = convertirValorEntreUnidades(valor, unidadInicial, unidadFinal, CONVERSIONES);
        System.out.println("");       
        System.out.println(valor + " " + UNIDADES_DE_ALMACENAMIENTO[unidadInicial-1] + " es igual a: " + resultado + " " + UNIDADES_DE_ALMACENAMIENTO[unidadFinal-1]);
    }
    
    // *** Función que realiza la conversion del valor ingresado por el usuario entre la unidad de conversión inicial y la unidad de conversión final. ***
    public static double convertirValorEntreUnidades(double valor, int unidadInicial, int unidadFinal, double[] CONVERSIONES) {
        double valorEnBits = valor * CONVERSIONES[unidadInicial-1];
        return valorEnBits / CONVERSIONES[unidadFinal-1];       
    }  
    
    // *** Este procedmiento solicita al usuario la validación si desea continuar. ***  
    public static void obtenerValidacion(Scanner teclado){
        boolean continuar = false;
        String opcion;        
        while(!continuar){
            System.out.print("\n¿Desea realizar otra conversión? (S/N): ");
            opcion = teclado.next().toUpperCase();            
            switch(opcion){
                case "S": 
                    System.out.println("");
                    solucionProgramaConversorDeUnidades();
                    continuar = true;                          
                    break;            
                case "N":                    
                    salida();
                    continuar = true;
                    break;
                default : System.out.println("Error..! Por favor, ingrese solo: (\"S\" o \"N\").");
            }            
        }        
    }
    
    // *** Procedimiento que muestra mensaje de salida del programa ***
    public static void salida(){
        System.out.println("\n*.- Gracias por utilizar el Convertidor de Unidades. ¡Hasta luego!");
    }

} // *** Cierre de la clase ***
