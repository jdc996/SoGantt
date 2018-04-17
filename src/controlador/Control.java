/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import colasso.Cola;
import colasso.AgregarProcesos;
import colasso.EjecutarProcesos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.Vista;

/**
 *
 * @author
 */
public class Control implements ActionListener {

    private Vista vista;
    private Cola cola;

    public Control(Vista vista, Cola cola) {
        this.vista = vista;
        this.cola = cola;

    }

    public void iniciar() {
        vista.setTitle("Colas");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    public void agregar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void actualizarTabla(ArrayList<String[]> datos) {
        vista.getModeloTablaProcesos().addRow(datos.get(datos.size() - 1));
    }

    public void actualizarFila(String datos, int fila, int columna) {
        vista.getModeloTablaProcesos().setValueAt(datos, fila, columna);
    }

    public void actualizarTablaGantt(String[] datos) {
        vista.getGantt().addRow(datos);
    }

    public void actualizarFilaGantt(String color, int fila, int columna) {
        
            vista.getGantt().setValueAt(color, fila-1, columna + 1);     
    }
    public void actualizarFilaGanttEspera(String color, int fila, int columna) {
        
            vista.getGantt().setValueAt(color, fila-1, columna + 1);     
    }
    
}
