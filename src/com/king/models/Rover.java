package com.king.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rover {
  private Integer x;
  private Integer y;
  private String direction;
  
  public Rover(Integer x, Integer y, String direction) {
    super();
    if (x == null) {
      throw new IllegalArgumentException("X co-ordinate can't be NULL");
    }
    if (x < 0 || x > 9) {
      throw new IllegalArgumentException("X co-ordinate must be within 0 - 9");
    }
    
    if (y == null) {
      throw new IllegalArgumentException("Y co-ordinate can't be NULL");
    }
    if (y < 0 || y > 9) {
      throw new IllegalArgumentException("Y co-ordinate must be within 0 - 9");
    }
    
    if (direction == null || direction.isEmpty()) {
      throw new IllegalArgumentException("Direction can't be NULL or Empty");
    }
    Set<String> directions = new HashSet<String>(Arrays.asList(new String[]{ "N", "E", "S", "W" }));
    if (!directions.contains(direction)) {
      throw new IllegalArgumentException("Direction (case sensitive) must be in " + directions);
    }
    this.x = x;
    this.y = y;
    this.direction = direction;
  }
  
  public void move() {
    if (this.direction.equals("N")) {
      if (this.y + 1 > 9) {
        System.out.println("Cannot move when the position is " + this.toString());
      } else {
        this.y += 1;
      }
    } else if (this.direction.equals("E")) {
      if (this.x + 1 > 9) {
        System.out.println("Cannot move when the position is " + this.toString());
      } else {
        this.x += 1;
      }
    } else if (this.direction.equals("S")) {
      if (this.y - 1 < 0) {
        System.out.println("Cannot move when the position is " + this.toString());
      } else {
        this.y -= 1;
      }
    } else if (this.direction.equals("W")) {
      if (this.x - 1 < 0) {
        System.out.println("Cannot move when the position is " + this.toString());
      } else {
        this.x -= 1;
      }
    }
  }
  
  public void changeDirection(String instruction) {
    Set<String> instructions = new HashSet<String>(Arrays.asList(new String[]{ "L", "R" }));
    if (instruction == null) {
      throw new IllegalArgumentException("Instruction can't be NULL");
    } else if (!instructions.contains(instruction)) {
      throw new IllegalArgumentException("Direction (case sensitive) must be in " + instructions);
    }
    if (instruction.equals("L")) {
      if (this.direction.equals("N")) {
        this.direction = "W";
      } else if (this.direction.equals("W")) {
        this.direction = "S";
      } else if (this.direction.equals("S")) {
        this.direction = "E";
      } else if (this.direction.equals("E")) {
        this.direction = "N";
      }
    } else if (instruction.equals("R")) {
      if (this.direction.equals("N")) {
        this.direction = "E";
      } else if (this.direction.equals("E")) {
        this.direction = "S";
      } else if (this.direction.equals("S")) {
        this.direction = "W";
      } else if (this.direction.equals("W")) {
        this.direction = "N";
      }
    }
  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }

  public String getDirection() {
    return direction;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((direction == null) ? 0 : direction.hashCode());
    result = prime * result + ((x == null) ? 0 : x.hashCode());
    result = prime * result + ((y == null) ? 0 : y.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Rover other = (Rover) obj;
    if (direction == null) {
      if (other.direction != null)
        return false;
    } else if (!direction.equals(other.direction))
      return false;
    if (x == null) {
      if (other.x != null)
        return false;
    } else if (!x.equals(other.x))
      return false;
    if (y == null) {
      if (other.y != null)
        return false;
    } else if (!y.equals(other.y))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Rover [x=" + x + ", y=" + y + ", direction=" + direction + "]";
  }
  
}
