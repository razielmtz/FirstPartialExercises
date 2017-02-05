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
public class Circle1 {
    //Atributes declaration
    private double radius;
    private String color;
    //this(1.0,"red");
    
    //Constructors
    //Initialize Atributes
    public Circle1(){
        radius = 1.0;
        color = "red";
    }
    public Circle1(double radius){
        this.radius = radius;
        this.color = "red"; // Default vaule
        //this(radius, "red");
    }
    public Circle1(String color){
        this.radius = 1.0; //Default value
        this.color = color;
        //this(1.0,color);
    }
    public Circle1(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    //Getters and Setters
    public double getRadius(){
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() { //Returns String
        return  "Circle1{" + "radius=" + this.radius + ", color=" + this.color + '}';
    }
    public double getArea(){ //get Circle Area
        return this.radius * this.radius * Math.PI;
    }   
}
