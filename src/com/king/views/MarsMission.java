package com.king.views;

import java.util.Scanner;

import com.king.controllers.InstructionController;

public class MarsMission {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    String landingPosition = null;
    System.out.print("Enter rover's landing position: ");
    landingPosition = userInput.next();
    
    String movementPlanned = null;
    System.out.print("Enter rover's movement planed: ");
    movementPlanned = userInput.next();
    
    InstructionController controller = new InstructionController(landingPosition, movementPlanned);
    System.out.println("OK. The rover is landing .. ");
    controller.landTheRover();
    
    System.out.println("Landed. Rover is moving ...");
    controller.performMovement();
    
    System.out.println("Finished. Rover is at " + controller.reportPosition());
    
  }
}
