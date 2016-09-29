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

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.Iterator;

public class Ball extends Circle {

    public double dx, dy;
    Random rand = new Random();
    double newDx;
    double newDy;

    Ball(double x, double y, double radius) {
        super(x, y, radius);
        setFill(Color.GREEN); // Set ball color
        dx = rand.nextInt(20) - 10;
        dy = rand.nextInt(20) - 10;
    }

//    public double setDx(double dx) {
//        newDx = -1;
//        newDx *= dx;
//        return newDx;
//    }
//
//    public double setDy(double dy) {
//        newDy = -1;
//        newDy *= dy;
//        return newDy;
//    }
//
//    public boolean hasCollision(Ball b1, Ball b2) {
//        boolean hasCollision = false;
//        if  (b1.intersects(b2.getBoundsInLocal())) {
//            hasCollision = true;
//        }
//
//        return hasCollision;
//    }

}


