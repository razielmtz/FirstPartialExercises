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
public class Time {
    //Declaration of variables
    private int hour;
    private int minute;
    private int second;
    //Initialize atributes
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = hour;
        this.second = second;
    }
    public Time(){ //Default values
        this.second = 0; 
        this.minute = 0;
        this.hour = 0;
    }
    public int getHour() {
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() { //returns String
        return String.format("%02d",this.hour) + ":" //%02d for 2 digits double
               + String.format("%02d",this.minute) + ":"
               + String.format("%02d",this.second);
    }
    public Time nextSecond(){ //show the next second
        ++this.second; //increase second by 1
        if(this.second>=60){ //if second is greate or equal than 
            this.second = 0; // then second = o
            ++this.minute; // also incresase minute
            if(this.minute>=60){ //if minute is greate than equal to 60
                this.minute=0; // then minute = 0
                ++this.hour; // also increase hour by 1
                if(this.hour>=24){ //if hour is greater or equal 24
                    this.hour = 0; //then hour is 0
                }
            }
        }
        return this;
    }
    public Time previousSecond(){
        --this.second; //decrease second by 1
        if(this.second<0){ //if second is less than 0
            this.second = 59;//then second = 59
            --this.minute; // also decrease minute by 1
            if(this.minute<0){ //If minute is equl to 0
                this.minute=59; //then minute is equl to 59
                --this.hour; // also decrease hour by 1
                if(this.hour<0){ // if hour is less than 0
                    this.hour = 23; //hour is equal to 23
                }
            }
        }
        return this;
    }
}
