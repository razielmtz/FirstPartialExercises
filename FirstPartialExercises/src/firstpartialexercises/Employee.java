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
public class Employee {
    //Declaration of Atributes
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    //Initialize Atributes
    public Employee(int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    //Getters and Setters
    public int getId() {
        return this.id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getName(){
        return this.firstName + " " + this.lastName;
    }
    public int getSalary() {
        return this.salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAnnualSalary(){
        return this.salary * 12;
    }
    public int raiseSalary(int percent){ // Add percente of salary 
        this.salary += this.salary * percent /100; //add the percent of the salary to the salary
        return this.salary;
    }
    @Override
    public String toString(){ //Return String
        return "Employee[id = " + this.id + "Name = " + this.getName() + "Salary =" + this.salary + "]";
    }
}

