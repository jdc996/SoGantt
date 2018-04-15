/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasso;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Cola {

    private Nodo procesador;
    private int contNombre = 0;
    private ArrayList<String[]> lista;
    
    public Cola() {
        procesador = new Nodo("Procesador ", 0, 0);
        procesador.setSiguiente(procesador);
        procesador.calcularTiempoFinal(0);
        procesador.calcularTiempoRetorno();
        procesador.calcularTiempoEspera();
    }

    public void agregar(Nodo n, int nombre, int tiempoLlegada, int tiempoRafaga) {
        if (n.getSiguiente() == procesador) {
            if (procesador.getSiguiente() == procesador) {
                Nodo siguiente = new Nodo(String.valueOf(nombre), tiempoLlegada, tiempoRafaga, getProcesador());
                //siguiente.calcularTiempoFinalPrimero();
                //siguiente.calcularTiempoRetorno();
                //siguiente.calcularTiempoEspera();
                n.setSiguiente(siguiente);
            } else {
                Nodo siguiente = new Nodo(String.valueOf(nombre), tiempoLlegada, tiempoRafaga, getProcesador());
                //siguiente.calcularTiempoFinal(n.getTiempoFinal());
                //siguiente.calcularTiempoRetorno();
                //siguiente.calcularTiempoEspera();
                n.setSiguiente(siguiente);
            }
        } else {
            agregar(n.getSiguiente(), nombre, tiempoLlegada, tiempoRafaga);
        }
    }

    public void calcularTiempos(Nodo n) {

        n.calcularTiempoFinal(n.getTiempoFinal());
        n.calcularTiempoRetorno();
        n.calcularTiempoEspera();

    }

    public void atenderProcesos() {
        if (!colaVacia()) {
            Nodo p = procesador.getSiguiente();
            if (p.getSiguiente() == procesador) {
                procesador.setSiguiente(procesador);
                p.calcularTiempoFinal(procesador.getTiempoFinal());
                p.calcularTiempoRetorno();
                p.calcularTiempoEspera();

                //calcular tiempos
            } else {
                Nodo q = p.getSiguiente();
                q.calcularTiempoFinal(p.getTiempoFinal());
                q.calcularTiempoRetorno();
                q.calcularTiempoEspera();
                procesador.setSiguiente(q);
            }
        }
    }

    public String[] guardarDatos(Nodo n) {
        String[] datos = new String[6];
        datos[0] = n.getNombre();
        datos[1] = String.valueOf(n.getTiempoLlegada());
        datos[2] = String.valueOf(n.getTiempoRafaga());
        datos[3] = String.valueOf(n.getTiempoRetorno());
        datos[4] = String.valueOf(n.getTiempoEspera());
        datos[5] = String.valueOf(n.getTiempoFinal());
        return datos;
    }
//revisar si manejarlo como lista o como String[]
    public String[] atender() {
        String[] procesoEjecutado=null;
        if (!colaVacia()) {
            Nodo p = procesador.getSiguiente();
            if (p.getTiempoFinal() == 0) {
                p.calcularTiempoFinalPrimero();
                p.calcularTiempoRetorno();
                p.calcularTiempoEspera();
                
            }procesoEjecutado=new String[6];
            procesoEjecutado=guardarDatos(p);

            if (p.getSiguiente() == procesador) {
                procesador.setSiguiente(procesador);

            } else {

                Nodo q = p.getSiguiente();
                if(p.getTiempoFinal()>q.getTiempoLlegada()){
                q.calcularTiempoFinal(p.getTiempoFinal());
                q.calcularTiempoRetorno();
                q.calcularTiempoEspera();
                }
                procesador.setSiguiente(q);
                
            }

            //return "Se ha ejecutado cedula: " + p.getCedula() + ", Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido();
        }
        //return "Cedula: " + procesador.getCedula() + ", Nombre: " + procesador.getNombre() + ", Apellido: " + procesador.getApellido();
        return procesoEjecutado;
    }

    public boolean colaVacia() {
        if (procesador.getSiguiente() == procesador) {
            return true;
        }
        return false;
    }

    public ArrayList<String[]> imprimir(Nodo n) {
        if (n.equals(getProcesador())) {
            lista = new ArrayList<>();
        }
        String[] datos = new String[6];
        datos[0] = n.getNombre();
        datos[1] = String.valueOf(n.getTiempoLlegada());
        datos[2] = String.valueOf(n.getTiempoRafaga());
        datos[3] = String.valueOf(n.getTiempoRetorno());
        datos[4] = String.valueOf(n.getTiempoEspera());
        datos[5] = String.valueOf(n.getTiempoFinal());
        lista.add(datos);
        if (n.getSiguiente() != getProcesador()) {
            imprimir(n.getSiguiente());
        }
        return lista;
    }

    public Nodo getProcesador() {
        return procesador;
    }

    public void setProcesador(Nodo cajero) {
        this.procesador = cajero;
    }

}
