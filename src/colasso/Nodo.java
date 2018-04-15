/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasso;

/**
 *
 * @author Juan
 */
public class Nodo {
    
    private String nombre;
    private int tiempoLlegada, tiempoRafaga, tiempoRetorno, tiempoEspera, tiempoFinal;
    private Nodo siguiente;

    public Nodo(String nombre, int tllegada,int tRafaga) {
        this.nombre = nombre;
        this.tiempoLlegada = tllegada;
        this.tiempoRafaga = tRafaga;
    }

    public Nodo(String nombre, int tLlegada,int tRafaga, Nodo siguiente) {
      
        this.nombre = nombre;
        this.tiempoLlegada = tLlegada;
        this.tiempoRafaga = tRafaga;
        this.siguiente = siguiente;
    }
    
    public void calcularTiempoFinal(int tFinal){
        this.setTiempoFinal(tFinal + this.getTiempoRafaga());
    }
    public void calcularTiempoRetorno(){
       this.setTiempoRetorno(this.getTiempoFinal()-this.getTiempoLlegada());
    }
    
    public void calcularTiempoEspera(){
        this.setTiempoEspera(this.getTiempoRetorno()-this.getTiempoRafaga());
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoRafaga() {
        return tiempoRafaga;
    }

    public void setTiempoRafaga(int tiempoRafaga) {
        this.tiempoRafaga = tiempoRafaga;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public int getTiempoRetorno() {
        return tiempoRetorno;
    }

    public void setTiempoRetorno(int tiempoRetorno) {
        this.tiempoRetorno = tiempoRetorno;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(int tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }

    public void calcularTiempoFinalPrimero() {
        this.setTiempoFinal(this.getTiempoRafaga()+this.getTiempoLlegada());
    }
}
