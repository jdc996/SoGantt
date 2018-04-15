/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasso;

import controlador.Control;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class ColasSo {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        Cola cola = new Cola();
//        Scanner entrada = new Scanner(System.in);
//       
//        //Computador c = new Computador(cola);
//       // EjecutarProcesos e=new EjecutarProcesos(cola);
//        ArrayList<String[]> gantt = new ArrayList<>();
//        //c.start();
//        //e.start();
//        int opcion = 0;
//        while (opcion != 4) {
//            System.out.println("Escoja una opcion:");
//            System.out.println("- Para imprimir la cola presione 1");
//            System.out.println("- Para agregar un proceso presione 2");
//            System.out.println("- Para desencolar un proceso presione 3");
//            System.out.println("- Para salir un proceso presione 4");
//            opcion = entrada.nextInt();
//
//            switch (opcion) {
//                case 1:
//                    ArrayList<String[]> lista = new ArrayList<>();
//                    lista.clear();
//                    lista = cola.imprimir(cola.getProcesador());
//                    for (String[] s : lista) {
//                        System.out.println(Arrays.toString(s));
//                    }
//
//                    break;
//                case 2:
//                    System.out.println("Ingrese los datos");
//                    int nombre = entrada.nextInt();
//                    int tiempoLlegada = entrada.nextInt();
//                    int tiempoRafaga = entrada.nextInt();
//                    cola.agregar(cola.getProcesador(), nombre, tiempoLlegada, tiempoRafaga);
//                    break;
//                case 3:
//                    
//                    String[] datos=cola.atender();
//                    if (datos!= null) {
//                        gantt.add(datos);
//                    }
//                    gantt.forEach((s) -> {
//                        System.out.println(Arrays.toString(s));
//                    });
//                    break;
//                case 4:
//                    System.out.println("CPU apagada");
//                    break;
//                default:
//                    System.out.println("Opción erronea.");
//                    break;
//            }
//
//        }
//    }

}
