package com.king.controllers;

import com.king.models.Rover;

public class InstructionController {
  private String landingPosition;
  private String movementPlanned;
  private Rover rover;
  
  public InstructionController(String landingPosition, String movementPlanned) {
    super();
    if (landingPosition == null ) {
      throw new IllegalArgumentException("Landing Position can't be NULL");
    }
    
    if (landingPosition.length() != 3) {
      throw new IllegalArgumentException("Landing Position must be in the format of XYD, e.g. 44N");
    }
    
    if (movementPlanned == null ) {
      throw new IllegalArgumentException("Movement Plan can't be NULL");
    }
    this.landingPosition = landingPosition;
    this.movementPlanned = movementPlanned;
  }
  
  public void landTheRover() {
    String[] landingInfo = this.landingPosition.toUpperCase().split("(?!^)");
    Integer x = Integer.valueOf(landingInfo[0]);
    Integer y = Integer.valueOf(landingInfo[1]);
    String direction = landingInfo[2];
    this.rover = new Rover(x, y, direction);
  }
  
  public String reportPosition() {
    if (this.rover == null) {
      return "The rover has landed yet.";
    } else {
      return this.rover.toString();
    }
  }
  
  public void performMovement() {
    if (this.rover == null) {
      System.out.println("Please land the rover first");
    } else {
      String[] instructions = this.movementPlanned.toUpperCase().split("(?!^)");
      for (String instruction : instructions) {
        if (instruction.equals("M")) {
          this.rover.move();
        } else {
          this.rover.changeDirection(instruction);
        }
      }
    }
  }
}
