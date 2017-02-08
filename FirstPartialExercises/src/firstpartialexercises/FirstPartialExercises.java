/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstpartialexercises;

/**
 *
 * @author Raziel 2
 */
public class FirstPartialExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //tester of MyRectangle class
      MyRectangle rectangle = new MyRectangle(1,7,4,2);  //topLeft(1,7) bottomRight(4,2)
      System.out.println(rectangle);  //Prints the String
      System.out.println("Area is " + rectangle.getArea());  //Print area of the rectangle
      System.out.println("Perimeter is " + rectangle.getPerimeter());  //Print perimeter of the rectangle
      //Time tester
      Time myTime = new Time(9,8,10);
      System.out.println(myTime.toString());
      System.out.println(myTime.nextSecond());
      System.out.println(myTime.getMinute());
    }
}
