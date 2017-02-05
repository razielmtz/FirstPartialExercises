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
    private MyPoint center;
    private int radius;
    
    public MyCircle(){
        this.center = new MyPoint();
        this.radius = 1;
    }
    public MyCircle(int x, int y, int radius){
        center = new MyPoint(x,y);
        this.radius = radius;
    }
    public MyCircle(MyPoint center, int radius){
        this.center = center;
        this.radius = radius;
    }
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
    public String toString(){
        return "MyCircle[radius = " + this.radius + ",center = [" + center + ")]";
    }
    public double getArea(){
        return Math.PI * Math.pow(this.radius,2);
    }
    public double getCircumference(){
        return Math.PI * (this.radius *2);
    }
    public double distance(MyCircle another){
        return center.distance(another.center);
    }
}
