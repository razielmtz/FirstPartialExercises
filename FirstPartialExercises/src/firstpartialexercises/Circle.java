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
public class Circle { //declaration of the atributes of the class
    private double radius;
    //Initialize atributes
    //Constructors
    public Circle(){ //radius = 1
        this(1.0);
    }
    public Circle(double radius){ 
        this.radius = radius;
    }
    //getters and setters
    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double Area(){ // formula of the area: =  pi*r^2
        return this.radius * this.radius * Math.PI;
    }
    public double getCircumference(){ // formula foor the circunference:  2pi*diameter, diameter is = 2*r
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() { //Returns String
        return "Circle{radius" + this.radius + '}';
    }
}