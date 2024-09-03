/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.configuracion_view;
import vista.main_view;

/**
 * Clase encargada de gestionar acceso a otros frames
 * @author Aarón Piñar Mora
 */
public class GestorConfig {
  private MainController mainController;

  public GestorConfig(MainController mainController) {
    this.mainController = mainController;
  }

  public void llamada() {
        configuracion_view vista = new configuracion_view();
        ConfigController configController = new ConfigController(vista, mainController); 
        configController.vista.setVisible(true);
        configController.vista.setLocationRelativeTo(null);
    }
 
  public void cerrar() {
    // Volver a la ventana principal
    mainController.vista.setVisible(true);
  }
    
}
