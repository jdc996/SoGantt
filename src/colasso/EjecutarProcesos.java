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
    private int ejecucion = 5, contador = 1, tiempoFila = 0;
    private String[] datosGantt;

    public EjecutarProcesos(Cola c, Control con, ArrayList<String[]> gantt) {
        this.cola = c;
        this.control = con;
        this.gantt = gantt;

    }

    public void ejecutar() throws InterruptedException {
        if (!cola.colaVacia()) {
            System.out.println("entro a ejecutor**********************");
            ejecucion = (cola.getProcesador().getSiguiente().getTiempoRafaga() * 1000);
            int fila = Integer.parseInt(cola.getProcesador().getSiguiente().getNombre());
            int columna = cola.getProcesador().getSiguiente().getTiempoLlegada();

            //         actualizarTabla(true);
            
            pintarGantt(ejecucion, fila, tiempoFila);
            //Thread.sleep((ejecucion));
            //           actualizarTabla(false);
            datosGantt = cola.atender();
            gantt.set(Integer.parseInt(datosGantt[0]) - 1, datosGantt);
            control.actualizarFila(datosGantt[3], Integer.parseInt(datosGantt[0]) - 1, 3);
            control.actualizarFila(datosGantt[4], Integer.parseInt(datosGantt[0]) - 1, 4);
            control.actualizarFila(datosGantt[5], Integer.parseInt(datosGantt[0]) - 1, 5);
            System.out.println("************Diagrama Gantt Ejecutado ************");
            //for (String[] s : gantt) {
            //    System.out.println(Arrays.toString(s));
            //}
            System.out.println("**************************************************");
            if (datosGantt != null) {
                //ejecucion = Integer.parseInt(datosGantt[2]);  
            }
        } else {
            Thread.sleep(1000);
            aumentarTiempo();
        }
    }

    public void pintarGantt(int tiempo, int fila, int columna) throws InterruptedException {
        for (int i = 1000; i <= tiempo; i += 1000) {
            Thread.sleep(1000);
            control.actualizarFilaGantt("Ejecutando", fila, columna);
            columna++;
            aumentarTiempo();
            //System.out.println(tiempoFila);
        }
    }

    public void aumentarTiempo() {
        tiempoFila += 1;
        System.out.println(tiempoFila);
    }

    public void run() {
        while (true) {
            try {
                //System.out.println("************ENTRO A RUN**********************");
                ejecutar();

            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutarProcesos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
