package com.king.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.king.models.Rover;


public class TestRover {
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWithoutXCoordinate() {
    new Rover(null, 3, "S");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWithoutYCoordinate() {
    new Rover(3, null, "S");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWithoutDirection() {
    new Rover(3, 3, null);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWhenXCoordinateIsNegative() {
    new Rover(-3, 3, "S");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWhenYCoordinateIsNegative() {
    new Rover(3, -3, "S");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWhenXCoordinateIsOver9() {
    new Rover(11, 3, "S");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWhenYCoordinateIsOver9() {
    new Rover(3, 11, "S");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverShouldNotBeInitialisedWhenDirectionIsNotNESW() {
    new Rover(3, 3, "UNKNOWNDIRECTION");
  }
  
  @Test
  public void testRoverShouldBeInitialised() {
    Rover rover = new Rover(3, 9, "W");
    assertEquals(rover.getX(), new Integer(3));
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingWestAtPoint00() {
    Rover rover = new Rover(0, 0, "W");
    rover.move();
    assertEquals(rover.getX(), new Integer(0));
    assertEquals(rover.getY(), new Integer(0));
    assertEquals(rover.getDirection(), "W");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingSouthAtPoint00() {
    Rover rover = new Rover(0, 0, "S");
    rover.move();
    assertEquals(rover.getX(), new Integer(0));
    assertEquals(rover.getY(), new Integer(0));
    assertEquals(rover.getDirection(), "S");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingWestAtPoint09() {
    Rover rover = new Rover(0, 9, "W");
    rover.move();
    assertEquals(rover.getX(), new Integer(0));
    assertEquals(rover.getY(), new Integer(9));
    assertEquals(rover.getDirection(), "W");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingNorthAtPoint09() {
    Rover rover = new Rover(0, 9, "N");
    rover.move();
    assertEquals(rover.getX(), new Integer(0));
    assertEquals(rover.getY(), new Integer(9));
    assertEquals(rover.getDirection(), "N");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingEastAtPoint90() {
    Rover rover = new Rover(9, 0, "E");
    rover.move();
    assertEquals(rover.getX(), new Integer(9));
    assertEquals(rover.getY(), new Integer(0));
    assertEquals(rover.getDirection(), "E");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingSouthAtPoint90() {
    Rover rover = new Rover(9, 0, "S");
    rover.move();
    assertEquals(rover.getX(), new Integer(9));
    assertEquals(rover.getY(), new Integer(0));
    assertEquals(rover.getDirection(), "S");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingEastAtPoint99() {
    Rover rover = new Rover(9, 9, "E");
    rover.move();
    assertEquals(rover.getX(), new Integer(9));
    assertEquals(rover.getY(), new Integer(9));
    assertEquals(rover.getDirection(), "E");
  }
  
  @Test
  public void testRoverCannotMoveWhenFacingNorthAtPoint99() {
    Rover rover = new Rover(9, 9, "N");
    rover.move();
    assertEquals(rover.getX(), new Integer(9));
    assertEquals(rover.getY(), new Integer(9));
    assertEquals(rover.getDirection(), "N");
  }
  
  @Test
  public void testRoverCanMoveWhenFacingNorthAtPoint35() {
    Rover rover = new Rover(3, 5, "N");
    rover.move();
    assertEquals(rover.getX(), new Integer(3));
    assertEquals(rover.getY(), new Integer(6));
    assertEquals(rover.getDirection(), "N");
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverCannotChangeDirectionWhenInstructionIsNull() {
    new Rover(3, 5, "N").changeDirection(null);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testRoverCannotChangeDirectionWhenInstructionIsNotLorR() {
    new Rover(3, 5, "N").changeDirection("WRONG");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromNtoWWhenInstructionL() {
    Rover rover = new Rover(3, 5, "N");
    rover.changeDirection("L");
    assertEquals(rover.getDirection(), "W");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromEtoNWhenInstructionL() {
    Rover rover = new Rover(3, 5, "E");
    rover.changeDirection("L");
    assertEquals(rover.getDirection(), "N");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromStoEWhenInstructionL() {
    Rover rover = new Rover(3, 5, "S");
    rover.changeDirection("L");
    assertEquals(rover.getDirection(), "E");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromWtoSWhenInstructionL() {
    Rover rover = new Rover(3, 5, "W");
    rover.changeDirection("L");
    assertEquals(rover.getDirection(), "S");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromNtoEWhenInstructionR() {
    Rover rover = new Rover(3, 5, "N");
    rover.changeDirection("R");
    assertEquals(rover.getDirection(), "E");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromEtoSWhenInstructionR() {
    Rover rover = new Rover(3, 5, "E");
    rover.changeDirection("R");
    assertEquals(rover.getDirection(), "S");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromStoWWhenInstructionR() {
    Rover rover = new Rover(3, 5, "S");
    rover.changeDirection("R");
    assertEquals(rover.getDirection(), "W");
  }
  
  @Test
  public void testRoverCanChangeDirectionFromWtoNWhenInstructionR() {
    Rover rover = new Rover(3, 5, "W");
    rover.changeDirection("R");
    assertEquals(rover.getDirection(), "N");
  }
}
