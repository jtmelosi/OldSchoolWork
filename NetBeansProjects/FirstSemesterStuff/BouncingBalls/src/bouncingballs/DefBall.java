/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.Random;

public class DefBall extends Circle {

    Random rand = new Random();
    public double dx, dy;

    public DefBall(double x, double y, double radius) {
        super(x, y, radius);
        setFill(Color.GREEN); // Sets ball color
        dx = rand.nextInt(20) - 10;
        dy = rand.nextInt(20) - 10;

        // Prevents them from not moving
        if (dx == 0 && dy == 0) {
            if (dx == 0) {
                dx++;
            }
            if (dy == 0) {
                dy++;
            }
        }
    }

    // These two methods set the direction and speed of the ball
    public double setDX(double dx) {
        this.dx = dx;
        return this.dx;
    }

    public double setDY(double dy) {
        this.dy = dy;
        return this.dy;
    }
}
