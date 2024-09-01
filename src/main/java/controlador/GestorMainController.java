/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.main_view;
/**
 * Clase encargada de gestionar los accesos a los diferentes frames 
 * @author Aarón Piñar Mora 
 */
public class GestorMainController {
  public static void main(String[] args) {
    main_view vista = new main_view();

    MainController Inicio = new MainController(vista);
               
    Inicio.vista.setVisible(true);
    //Inicio.vista.setLocationRelativeTo(null);
    
    } 
  void llamada() {
    main(null);
  }
}
