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
      MyRectangle rectangle = new MyRectangle(1,7,4,2);  
      System.out.println(rectangle);  
      System.out.println("Area is " + rectangle.getArea());  
      System.out.println("Area is " + rectangle.getPerimeter());  
    }
}
