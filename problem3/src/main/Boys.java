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
public class Boys extends Person{
    String name, status, girlfriend, type;
    int attractiveness, girlfriend_budget, intelligence, happiness,minimum_attraction;
    Boys(String name,int attractiveness,int girlfriend_budget, int intelligence, String type, int minimum_attraction)
    {
        super(name, intelligence, attractiveness);
        this.girlfriend_budget = girlfriend_budget;
        this.girlfriend = "";
        this.type = type;
        this.minimum_attraction = minimum_attraction;
    }
    
    public boolean Is_Boy_Affordable(int budget)
    {
        if(budget <= girlfriend_budget)
            return true;
        return false;
    }
}
