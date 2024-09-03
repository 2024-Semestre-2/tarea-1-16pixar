/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Instruction {
  private String opcode;
  private String[] operands;

  public Instruction(String opcode, String... operands) {
    this.opcode = opcode;
    this.operands = operands;
  }

  public String getOpcode() {
    return opcode;
  }

  public String[] getOperands() {
    return operands;
  }

  @Override
  public String toString() {
    return opcode + " " + String.join(" ", operands);
  }
}
