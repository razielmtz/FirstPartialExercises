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
public class MyCircle {
    //Declaration of Atributes
    private MyPoint center;
    private int radius;
    //Initialize Atributes
    public MyCircle(){
        this.center = new MyPoint(); // this is equal to (0,0) as a default vaule
        this.radius = 1; //defult value
    }
    public MyCircle(int x, int y, int radius){
        center = new MyPoint(x,y); //Create a new point for the center
        this.radius = radius; 
    }
    public MyCircle(MyPoint center, int radius){
        this.center = center;
        this.radius = radius;
    }
    //Getters and Setters
    public int getCenterX(){
        return this.center.getX();
    }
    public void setCenterX(int x){
        this.center.setX(x);
    }
    public int getCenterY(){
        return this.center.getY();
    }
    public void setCenterY(int y){
        this.center.setY(y);
    }
    public int[] getCenterXY(){
        return this.center.getXY();
    }
    public void setCenterXY(int x, int y){
        this.center.setXY(x, y);
    }
    @Override
    public String toString(){ //Returns String
        return "MyCircle[radius = " + this.radius + ",center = [" + center + ")]";
    }
    public double getArea(){ //Obtain the circle area with the formula PI*r^2
        return Math.PI * Math.pow(this.radius,2);
    }
    public double getCircumference(){ //Obtain the circumference with the formula PI*2r
        return Math.PI * (this.radius *2);
    }
    public double distance(MyCircle another){ //Obtain the distance between the center of this circle and another center
        return center.distance(another.center);
    }
}
