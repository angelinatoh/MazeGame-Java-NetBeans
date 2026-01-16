package maze;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//To draw the maze 
public class Maze {
    private int[][][] levels = {
        //Drawing the maze Level 1
        { 
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 3, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        },
        //Drawing the maze Level 2
        { 
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 3, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        },
        //Drawing the maze Level 3
        { 
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 3, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 3, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        }
    };
    
    //Private fields
    private int currentLevel = 0; //To track the current level
    private int[][] lab; //Current maze
    private int keyCount; //Number of keys in the current level
    Audio audio = new Audio();

    //Maze dimensions and block sizes
    private final int rowNumber = 13;
    private final int colNumber = 23;
    private final int blockWidth = 40;
    private final int blockHeight = 40;

    //Constructor
    public Maze() {
        setMaze(currentLevel); //To initialize maze based on current level
    }
    
    //Methods for current level
    public void setCurrentLevel(int level) {
        if (level >= 0 && level < levels.length) {
            currentLevel = level;
            setMaze(currentLevel);
        }
    }
    
    //Methods for maze state
    public int getCurrentLevel() {
        return currentLevel;
    }
    
    public void setMazeState(int[][] state) {
        if (state != null && state.length > 0) {
            lab = state;
            keyCount = countKeys(); // Initialize key count for the level
        } else {
            setMaze(currentLevel); // Fallback to the current level's default state
        }
    }
    
    public int[][] getMazeState() {
        return lab;
    }

    //Paint method
    public void paint(GraphicsContext gc) {
        for (int row = 0; row < rowNumber; row++) {
            for (int col = 0; col < colNumber; col++) {
                if (lab[row][col] == 1) {
                    // Draw walls
                    gc.setFill(Color.GREEN);
                    gc.fillRect(col * blockWidth, row * blockHeight, blockWidth, blockHeight);
                    gc.setStroke(Color.DARKGREEN);
                    gc.strokeRect(col * blockWidth, row * blockHeight, blockWidth, blockHeight);
                } else if (lab[row][col] == 3) {
                // Draw key
                gc.setFill(Color.GOLD);

                // Draw the key handle
                double handleRadius = blockWidth / 4;
                double handleCenterX = col * blockWidth + blockWidth / 2;
                double handleCenterY = row * blockHeight + blockHeight / 3;
                gc.fillOval(handleCenterX - handleRadius, handleCenterY - handleRadius, handleRadius * 2, handleRadius * 2);

                // Draw the key shaft
                double shaftWidth = blockWidth / 8;
                double shaftHeight = blockHeight / 2;
                double shaftX = handleCenterX - shaftWidth / 2;
                double shaftY = handleCenterY + handleRadius - shaftHeight / 4;
                gc.fillRect(shaftX, shaftY, shaftWidth, shaftHeight);

                // Draw the key teeth
                double toothWidth = blockWidth / 12;
                double toothHeight = blockHeight / 12;
                gc.fillRect(shaftX - toothWidth, shaftY + shaftHeight - toothHeight, toothWidth, toothHeight);
                gc.fillRect(shaftX + shaftWidth, shaftY + shaftHeight - toothHeight, toothWidth, toothHeight);
            }
        }
    }

        //Example text drawing
        gc.setFill(Color.WHITE);
        gc.fillText("Start", 10, 30); //Adjusted position for "Start" text
        gc.fillText("End", 892, 470); //Adjusted position for "End" text
    }

    //Method for next level
    public void goToNextLevel() {
        currentLevel++;
        if (currentLevel < levels.length) {
            setMaze(currentLevel);
            playSoundEffect(1);
        } else {
            System.out.println("Congratulations! You have completed all levels.");
            playSoundEffect(3);
            stopAudio(0);
            playBGM(4);
            
        }
    }

    //Method for collecting keys
    public boolean moveCharacter(int newRow, int newCol) {
        if (newRow < 0 || newRow >= lab.length || newCol < 0 || newCol >= lab[0].length || lab[newRow][newCol] == 1) {
            return false;
        }

        if (lab[newRow][newCol] == 3) { //If the new position is a key
            lab[newRow][newCol] = 0; //Remove the key
            keyCount--; //Decrement key count
            playSoundEffect(2);
            if (keyCount > 0) {
                showAlert(keyCount + " more key" + (keyCount == 1 ? "" : "s") + " to go! You can do it!");
            } else {
                goToNextLevel(); //Move to the next level if all keys are collected
            }
        }

        return true;
    }

    public void resetCurrentLevel() {
        setMaze(currentLevel);
    }
    
    //Private method
    private void setMaze(int level) {
        if (level >= 0 && level < levels.length) {
            lab = levels[level];
            keyCount = countKeys(); //Initialize key count for the level
        } else {
            //Handle if level index is out of bounds
            System.out.println("Invalid level index: " + level);
        }
    }

    //Private method
    private int countKeys() {
        int count = 0;
        for (int row = 0; row < rowNumber; row++) {
            for (int col = 0; col < colNumber; col++) {
                if (lab[row][col] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    //Private method
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Whispers Of The Past; A Maze Of Secrets");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void playSoundEffect(int i) {     
        audio.setFile(i);
        audio.play();
    }

    public void playBGM(int i) {       
        audio.setFile(i);
        audio.play();
        audio.loop();
    }
    
    public void stopAudio(int i) {
        audio.setFile(i);
        audio.stop();
    }
    
}
