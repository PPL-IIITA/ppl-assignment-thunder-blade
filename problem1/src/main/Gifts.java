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
public class Gifts {
    int price, value, luxury_rating, difficulty, utility_value, utility_class;
    public void Essenetial_Gifts(int price, int value)
    {
        this.price = price;
        this.value = value;
    }
    
    public void Luxury_Gifts(int price, int value, int luxury_rating,int difficulty)
    {
        this.price = price;
        this.value = value;
        this.luxury_rating = luxury_rating;
        this.difficulty = difficulty;
    }
    
    public void Utility_Gifts(int price, int value, int uility_value, int utility_class)
    {
        this.price = price;
        this.value = value;
        this.utility_value = utility_value;
        this.utility_class = utility_class;
    }
    
}
