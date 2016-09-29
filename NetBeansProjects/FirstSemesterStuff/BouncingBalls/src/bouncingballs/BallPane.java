package bouncingballs;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {

    Random rand = new Random();
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = rand.nextInt(10) - 5, dy = rand.nextInt(10) - 5;
    private Timeline animation;
    public final double STARTING_GREEN_BALL_AMOUNT = 10;
    private double redBallX = 300, redBallY = 300; // initial red ball position
    RedBall redBall = new RedBall(redBallX, redBallY, radius);

    public BallPane() {
        for (int i = 0; i <= STARTING_GREEN_BALL_AMOUNT; i++) {
            getChildren().add(new DefBall(x, y, radius)); // Place a ball into this pane
        }
        getChildren().add(redBall);
        // Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(5), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        // Makes all the balls follow the same movement procedure (RedBall is a DefBall as well)
        try {
            for (javafx.scene.Node node : this.getChildren()) {
                DefBall defBall = (DefBall) node;
                // Makes the balls wrap around
                if (defBall.getCenterX() < -radius || defBall.getCenterX() > getWidth() + radius) {
                    if (defBall.getCenterX() < -radius) {
                        defBall.setCenterX(getWidth() + radius);
                    } else if (defBall.getCenterX() > getWidth() + radius) {
                        defBall.setCenterX(-radius);
                    }
                }
                if (defBall.getCenterY() < -radius || defBall.getCenterY() > getHeight() + radius) {
                    if (defBall.getCenterY() < -radius) {
                        defBall.setCenterY(getHeight() + radius);
                    } else if (defBall.getCenterY() > getHeight() + radius) {
                        defBall.setCenterY(-radius);
                    }
                }
                // Moves the balls
                defBall.setCenterX(defBall.dx + defBall.getCenterX());
                defBall.setCenterY(defBall.dy + defBall.getCenterY());

                // Erases the green balls if they come into contact
                if (redBall.intersects(defBall.getBoundsInLocal())) {
                    // Prevents the red ball from being erased
                    if (redBall.getCenterX() != defBall.getCenterX()) {
                        getChildren().remove(defBall);

                        redBall.setDX(rand.nextInt(20) - 10);
                        redBall.setDY(rand.nextInt(20) - 10);
                    }
                }
            }
        } catch (ConcurrentModificationException e) {

        }
    }

    // Creates a green ball
    public void createDefBall(double X, double Y) {
        getChildren().add(new DefBall(X, Y, radius));
    }
}
