/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import colasso.Cola;
import colasso.AgregarProcesos;
import colasso.EjecutarProcesos;
import controlador.Control;
import java.util.ArrayList;
import vista.Vista;

/**
 *
 * @author JuanDavid
 */
public class main {

   
    public static void main(String[] args) {
        
       Cola cola=new Cola();
       Vista vista=new Vista();
       Control control=new Control(vista, cola);
       ArrayList<String[]> gantt=new ArrayList<>();
       AgregarProcesos c = new AgregarProcesos(cola,control,gantt);
       c.start();
       control.iniciar();
       
       EjecutarProcesos e=new EjecutarProcesos(cola, control, gantt);
       e.start();
       //EjecutarProcesos e=new EjecutarProcesos(cola);  
    }
    
}
