Mars Mission
====================

## Modeling

According to the description, in this task, there is a robotic rover. The rover will have its current position and direction. So when modeling it, I'd create a Rover class, with three attributes as 

```
Rover(int x, int y, String direction)
x - the x co-ordinate
y - the y co-ordinate
direction - current facing direction, only can be N, E, W, S

the co-ordinates must between 0 and 9, integer only
```

Rover can move, when it receives the `M` instruction, depends on the direction, it should change the co-ordinates as
```
y + 1 if direction is N
x + 1 if direction is E
y - 1 if direction is S
x - 1 if direction is W
```

Rover can also change the direction, when it receives the `L` or `R` instruction, depends on the direction, it should change the direction as
```
when receiving `L` instruction
  direction change to `W` if original direction is `N`
  direction change to `N` if original direction is `E`
  direction change to `E` if original direction is `S`
  direction change to `S` if original direction is `W`

when receiving `R` instruction
  direction change to `E` if original direction is `N`
  direction change to `S` if original direction is `E`
  direction change to `W` if original direction is `S`
  direction change to `N` if original direction is `W`
```

## Design parttern
I used MVC to implement in this project. And JUnit as the test frameworks. Following the TDD process, I wrote the unit tests first, initially all tests fail. Then I implemented the codes and make the tests pass. In this project, the view is the terminal.

## Improvement
The model is straight forward. Howevever, it makes the code contains many `if` statements. It should be able to optimise it. But at the first point, I'd finish the project first, then refactor the code to make it more readable. I spent 2 hours and 50 minutes to get this done (when I'm writing this)
