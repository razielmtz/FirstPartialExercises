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
public class Account {
    //Atributes Declaration
    private String id;
    private String name;
    private int balance;
    //Initialize Atributes
    public Account(String id, String name){
        this(id, name, 0); 
    }
    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    //Getters and Setters
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getBalance() {
        return this.balance;
    }
    public int credit(int amount){ 
        this.balance += amount; //Add the amount to the balance
        return this.balance;
    }
    public int debit(int amount){
        if (amount <= this.balance){ //If the amount is less or equal than balance
            this.balance -= amount;  //Substract the amount from the balance
        }else{ System.out.println("Amount exceeded balance"); //If not, return the message
        }
        return this.balance; //If true, return balance
    }
    public int transferTo(Account another, int amount){
        if (amount <= this.balance){ //If the amount is less or equal than balance
            another.credit(amount); //add the amount to that balance
            this.balance -= amount; //rest the amount of this balance
        }else{ System.out.println("Amount exceeded balance"); // If not, return message
        }
        return this.balance; //If true, return the current balance
    }
    @Override
    public String toString(){ //return String
        return "Account[id = " + this.id +  " name = " + this.name + " balance = " + this.balance + "]";
    }
}
