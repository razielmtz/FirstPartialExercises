package firstpartialexercises;


import firstpartialexercises.Author;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raziel 2
 */
public class book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;
    
    public book(String name, Author[] author, double price){
        this.name = name;
        this.authors = authors;
        this.price = price;
    }
    public book(String name, Author[] author, double price, int qty){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }
    public String getName(){
        return this.name;
    }
    public Author[] getAuthors(){
        return this.authors;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public int getQty(){
        return this.qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    @Override
    public String toString(){
        return "Book[name = " + this.name + ",authors = {" + getAuthorNames() + ", price = " + this.price 
                + ",qty = " + this.qty + "]";
    }
    public String getAuthorNames(){
        String an = "";
        for(int i=0;i<authors.length;i++){
        an += authors[i].toString() + ",";
        }
        return "author names=" + an;
    }
}
