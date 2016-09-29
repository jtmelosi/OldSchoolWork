/* Jacob Melosi
 * 10/10/2014
 * Description: This program creates a window that balls wrap around. If a red ball touches a green ball,
 *              then the green ball will disappear and the red ball will be sent flying in a random direction
 *              at a random speed. The up and down button increase and decrease the speed of the animation.
 *              Clicking will create more green balls at the pointer's location, and dragging will create many.
 *              It is also throwing a gigantic amount of ConcurrentModificationExceptions that I couldn't get
 *              to go away, but other than that it seems to run fine.
 */
package bouncingballs;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BounceBallControl extends Application{

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        BallPane ballPane = new BallPane(); // Create a ball pane

        ballPane.setOnMouseDragged(e -> {
            ballPane.createDefBall(e.getX(), e.getY());
        });
        ballPane.setOnMouseClicked(e -> {
            ballPane.createDefBall(e.getX(), e.getY());
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
        Scene scene = new Scene(ballPane, 500, 500);
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}


