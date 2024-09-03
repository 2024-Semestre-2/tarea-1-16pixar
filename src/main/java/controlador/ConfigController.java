/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.configuracion_view;
import modelo.Memory;


/**
 *
 * @author Aarón Piñar Mora 
 */
public class ConfigController implements ActionListener{
  public configuracion_view vista;
  private MainController mainController;
  private Memory memoria;
  
  public ConfigController(configuracion_view vista, MainController mainController) {
    this.vista = vista;
    this.vista.atras.addActionListener(this);
    this.vista.listo.addActionListener(this);
    this.vista.cantidadMemoria.addActionListener(this);
    this.mainController = mainController;  
    this.memoria = new Memory(100);
  }
  
 
  @Override
  public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
          case "atras":
            System.out.println("Regresando a Frame Principal");
            vista.setVisible(false);
            GestorMainController next_frame = new GestorMainController();
            next_frame.llamada();
            break;
          case "listo":
            try {
              String textoMemoria = this.vista.cantidadMemoria.getText();
              if (textoMemoria.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Error: Debe ingresar una cantidad de memoria.");
              } 
              else {
                int cantidadMemoria = Integer.parseInt(textoMemoria);
                if (cantidadMemoria > -1 && cantidadMemoria <100) {
                  System.out.println("Iniciando app con " + cantidadMemoria + " unidades de memoria...");  // Inicia
                  int numeroRandomMemoUser = memoria.generarMemoriaUsuario(cantidadMemoria);
                  mainController.colocaCargasMemoria(textoMemoria,  String.valueOf(numeroRandomMemoUser));
                  //mainController.colocaCargasMemoria(textoMemoria, numeroRandomMemoUser); 
                  
                  mainController.vista.setVisible(true);  // Volver a la vista principal
                  vista.setVisible(false);  // Cerrar la vista de configuración
                  break;
                } 
                else {
                  javax.swing.JOptionPane.showMessageDialog(this.vista, "Error: La cantidad de memoria debe ser mayor que 0 y menor a 99.");
                }
              }
            }
            catch (NumberFormatException ex) {
              javax.swing.JOptionPane.showMessageDialog(this.vista, "Error: Debe ingresar un número válido.");
            }
              break;
              
          default:
              throw new AssertionError();
      }
  }
    
}
