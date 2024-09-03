/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import vista.main_view;
/**
 * Controlador principal del programa, inicializa la app 
 * @author Aarón Piñar Mora 
 */
public class MainController implements ActionListener{
  public main_view vista;  

  
  public MainController(main_view vista) {
    this.vista = vista;
    this.vista.cargaArchivo.addActionListener(this);
    this.vista.configuracion.addActionListener(this);
    this.vista.Empezar.addActionListener(this);
    //this.vista.panel.addActionListener(this);
  }
  /**
   * Funcion encargada de colocar la memoria en la interfaz 
   * @param memoSO memoria dedicada para el sistema operativo
   * @param memoUS memoria dedicada para el usario, generada aleatoriamente
   */
  public void colocaCargasMemoria(String memoSO, String memoUS) {
    vista.memoriaSO.setText(memoSO);
    vista.memoriaUser.setText(memoUS);
    System.out.println("Asignado memoria, SO="+memoSO+" US="+memoUS);
  }  
  private void cargarArchivo() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos ASM", "asm"));
    
    int result = fileChooser.showOpenDialog(vista);
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      if (validarExtensionASM(selectedFile)) {
        leerArchivo(selectedFile);
      } 
      else {
        JOptionPane.showMessageDialog(vista, "El archivo seleccionado no es un archivo .asm válido.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  private void leerArchivo(File file) {
    StringBuilder instrucciones = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        System.out.println("Instrucción: " + linea);
        instrucciones.append(linea).append("\n");        
      }
      vista.panel.setText(instrucciones.toString());
    } 
    catch (IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(vista, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  private boolean validarExtensionASM(File file) {
    String fileName = file.getName();
    return fileName.endsWith(".asm");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
          case "cargaArchivo":
            //JOptionPane.showMessageDialog(vista, "Cargando, en un momento se actualizara la base de datos"); Forma de ventana emergente 
            System.out.println("Se cargaran archivos, esperando seleccion");
            cargarArchivo();
            break;
          case "configuracion":
              System.out.println("Entrando a configuración");
              vista.setVisible(false);
              GestorConfig next_frame = new GestorConfig(this);
              next_frame.llamada();
              break;
              
          default:
              throw new AssertionError();
      }
  }
  
}
