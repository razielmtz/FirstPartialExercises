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
public class MyTriangle {
    //Declaration of Atributes
    private MyPoint v1; 
    private MyPoint v2;
    private MyPoint v3;
    
    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        //create the 3 points of the triangle using MyPoint class
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }
    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    @Override
    public String toString(){ //return String
        return "MyTriangle[v1 = " + v1 + ",v2 = " + v2 + ",v3 = " + v3 + "]";
    }
    public double getPerimetrer(){ //obtain the perimeter 
        return v1.distance(v2)+v2.distance(v3)+v3.distance(v1); //use the method distance of MyPoint class
    }
    public String getType(){ //Obtain the type of triangle according to it sides.
        double a,b,c; //declare 3 variables
        a = v1.distance(v2);
        b = v2.distance(v3);
        c = v3.distance(v1);
        if(a == b && b == c && c==a){ // If al the sides are the same
            return "Equilateral";
        } else if(a != b && b != c && c != a ){ //If all the sides are different
            return "Scalene";
        }else{                        //If the previous is false then...
            return "Isosceles";
        }
    }
}
