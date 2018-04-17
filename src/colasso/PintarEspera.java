/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasso;

import controlador.Control;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanDavid
 */
public class PintarEspera extends Thread {

    private Control control;
    private int contProcesos=0, tempContProcesos = 0, tiempoLlegada, tiempoRafaga;

    public PintarEspera(Control control) {
        this.control = control;
    }

    public void setContProcesos(int contProcesos) {
        this.contProcesos = contProcesos;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setTiempoRafaga(int tiempoRafaga) {
        this.tiempoRafaga = tiempoRafaga;
    }

    public void pintarEspera() throws InterruptedException {
        
        if(contProcesos!=tempContProcesos){
            tempContProcesos=contProcesos;
            for(int i=0;i<tiempoRafaga;i++){
                control.actualizarFilaGanttEspera("Espera", contProcesos, tiempoLlegada);
                tiempoLlegada++;
                Thread.sleep(1000);
            }
        
        }else{
        Thread.sleep(1000);
        }
    }

    public void run() {
        
        while (true) {
            try {
                //Thread.sleep(1000);
                pintarEspera();
            } catch (InterruptedException ex) {
                Logger.getLogger(PintarEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
