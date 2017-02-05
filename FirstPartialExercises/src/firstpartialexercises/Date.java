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
public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;        
    }
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override 
    public String toString(){
        return String.format("%02",this.day) + "/"
               + String.format("%02",this.month) + "/"
               + String.format("%04",this.year);
    }
}
