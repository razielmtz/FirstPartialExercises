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
public class MyRectangle {
    //Declaration of Atributes
    private MyPoint topLeft; 
    private MyPoint bottomRight;
    //Initialize Atributes
    public MyRectangle(int x1, int y1, int x2, int y2){ // 2 points: at topLeft corner(x1,y1) and (x2,y2) at bottomRight corner
        topLeft = new MyPoint(x1,y1); //Create a new point for the top-left corner using the MyPoint class
        bottomRight = new MyPoint(x2,y2);// Create a new Point for the bottom-right corner using the MyPoint class
    }
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight){ 
        this.topLeft = topLeft;//
        this.bottomRight = bottomRight;
    }
    @Override 
    public String toString(){ //return String
        return "MyRectangle[ topleft = " + topLeft + ",bottomRight = " + bottomRight + "]";
    }
    public double getArea(){ //Obtain the area using a formula and getting the values from MyPoint class
        return ((Math.abs(topLeft.getX()-bottomRight.getX()))*(Math.abs(topLeft.getY()-bottomRight.getY())));
    }
    public double getPerimeter(){ //Obtain the perimeter using a formula and getting the values from MyPoint class
        return (Math.abs(topLeft.getX()-bottomRight.getX())+Math.abs(topLeft.getY()-bottomRight.getY()))*2;
    }
}
