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

import javafx.scene.paint.Color;

public class RedBall extends Ball {

    RedBall(double x, double y, double radius) {
        super(x, y, radius);
        setFill(Color.RED);
        dx = rand.nextInt(20) - 10;
        dy = rand.nextInt(20) - 10;
    }

//    @Override
//    public boolean hasCollision() {
//
//        return true;
//    }
}

//    public double shiftRedDx() {
//        double newRedDx = 0;
//        newRedDx = rand.nextInt(20) - 10;
//        return newRedDx;
//    }
//
//    public double shiftDy() {
//        double newRedDy = 0;
//        dy = rand.nextInt(20) - 10;
//        return newRedDy;
//    }
//    public int randomTimer(){
//        int seconds = rand.nextInt(10);
//    return seconds;}

