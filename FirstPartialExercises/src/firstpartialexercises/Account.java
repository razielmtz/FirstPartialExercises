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
    private String id;
    private String name;
    private int balance;
    
    public Account(String id, String name){
        this(id, name, 0);
    }
    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
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
        this.balance += amount;
        return this.balance;
    }
    public int debit(int amount){
        if (amount <= this.balance){
            this.balance -= amount;
        }else{ System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }
    public int transferTo(Account another, int amount){
        if (amount <= this.balance){
            another.credit(amount);
            this.balance -= amount;
        }else{ System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }
    @Override
    public String toString(){
        return "Account[id = " + this.id +  " name = " + this.name + " balance = " + this.balance + "]";
    }
}
