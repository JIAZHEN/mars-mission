package com.king.controllers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.king.controllers.InstructionController;

public class TestInstructionController {
  
  @Test(expected=IllegalArgumentException.class)
  public void testInstructionControllerShouldNotBeInitialisedWhenLandingPositionIsNull() {
    new InstructionController(null, "LMMMRRM");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testInstructionControllerShouldNotBeInitialisedWhenMovementPlannedIsNull() {
    new InstructionController("44N", null);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testInstructionControllerShouldNotBeInitialisedWhenLandingPositionIsEmpty() {
    new InstructionController("", "LMMMRRM");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testInstructionControllerShouldNotBeInitialisedWhenLandingPositionIsTooLong() {
    new InstructionController("TOOLONG", "LMMMRRM");
  }
  
  @Test
  public void testInstructionControllerShouldBeInitialised() {
    new InstructionController("44N", "LMMMRRM");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testInstructionControllerCannotLandTheRoverWhenLandingPositionIsWrong() {
    InstructionController controller = new InstructionController("09F", "LMMMRRM");
    controller.landTheRover();
  }
  
  @Test
  public void testInstructionControllerCanLandTheRoverWhenLandingPositionIsCorrect() {
    InstructionController controller = new InstructionController("99S", "LMMMRRM");
    controller.landTheRover();
  }
  
  @Test
  public void testInstructionControllerCanReportRoversPositonWhenRoverIsNotLanded() {
    InstructionController controller = new InstructionController("99S", "LMMMRRM");
    String actual_position = controller.reportPosition();
    String expected_position = "The rover has landed yet.";
    assertEquals(expected_position, actual_position);
  }
  
  @Test
  public void testInstructionControllerCanReportRoversPositonWhenRoverIsLanded() {
    InstructionController controller = new InstructionController("99S", "LMMMRRM");
    controller.landTheRover();
    String actual_position = controller.reportPosition();
    String expected_position = "Rover [x=9, y=9, direction=S]";
    assertEquals(expected_position, actual_position);
  }
  
  @Test
  public void testInstructionControllerCanNotPerformMovementWhenRoverIsNotLanded() {
    InstructionController controller = new InstructionController("44N", "LMMMRRM");
    controller.performMovement();
    String actual_position = controller.reportPosition();
    String expected_position = "The rover has landed yet.";
    assertEquals(expected_position, actual_position);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testInstructionControllerCanNotPerformMovementWhenmovementPlannedIsWrong() {
    InstructionController controller = new InstructionController("44N", "LMMMRRMH");
    controller.landTheRover();
    controller.performMovement();
  }
  
  @Test
  public void testInstructionControllerCanPerformMovementWhenmovementPlannedIsCorrect() {
    InstructionController controller = new InstructionController("44N", "LMMMRRM");
    controller.landTheRover();
    controller.performMovement();
    String actual_position = controller.reportPosition();
    String expected_position = "Rover [x=2, y=4, direction=E]";
    assertEquals(expected_position, actual_position);
  }
}
