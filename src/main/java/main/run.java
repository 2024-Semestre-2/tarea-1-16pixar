/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import controlador.MainController;
import vista.main_view;
/**
 * Clase encargada de iniciar la aplicación 
 * @author Aarón Piñar Mora 
 */
public class run {
  public static void main(String[] args) {
  main_view vista = new main_view();
    
  MainController Inicio = new MainController(vista);      
  Inicio.vista.setVisible(true);
  Inicio.vista.setLocationRelativeTo(null); 
  }    
  void llamada() {
    main(null);
  } 
}
