package maze;

import java.io.Serializable;

public class GameState implements Serializable {
    private int playerX; //Player's X position in the maze
    private int playerY; //Player's Y position in the maze
    private int level;   //Current level of the game
    private int[][] mazeState;
    
    //Constructor
    public GameState(int playerX, int playerY, int level, int[][] mazeState) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.level = level;
        this.mazeState = mazeState;
    }

    //Getters and Setters
    public int getPlayerX() { return playerX; }
    public void setPlayerX(int playerX) { this.playerX = playerX; }

    public int getPlayerY() { return playerY; }
    public void setPlayerY(int playerY) { this.playerY = playerY; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int[][] getMazeState() { return mazeState; }
    public void setMazeState(int[][] mazeState) { this.mazeState = mazeState; }

    //String for debugging
    @Override
    public String toString() {
        return "GameState{" + "playerX=" + playerX +
                            ", playerY=" + playerY +
                            ", level=" + level +
               '}';
    }
}

