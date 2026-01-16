package maze;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Character {
    //Private Fields
    private Maze lab;
    private int x = 40;
    private int y = 40;
    private int width = 40;
    private int height = 40;
    private int movement = 40;
    private Image characterImage;
    
    //To load the character image from a URL
    public Character(Maze maze) {
        this.lab = maze;
        characterImage = new Image("https://static.vecteezy.com/system/resources/previews/022/484/537/non_2x/smart-and-cute-3d-girl-student-character-transparent-background-free-png.png");
    }   

    public void paint(GraphicsContext gc) {
        // Clear the previous drawing
        gc.clearRect(x, y, width, height);
        // Draw the character image
        gc.drawImage(characterImage, x, y, width, height);
    }
    
    //To manage how the character will move based on the keyboard function of left, right, down and up. 
    public void keyPressed(KeyEvent event) {
        int newRow = y / 40;
        int newCol = x / 40;

        switch (event.getCode()) {
            case LEFT:
                newCol -= 1;
                break;
            case RIGHT:
                newCol += 1;
                break;
            case DOWN:
                newRow += 1;
                break;
            case UP:
                newRow -= 1;
                break;
            default:
                break;
        }

        if (lab.moveCharacter(newRow, newCol)) {
            updateCharacterPosition(newRow, newCol);
                        
        }

        if (x == 840 && y == 440) {
            Main.changeLevel();
            resetPosition();
        }
    }
    
    //To update the character's position
    public void updateCharacterPosition(int row, int col) {
        x = col * 40;
        y = row * 40;
    }

    //To reset the character's position
    private void resetPosition() {
        x = 40;
        y = 40;
    }
    
    //To access the character’s position attributes of ‘x’ and ‘y’.
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
