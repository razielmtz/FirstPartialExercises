/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo1;

/**
 *
 * @author Raziel 2
 */
public class BankAccount { //Bank account's attributes
    private String owner; // Name of the account's owner
    private int number; // Account's number
    private float balance; // Balance of the account
    private float interest; // Account's interest
    
    public BankAccount(){
        owner = "";
        number = 0;
        balance = 0;
        interest = 0f;
    }
    public BankAccount(String owner, int number, int balance, float interest){
    this.owner = owner;
    this.number = number;
    this.balance = balance;
    this.interest = interest;
    }
    
    // color Getter and Setter
    public String getOwner() { // get owner variable
       return owner; 
    }
    public void setOwner(String ownerName){ // set owner variable
        if ((ownerName == null ) || (ownerName == "")){ //If there is no name
            this.owner = "No defined name"; 
        } else {                             // Else
        this.owner = ownerName; 
        }
}
    public int getNumber(){ // get number variable
        return number;
    }
    public boolean setNumber(int number){ // set number variable
        if (number <= 0){ // If the number is less or equals 0 then
            return false;
        } else {          // Else 
            return true;
        }
    }
    public float getBalance() { //get balance variable
       return balance; 
    }
    public void setBalance(float balance){ // set balance variable
        if (balance > 0f ){
            this.balance = balance;
        } else { 
        this.balance = 0f ;
        }
}
    
    public float getInterest(){ // get interest variable
        return this.interest;
    }
    public void setInterest(float annualInterest) { // set interest variable
        if (annualInterest > 0f ){
            this.interest = annualInterest;
        } else { 
        this.interest = 0f ;
        }
}
    
}