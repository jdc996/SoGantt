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
import java.util.Random;

/**
 *
 * @author JuanDavid
 */
public class AgregarProcesos extends Thread {

    public AgregarProcesos(Cola c, Control control, ArrayList<String[]> gantt) {
        this.cola = c;
        this.control = control;
        this.lista = gantt;
        this.hiloEspera = new PintarEspera(this.control);

    }

    private int contProcesos = 0, tLlegada = 0, tRafaga, espera;
    private Random rand = new Random();
    private Cola cola;
    private boolean bandera = false, banderaHilo = true;
    private Control control;
    private ArrayList<String[]> lista;
    private int tiempoFilaAgregar = -1;
    private PintarEspera hiloEspera;

    public void crearProcesos() throws InterruptedException {

        contProcesos += 1;
        tRafaga = rand.nextInt(15) + 1;
        espera = rand.nextInt(15) + 4;
        cola.agregar(cola.getProcesador(), contProcesos, tLlegada, tRafaga);
        String[] datos = new String[]{String.valueOf(contProcesos), String.valueOf(tLlegada), String.valueOf(tRafaga), "0", "0", "0"};
        String[] datosGantt = new String[]{String.valueOf(contProcesos)};
        lista.add(datos);
//   
        hiloEspera.setTiempoLlegada(tLlegada);
        hiloEspera.setTiempoRafaga(tRafaga);
        hiloEspera.setContProcesos(contProcesos);
//    
        if (banderaHilo) {
            iniciarHilo();
        }
        //while(espera>tRafaga){
        //    espera=rand.nextInt(10)+1;
        //}
        tLlegada += espera;
        //lista = cola.imprimir(cola.getProcesador());
        //System.out.println("*************PROCESO AGREGADDO******************");
        //for (String[] s : lista) {
        //    System.out.println(Arrays.toString(s));
        //}
        //System.out.println("************************************************");
        control.actualizarTabla(lista);
        control.actualizarTablaGantt(datosGantt);
        aumentarTiempo(espera);
        //Thread.sleep((espera * 1000)); no funciona

    }

    public void iniciarHilo() {
        hiloEspera.start();
        banderaHilo = false;
    }

    public void aumentarTiempo(int espera) throws InterruptedException {
        for (int i = 0; i < espera; i++) {
            tiempoFilaAgregar += 1;
            System.out.println("tiempo Agregar: " + tiempoFilaAgregar);
            Thread.sleep(1000);
        }
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public ArrayList<String[]> getLista() {
        return lista;
    }

    public void setLista(ArrayList<String[]> lista) {
        this.lista = lista;
    }

    public void run() {

        while (true) {
            try {
                crearProcesos();

            } catch (InterruptedException ex) {
                Logger.getLogger(AgregarProcesos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
