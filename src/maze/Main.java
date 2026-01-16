package maze;

import java.net.MalformedURLException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.Optional;
import javafx.scene.control.ButtonType;

public class Main extends Application {
    //Private fields
    private static int level = 1;
    private Maze maze = new Maze();
    private Character avatar = new Character(maze); //Pass maze to character
    
    //Constructors
    public static int getLevel() {
        return level;
    }

    public static void changeLevel() {
        level++;
        if (level <= 3) {
            showAlert("You have taken all the snippets in this level! You are now attempting Level " + level);
        } else {
            showAlert("Your journey has come to an end! Congratulations!");
            showFinalRevelation();// Exit the application after mission completed
        }
    }      

    
    private static void showFinalRevelation() {
        // Launch the Java Swing FinalRevelation screen
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Final Revelation");
            try {
                frame.setContentPane(new FinalRevelation());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);
        });
        //To exit from the game
        Platform.exit();
    }

     @Override
    public void start(Stage primaryStage) {
        boolean continueFromLastSaved = promptForGameStart();
        
        //To set the correct maze level
        if (continueFromLastSaved) {
            GameState gameState = GameStateManager.loadGameState();
            if (gameState != null) {
                avatar.setX(gameState.getPlayerX());
                avatar.setY(gameState.getPlayerY());
                level = gameState.getLevel();
                maze.setCurrentLevel(level - 1);
                maze.setMazeState(gameState.getMazeState());
            } else {
                showAlert("Failed to load game! Starting new game...");
                startNewGame();
            }
        } else {
            startNewGame();
        }

        Pane root = new Pane();
        Canvas canvas = new Canvas(920, 540);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Whispers Of The Past; A Maze Of Secrets");
        primaryStage.setResizable(false);
        primaryStage.show();

        scene.setOnKeyPressed(event -> {
            avatar.keyPressed(event);
            if (null != event.getCode()) switch (event.getCode()) {
                case S -> saveGame();
                case L -> {
                    loadGame();
                    avatar.updateCharacterPosition(avatar.getX() / 40, avatar.getY() / 40);
                }
                case R -> restartLevel();
                default -> {
                }
            }
        });
        
        primaryStage.setOnCloseRequest(event -> {
            saveGame();
            Platform.exit();
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                maze.paint(gc);
                avatar.paint(gc);
            }
        }.start();
    }
    
    //Methods for Game State Management
    private void saveGame() {
        GameState gameState = new GameState(avatar.getX(), avatar.getY(), level, maze.getMazeState());
        GameStateManager.saveGameState(gameState);
        showAlert("Game Saved!");
    }

    private void loadGame() {
        GameState gameState = GameStateManager.loadGameState();
        if (gameState != null) {
            avatar.setX(gameState.getPlayerX());
            avatar.setY(gameState.getPlayerY());
            level = gameState.getLevel();
            maze.setCurrentLevel(level - 1); //Set the correct maze level   
            maze.setMazeState(gameState.getMazeState());
            showAlert("Game Loaded!");
        } else {
            showAlert("Failed to load game!");
        }
    }
    
    private void restartLevel() {
        avatar.setX(40); // Reset character position
        avatar.setY(40); // Reset character position
        maze.resetCurrentLevel(); // Reset maze to the current level state
        showAlert("Level Restarted!");
    }
    
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    //To ask player whether they want to continue from the last saved position or start a new game
    private boolean promptForGameStart() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Start Game");
        alert.setHeaderText("Do you want to continue from the last saved position or start a new game?");
        alert.setContentText("Choose your option.");

        ButtonType continueButton = new ButtonType("Continue");
        ButtonType newGameButton = new ButtonType("New Game");

        alert.getButtonTypes().setAll(continueButton, newGameButton);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == continueButton;
    }

    //Starting a new game
    private void startNewGame() {
        level = 1;
        avatar.setX(40);
        avatar.setY(40);
        maze.setCurrentLevel(0); //Set maze to level 1
        maze.resetCurrentLevel(); //Reset the maze state
        showAlert("Starting New Game! You are currently at Level " + level);
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
