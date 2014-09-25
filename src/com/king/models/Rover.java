package com.king.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rover {
  private Integer x;
  private Integer y;
  private String direction;
  private Map<String, Integer[]> dirDelta;
  private Map<String, Integer> dirToDegree;
  private Map<Integer, String> degreeToDir;
  private final Integer minBorder = 0;
  private final Integer maxBorder = 9;
  
  /**
   * Constructor to initialise a rover
   * @param x the x co-ordinate
   * @param y the x co-ordinate
   * @param direction the facing direction, must be [W, S, N, E]
   */
  public Rover(Integer x, Integer y, String direction) {
    super();
    if (x == null) {
      throw new IllegalArgumentException("X co-ordinate can't be NULL");
    }
    if (x < this.minBorder || x > this.maxBorder) {
      throw new IllegalArgumentException("X co-ordinate must be within 0 - 9");
    }
    
    if (y == null) {
      throw new IllegalArgumentException("Y co-ordinate can't be NULL");
    }
    if (y < this.minBorder || y > this.maxBorder) {
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
    initDirDelTa();
    initMappings();
  }
  
  /*
   * Move the rover, change the co-ordinates if it's movable.
   */
  public void move() {
    Integer[] deltas = this.dirDelta.get(this.direction);
    this.x += deltas[0];
    this.y += deltas[1];
    verifyWithBorder(deltas);
  }
  
  /*
   * Change rover's facing direction. The instruction can only be either L or R
   */
  public void changeDirection(String instruction) {
    Set<String> instructions = new HashSet<String>(Arrays.asList(new String[]{ "L", "R" }));
    if (instruction == null) {
      throw new IllegalArgumentException("Instruction can't be NULL");
    } else if (!instructions.contains(instruction)) {
      throw new IllegalArgumentException("Direction (case sensitive) must be in " + instructions);
    }
    Integer degree = this.dirToDegree.get(this.direction) + this.dirToDegree.get(instruction);
    if (degree >= 360) {
      degree -= 360;
    } else if (degree < 0) {
      degree += 360;
    }
    this.direction = this.degreeToDir.get(degree);
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
  
  private void initDirDelTa() {
    this.dirDelta = new HashMap<String, Integer[]>();
    this.dirDelta.put("N", new Integer[]{0, 1});
    this.dirDelta.put("S", new Integer[]{0, -1});
    this.dirDelta.put("W", new Integer[]{-1, 0});
    this.dirDelta.put("E", new Integer[]{1, 0});
  }
  
  private void verifyWithBorder(Integer[] delta) {
    if (this.x < this.minBorder || this.x > this.maxBorder || this.y < this.minBorder || this.y > this.maxBorder) {
      System.out.println("Cannot move when the position is " + this.toString());
      this.x -= delta[0];
      this.y -= delta[1];
    }
  }
  
  private void initMappings() {
    this.dirToDegree = new HashMap<String, Integer>();
    this.dirToDegree.put("N", 0);
    this.dirToDegree.put("E", 90);
    this.dirToDegree.put("S", 180);
    this.dirToDegree.put("W", 270);
    this.dirToDegree.put("L", -90);
    this.dirToDegree.put("R", 90);
    
    this.degreeToDir = new HashMap<Integer, String>();
    this.degreeToDir.put(0, "N");
    this.degreeToDir.put(90, "E");
    this.degreeToDir.put(180, "S");
    this.degreeToDir.put(270, "W");
  }
  
}
