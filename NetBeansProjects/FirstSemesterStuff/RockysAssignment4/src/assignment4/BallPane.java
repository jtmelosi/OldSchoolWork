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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.w3c.dom.DOMException;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

public class BallPane extends Pane implements NodeIterator {

    Random rand = new Random();
    public final double radius = 20;
    private double x = radius, y = radius;
    private RedBall redBall = new RedBall(450, 450, radius);
    private Timeline animation;
    final int STARTING_NUMBER_OF_GREEN_BALLS = 10;
//    ArrayList Balls = new ArrayList();
    ArrayList<Ball> ballList = new ArrayList<Ball>();

    public BallPane() {
        for (int i = 0; i < STARTING_NUMBER_OF_GREEN_BALLS; i++) {//adds 10 green Balls
            x += 40;
            y += 10;
            getChildren().add(new Ball(x, y, radius)); // Place a ball into this pane
        }
        getChildren().add(redBall);//adds one red ball
        // Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(5), e -> moveBall()));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }

    public void play() {
        animation.play();
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
        double xChange, yChange;
        for (Node node : this.getChildren()) {
            Ball ball = (Ball) node;
            //   redBall = (RedBall) node;
            // wraps ball from top to bottom and side to side
            if (ball.getCenterX() < 0 - ball.getRadius()) {
                xChange = getWidth() + radius;
                ball.setCenterX(xChange);
            }
            if (ball.getCenterX() > getWidth() + ball.getRadius()) {
                xChange = -radius;
                ball.setCenterX(xChange);// Change ball move direction
            }
            if (ball.getCenterY() < 0 - ball.getRadius()) {
                yChange = getHeight() + radius;
                ball.setCenterY(yChange);
            }
            if (ball.getCenterY() > getHeight() + ball.getRadius()) {
                yChange = -radius;
                ball.setCenterY(yChange);
            }
            
//            Iterator<Ball> iter = ball.nodeIterator();
//            while (iter.hasNext()) {
//                ball = iter.next();
//                if (redBall.intersects(ball.getBoundsInLocal())) {
//                    redBall.dx *= -1;
//                    redBall.dy *= -1;
//                    getChildren().remove(ball);
//                }
//            }
//            }
            // Adjust ball position
            ball.setCenterX(ball.dx + ball.getCenterX());
            ball.setCenterY(ball.dy + ball.getCenterY());

            if (redBall.getCenterX() - ball.getCenterX() < 2 * radius && redBall.getCenterY() - ball.getCenterY() < 2 * radius) {
                getChildren().remove(ball);
                redBall.dx *= -1;
                redBall.dy *= -1;
                redBall.setCenterX(redBall.getCenterX());
                redBall.setCenterY(redBall.getCenterY());
            }
        }
    }

    protected void moveRedBall() {

        for (Node node : this.getChildren()) {
            Ball redBall = (Ball) node;
            // Check boundaries
            if (redBall.getCenterX() < redBall.getRadius()
                    || redBall.getCenterX() > getWidth() - redBall.getRadius()) {
                redBall.dx *= -1; // Change ball move direction
            }
            if (redBall.getCenterY() < redBall.getRadius()
                    || redBall.getCenterY() > getHeight() - redBall.getRadius()) {
                redBall.dy *= -1; // Change ball move direction
            }
            // Adjust ball position
            redBall.setCenterX(redBall.dx + redBall.getCenterX());
            redBall.setCenterY(redBall.dy + redBall.getCenterY());
        }
    }

    public void addBall(double newX, double newY) {
        getChildren().add(new Ball(newX, newY, radius)); // Place a ball into this pane
    }

//    }
    public boolean hasCollision() {
        if (redBall.getCenterX() < radius) {

        }
        redBall.getCenterY();
        return true;
    }

    @Override
    public org.w3c.dom.Node getRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWhatToShow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeFilter getFilter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getExpandEntityReferences() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public org.w3c.dom.Node nextNode() throws DOMException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public org.w3c.dom.Node previousNode() throws DOMException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//    public void hasCollision(Circle block) {
//        for (Iterator<Circle> it = ballList.iterator(); it.hasNext();) {
//            Circle checkBall = it.next();
//            if (checkBall.getBoundsInLocal().intersects(redBall.getBoundsInLocal())) {
//                getChildren().remove(checkBall);
//            }
//        }
//    }
//    static class Task extends TimerTask{
//        @Override
//        public void run(){
//            Random random = new Random();
//            int delay = random.nextInt(10);
//        }
//    }

