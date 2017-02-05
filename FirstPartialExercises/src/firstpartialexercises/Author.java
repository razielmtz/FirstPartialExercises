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
public class Author {
    //AtributesDeclaration
    private String name;
    private String email;
    private char gender;
    // Initialize atributes
    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    //Getters and Setters
    public String getName(){
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public char getGender() {
        return this.gender;
    } 
    @Override
    public String toString() { //return String
        return "Author[" + "name = " + name + ", email = " + email + ", gender = " + gender + ']';
    }
}
