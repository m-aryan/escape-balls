# Simple 2D Game - Escape the Balls

A simple 2D game where the player controls a square (the player) and needs to avoid red balls (enemies) that bounce around the screen. The goal is to survive as long as possible without colliding with any of the balls.

## Features
- **Player Movement**: Use arrow keys or WASD to move the player square.
- **Enemies**: Multiple red balls move randomly and bounce off the edges of the screen.
- **Game Over**: If the player collides with any of the balls, the game ends and prompts the user with options to restart or quit.
- **Start Screen**: A welcome screen with "Start" and "Quit" buttons.
- **Game Restart**: Option to restart the game after a collision.

## Requirements
- Java 8 or later

## How to Run the Game

1. **Clone the repository**:

   ```
   git clone https://github.com/m-aryan/escape-balls.git
   cd simpleGame
   ```

2. **Compile the Java files**:
   Ensure you are in the `src` directory, and run the following command to compile the Java source files:

   ```
   javac -d out src/game/*.java
   
   ```

3. **Run the game**:
   After compiling, run the game using:

   ```
   java -cp out game.Main
   
   ```

## Project Structure

```
simpleGame/
├── src/
    └── game/
        ├── Main.java 
        ├── Simple2DGame.java  
        └── StartScreen.java                  
```

## Controls
- **W, A, S, D** to move the player.

## License
This project is open-source and available under the [MIT License](LICENSE).
