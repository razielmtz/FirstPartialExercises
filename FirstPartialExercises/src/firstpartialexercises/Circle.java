package firstpartialexercises;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raziel 2
 */
public class Circle {
    private double radius;
    
    public Circle(){
        this(1.0);
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double Area(){
        return this.radius * this.radius * Math.PI;
    }
    public double getCircumference(){
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{radius" + this.radius + '}';
    }
}