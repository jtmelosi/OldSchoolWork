//Rocky Moss
//cs 150 assignment 4 Bouncing Balls
//October 10, 2014
//This program will creat a frame with 10 green balls and one red ball and animate them in
//random directions. The balls will wrap through the edge of the screen and appear 
//seamlessly on the opposite edge.  The red ball will randomly shift directions and 
//will knock out a green ball when it collides with it.  When the user clicks the mouse
//on the screen it will add a green ball and spray a group of green balls when the mouse 
//is clicked and dragged over the screen.
package Assignment4;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BounceBallControl extends Application {

    private final int PANE_WIDTH = 500;
    private final int PANE_HEIGHT = 500;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane(); // Create a ball pane

        // places a ball in the pane where the mouse is clicked
        ballPane.setOnMouseDragged(e -> {
            ballPane.addBall(e.getX(), e.getY());
        });
        ballPane.setOnMouseClicked(e -> {
            ballPane.addBall(e.getX(), e.getY());
        });

        // Increase and decrease animation   
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            } else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
