/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Aarón Piñar Mora
 */
public class Memory {
  private Map<Integer, Instruction> memory;
  private Map<String, Integer> registers;
  
  /**
   * Funcion encargada de generar aleatoriamente la memoria para el usario apartir de la del sistema que fue colocada en la interfaz
   * @param memoriaSistema colocada por el usuario, memoria total no excede 100
   * @return memoria dedicada para el usuario
   */
  public int generarMemoriaUsuario(int memoriaSistema) {
        System.out.println("Generando memoria aleatoria..");
        Random random = new Random();
        int memoriaUsuario;

    do {
      memoriaUsuario = random.nextInt(80) + 20;  // Genera un número entre 20 y 99 la cual es para el usuario
    } 
    while (memoriaSistema + memoriaUsuario > 99);
      return memoriaUsuario;
  }  
  public Memory(int size) {
    memory = new HashMap<>(size);
    registers = new HashMap<>();
  }
  public void storeInstruction(int address, Instruction instruction) {
    memory.put(address, instruction);
  }

  public Instruction getInstruction(int address) {
    return memory.get(address);
  }

  public void setRegister(String name, int value) {
    registers.put(name, value);
  }

  public int getRegister(String name) {
    return registers.getOrDefault(name, 0);
  }    
}
