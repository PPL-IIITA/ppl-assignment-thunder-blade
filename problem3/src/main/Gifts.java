/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author arun
 */
public class Gifts extends Gifts_common{
    int price, value, luxury_rating, difficulty, utility_value, utility_class;

    public Gifts(int price, int value) {
        super(price, value);
    }
    public void Essenetial_Gifts(int price, int value)
    {
    
    }
    
    public void Luxury_Gifts(int price, int value, int luxury_rating,int difficulty)
    {
     
        this.luxury_rating = luxury_rating;
        this.difficulty = difficulty;
    }
    
    public void Utility_Gifts(int price, int value, int uility_value, int utility_class)
    {
        this.utility_value = utility_value;
        this.utility_class = utility_class;
    }
    
}
