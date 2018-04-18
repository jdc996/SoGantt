/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasso;

import controlador.Control;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanDavid
 */
public class EjecutarProcesos extends Thread {

    private Cola cola;
    private ArrayList<String[]> gantt;
    private Control control;
    private int ejecucion ,  tiempoFila = 0;
    private String[] datosGantt;
    

    public EjecutarProcesos(Cola c, Control con, ArrayList<String[]> gantt) {
        this.cola = c;
        this.control = con;
        this.gantt = gantt;

    }

    public void ejecutar() throws InterruptedException {
        if (!cola.colaVacia()) {
            System.out.println("entro a ejecutor**********************");
            
            //Se obtienen el tiempo de rafaga, tiempo de llegada y nombre del proceso que se ejecturara
            ejecucion = (cola.getProcesador().getSiguiente().getTiempoRafaga());
            int fila = Integer.parseInt(cola.getProcesador().getSiguiente().getNombre());
            int columna = cola.getProcesador().getSiguiente().getTiempoLlegada();

            //Se pinta en la tabla de Gantt la ejecucion del proceso, de acuerdo al tiempo de rafaga
            pintarGantt(ejecucion, fila, tiempoFila);
            
            //Se almacenan los datos de la cola en un arreglo, nombre, tiempo de llegada, Rafaga, Retorno, Espera y final
            datosGantt = cola.atender();
            //Se pinta el tiempo de espera del proceso en el diagrama de gantt
            pintarGanttEspera(Integer.parseInt(datosGantt[4]), fila, columna);
            //Se modifican en la lista de procesos gantt los datos de tiempo de Retorno, Espera y final del proceso en ejecucion
            gantt.set(Integer.parseInt(datosGantt[0]) - 1, datosGantt);
            //Se pinta en la tabla de procesos los datos de tRetorno, espera y final del proceso
            control.actualizarFila(datosGantt[3], Integer.parseInt(datosGantt[0]) - 1, 3);
            control.actualizarFila(datosGantt[4], Integer.parseInt(datosGantt[0]) - 1, 4);
            control.actualizarFila(datosGantt[5], Integer.parseInt(datosGantt[0]) - 1, 5);
            System.out.println("************Diagrama Gantt Ejecutado ************");
            System.out.println("**************************************************");

        } else {
            Thread.sleep(1000);
            aumentarTiempo();
        }
    }

    public void pintarGantt(int tiempo, int fila, int columna) throws InterruptedException {
        for (int i = 0 ; i < tiempo; i += 1) {
            Thread.sleep(1000);
            //Se pinta en la vista la ejecion del proceso de gantt
            control.actualizarFilaGantt("Ejecutando", fila, columna);
            columna++;
            aumentarTiempo();
        }
        
    }

    public void pintarGanttEspera(int tiempo, int fila, int columna) throws InterruptedException {
            for (int i = 0; i < tiempo; i += 1) {
                control.actualizarFilaGanttEspera("Espera", fila, columna);
                columna++;
        }
    }

    public void aumentarTiempo() {
        tiempoFila += 1;
        System.out.println(tiempoFila);
    }

    public void run() {
        while (true) {
            try {
                ejecutar();

            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutarProcesos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
