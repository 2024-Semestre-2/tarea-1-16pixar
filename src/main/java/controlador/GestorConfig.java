/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.configuracion_view;

/**
 * Clase encargada de gestionar acceso a otros frames
 * @author Aarón Piñar Mora
 */
public class GestorConfig {
  public static void main(String[] args) {
    configuracion_view vista = new configuracion_view();
    ConfigController Inicio = new ConfigController(vista);             
    Inicio.vista.setVisible(true);
    Inicio.vista.setLocationRelativeTo(null);
  } 
  void llamada() {
    main(null);
  }
    
}
